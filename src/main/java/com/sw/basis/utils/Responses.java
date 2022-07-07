package com.sw.basis.utils;

import com.sw.basis.utils.enums.ResponseCode;
import com.sw.basis.utils.enums.ResultCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 公用信息
 * @author jixing2000
 **/
@ApiModel(value = "Responses", description = "响应信息")
@Data
public class Responses<T> {

	@ApiModelProperty("响应编码")
	private Integer error;

	@ApiModelProperty("响应消息")
	private String msg;

	@ApiModelProperty("响应体")
	private T result;

	public Responses() {

	}

	private Responses(ResponseCode code, String msg, T result) {
		this.error = code.getCode();
		this.msg = msg;
		this.result = result;
	}

	private Responses(Integer error, String msg, T result) {
		this.error = error;
		this.msg = msg;
		this.result = result;
	}

	public boolean notSuccess() {
		return !(ResponseCode.SUCCESS_CODE.getCode().equals(error));
	}

	public static <T> Responses<T> success() {
		return new Responses<>(ResponseCode.SUCCESS_CODE, ResponseCode.SUCCESS_CODE.getDefaultMsg(), null);
	}

	public static <T> Responses<T> success(T result) {
		return new Responses<>(ResponseCode.SUCCESS_CODE, ResponseCode.SUCCESS_CODE.getDefaultMsg(), result);
	}

	public static <T> Responses<T> success(String msg, T result) {
		return new Responses<>(ResponseCode.SUCCESS_CODE, msg, result);
	}

	public static <T> Responses<T> error(String msg) {
		return new Responses<>(ResponseCode.ERROR_CODE, msg, null);
	}

	public static <T> Responses<T> error(ResponseCode code) {
		return new Responses<>(code, code.getDefaultMsg(), null);
	}

	public static <T> Responses<T> error(ResponseCode code, String msg) {
		return new Responses<>(code, msg, null);
	}

	public static <T> Responses<T> error(Integer code, String msg) {
		return new Responses<>(code, msg, null);
	}

	public static <T> Responses<T> error(ResultCode resultCode) {
		return new Responses<>(resultCode.code, resultCode.message, null);
	}

	public static <T> Responses<T> error(ResultCode resultCode, String message) {
		return new Responses<>(resultCode.code, message, null);
	}
}
