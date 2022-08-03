package com.sw.basis.annotation;


import com.sw.basis.entity.SysLogEntity;
import com.sw.basis.service.SysLogService;
import com.sw.basis.utils.IpUtil;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 日志
 * @author jixing2000
 **/
@Aspect
@Component
public class LogAspect {

	public static final Logger log = LoggerFactory.getLogger(LogAspect.class);

	@Resource
	private SysLogService logService;

	@Pointcut("@annotation(com.sw.basis.annotation.Log)")
	private void pointcut() {

	}
	
	@Value(value = "${server.servlet.context-path}")
	private String urlContextPath;

	@After("pointcut()")
	public void insertLogSuccess(JoinPoint jp) {
		//todo 暂时不新增日志
//		addLog(jp, getDesc(jp));
	}

	private void addLog(JoinPoint jp, String actionName) {
		StringBuffer buffer = null;
		try {
			Log.LOG_TYPE type = getType(jp);
			SysLogEntity sysLogEntity = new SysLogEntity();
			RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
			// 一些系统监控
			if (requestAttributes != null) {
				HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
						.getRequest();
				String ip = IpUtil.getIpAddr(request);
				sysLogEntity.setIp(ip);
				
				StringBuffer url = request.getRequestURL();
				if (StringUtils.isNotBlank(url)) {
					String[] urlArr = url.toString().split(urlContextPath);
					if (1 < urlArr.length) {
						sysLogEntity.setUrl(urlArr[1]);
					}
				}
			}
			sysLogEntity.setMethodType(type.toString());
			sysLogEntity.setActionName(actionName);

			Object[] obj = jp.getArgs();
			buffer = new StringBuffer();
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					Object o = obj[i];
					if (o instanceof Model || o instanceof HttpServletRequest) {
						continue;
					}

					buffer.append("[参数" + (i + 1) + ":");
					String parameter = null;
					try {
						parameter = com.alibaba.fastjson.JSON.toJSONString(o);
					} catch (Exception e) {
						continue;
					}
					buffer.append(parameter);
					buffer.append("]");
				}
			}
			sysLogEntity.setParam(buffer.toString());
			logService.addSysLog(sysLogEntity);
			buffer.setLength(0);
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			if (buffer != null) {
				try {
					buffer.setLength(0);
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}
		}
	}

	/**
	 * 记录异常
	 *
	 * @param joinPoint
	 * @param e
	 */
	@AfterThrowing(value = "pointcut()", throwing = "e")
	public void afterException(JoinPoint joinPoint, Exception e) {
//		addLog(joinPoint, getDesc(joinPoint) +"["+ e.getMessage()+"]");
	}

	private String getDesc(JoinPoint joinPoint) {
		MethodSignature methodName = (MethodSignature) joinPoint.getSignature();
		Method method = methodName.getMethod();
		return method.getAnnotation(Log.class).desc();
	}

	private Log.LOG_TYPE getType(JoinPoint joinPoint) {
		MethodSignature methodName = (MethodSignature) joinPoint.getSignature();
		Method method = methodName.getMethod();
		return method.getAnnotation(Log.class).type();
	}
}
