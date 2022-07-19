package com.sw.basis.utils.exception;

/**
 * 异常
 * @author jixing2000
 **/
public class MyException extends RuntimeException {

	private static final long serialVersionUID = -1696914339198746347L;
	private String message;

	public MyException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
