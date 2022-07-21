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
			throw new MyException(ResultCode.USER_NOT_FOUND.code,ResultCode.USER_NOT_FOUND.message);
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
