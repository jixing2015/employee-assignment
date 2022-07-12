package com.sw.basis.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sw.basis.dto.ReturnMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 描述:通过封装applicationContext上线文 获取 spring bean对象
 * @author jsxzshd
 */
@Component
@Slf4j
public class SpringUtil implements ApplicationContextAware {

	public static String appContextName;
	static ObjectMapper objMapper;

	@Value("${server.servlet.context-path}")
	public void setAppContext(String contextName) {
		appContextName = contextName;
	}

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if (SpringUtil.applicationContext == null) {
			SpringUtil.applicationContext = applicationContext;
		}
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * * 根据name获取bean
	 *
	 * @param name
	 * @param      <T>
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		return (T) getApplicationContext().getBean(name);
	}

	public static <T> T getBean(Class<T> clazz) {
		return getApplicationContext().getBean(clazz);
	}

	public static <T> T getBean(String name, Class<T> clazz) {
		return getApplicationContext().getBean(name, clazz);
	}

	public static Object getBeanByName(String name) {
		return getApplicationContext().getBean(name);
	}

	static List<Map<String, String>> urlList = new ArrayList<Map<String, String>>();

	public static List<Map<String, String>> getAllUrl() {
		if (urlList.isEmpty()) {
			RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
			// 获取url与类和方法的对应信息
			Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();

			for (Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {
				Map<String, String> map1 = new HashMap<String, String>();
				RequestMappingInfo info = m.getKey();
				HandlerMethod method = m.getValue();
				PatternsRequestCondition p = info.getPatternsCondition();
				for (String url : p.getPatterns()) {
					map1.put("url", url);
				}
				// 类名
				map1.put("className", method.getMethod().getDeclaringClass().getName());
				// 方法名
				map1.put("method", method.getMethod().getName());
				RequestMethodsRequestCondition methodsCondition = info.getMethodsCondition();
				for (RequestMethod requestMethod : methodsCondition.getMethods()) {
					map1.put("type", requestMethod.toString());
				}
				urlList.add(map1);
			}
		}
		return urlList;
	}

	public static void reponseMessage(HttpServletResponse response, ReturnMessage msg) throws IOException {
		response.setContentType("application/json; charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.print(ReturnMessage.toJson(msg));
		pw.flush();
		pw.close();
	}

	public static String getClassName(Object obj) {
		return obj.getClass().getName();
	}

	public static String getMethodName(Thread t) {
		// Thread.currentThread
		StackTraceElement[] stackTrace = t.getStackTrace();
		String methodName = stackTrace[3].getMethodName();
		return methodName;
	}

	public static String getOperationFullName(Object o, Thread t) {
		String clsName = o.getClass().getName();
		String mtdName = getMethodName(t);
		return clsName + "::" + mtdName;
	}

	public static ObjectMapper getObjectMapper() {
		if (objMapper == null) {
			objMapper = getBean(ObjectMapper.class);
		}
		return objMapper;
	}

	public static String toJson(Object obj) throws JsonProcessingException {
		getObjectMapper();
		return objMapper.writeValueAsString(obj);
	}

	public static <T> T parseJson(String json, Class<T> c) {
		getObjectMapper();
		T obj;
		try {
			obj = objMapper.readValue(json, c);
		} catch (Exception e) {
			log.error("parseJson", e);
			obj = null;
		}
		return obj;
	}

}
