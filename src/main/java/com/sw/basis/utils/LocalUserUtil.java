package com.sw.basis.utils;

import com.sw.basis.utils.exception.MyException;
import com.sw.basis.entity.SysUserEntity;

/**
 * 全局用户信息
 * @author jsxzshd
 **/
public class LocalUserUtil {

	/**
	 * 保存SyUser，在拦截器中添加、删除相关用户数据
	 */
	private static final ThreadLocal<SysUserEntity> USER_ENTITY_THREAD_LOCAL = new ThreadLocal<SysUserEntity>();

	/**
	 * 在拦截器方法执行前调用设置获取用户
	 */
	public static void addCurrentUser(SysUserEntity user) {
		if(user == null){
			throw new MyException("用户信息为空");
		}
		USER_ENTITY_THREAD_LOCAL.set(user);
	}

	/**
	 * 获取当前登录用户
	 */
	public static SysUserEntity getCurrentUser() {
		return USER_ENTITY_THREAD_LOCAL.get();
	}

	/**
	 * 删除当前用户
	 */
	public static void removeCurrentUser() {
		USER_ENTITY_THREAD_LOCAL.remove();
	}

}
