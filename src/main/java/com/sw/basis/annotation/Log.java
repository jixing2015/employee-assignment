package com.sw.basis.annotation;

import java.lang.annotation.*;

/**
 * 日志
 * @author jixing2000
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
@Documented
@Inherited
public @interface Log {

	/**
	 * 日志类型
	 **/
	enum LOG_TYPE {
		/** 新增 **/
		ADD,
		/** 修改 **/
		UPDATE,
		/** 删除 **/
		DEL,
		/** 查询 **/
		SELECT,
		/** 用户 **/
		ATHOR,
		/** 用户 **/
		ADD_OR_UPDATE
	}

	/**
	 * 内容
	 */
	String desc();

	/**
	 * 类型 curd
	 */
	LOG_TYPE type() default LOG_TYPE.ATHOR;
}
