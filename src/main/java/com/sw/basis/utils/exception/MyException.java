package com.sw.basis.utils.exception;

import com.sw.basis.utils.enums.ResultCode;
import lombok.Getter;

/**
 * 异常
 * @author jixing2000
 **/
@Getter
public class MyException extends RuntimeException {

	private Integer code;
	private String message;

	public MyException() {
		this(ResultCode.EXCEPTION.code, ResultCode.EXCEPTION.message);
	}

	public MyException(String message) {
		this(ResultCode.EXCEPTION.code,message);
	}

	public MyException(Integer code,String message) {
		super(message);
		this.code = code;
		this.message = message;
	}
}
