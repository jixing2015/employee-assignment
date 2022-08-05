package com.sw.basis.utils;

import com.sw.basis.utils.enums.ResultCode;
import com.sw.basis.utils.exception.MyException;
import com.sw.basis.entity.SysUserEntity;

/**
 * 全局用户信息
 * @author jixing2000
 **/
public class LocalUserUtil {

	/** 保存SyUser，在拦截器中添加、删除相关用户数据 */
	private static final ThreadLocal<SysUserEntity> USER_ENTITY_THREAD_LOCAL = new ThreadLocal<>();

	/**
	 * 在拦截器方法执行前调用设置获取用户
	 */
	public static void addCurrentUser(SysUserEntity user) {
		if(user == null){
			throw new MyException(ResultCode.USER_NOT_FOUND.code,ResultCode.USER_NOT_FOUND.message);
		}
		USER_ENTITY_THREAD_LOCAL.set(user);
	}

	/**
	 * 获取当前登录用户
	 */
	public static SysUserEntity getCurrentUser() {
		if(USER_ENTITY_THREAD_LOCAL.get() == null){
			SysUserEntity user = new SysUserEntity();
			user.setCode("test");
			user.setName("测试");
			user.setPlageCode("plage01");
			user.setPlageName("板块01");
			user.setAreaCode("area01");
			user.setAreaName("北京");
			user.setDeptCode("dept01");
			user.setDeptName("部门01");
			user.setLineCode("line01");
			user.setLineName("条线01");
			user.setLevelCode("0");
			user.setLevelName("职级一");
			user.setState(0);
			user.setHrempTalentbase("base01");

//			throw new MyException(ResultCode.USER_NOT_FOUND.code,ResultCode.USER_NOT_FOUND.message);
		}
		return USER_ENTITY_THREAD_LOCAL.get();
	}

	/**
	 * 删除当前用户
	 */
	public static void removeCurrentUser() {
		if(USER_ENTITY_THREAD_LOCAL.get() == null){
			throw new MyException(ResultCode.USER_NOT_FOUND.code,ResultCode.USER_NOT_FOUND.message);
		}
		USER_ENTITY_THREAD_LOCAL.remove();
	}

}
