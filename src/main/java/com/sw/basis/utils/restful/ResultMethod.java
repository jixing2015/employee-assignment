package com.sw.basis.utils.restful;

import java.util.Collection;
import java.util.Map;

/**
 * 返回restful结果数据组装方法
 * @author jixing2000
 */
public class ResultMethod {

	protected <T> ResultData<T> success() {
		return new ResultData<>();
	}

	protected <T> ResultData<T> success(Collection<T> list) {
		return new ResultData<>(list);
	}

	protected <T> ResultData<T> success(T entity) {
		return new ResultData<>(entity);
	}

	protected <T> ResultData<T> success(Map<String, Object> data) {
		return new ResultData<>(data);
	}

	protected <T> ResultData<T> success(Collection<T> list, int pageIndex, int pageSize, long pageCount) {
		return new ResultData<>(new PageResult<>(list, pageIndex, pageSize, pageCount));
	}

	protected <T> ResultData<T> success(PageResult<T> pageResult) {
		return new ResultData<>(pageResult);
	}

	protected <T> ResultData<T> error() {
		return new ResultData<>(ResultCode.ERROR.code.toString());
	}

	protected <T> ResultData<T> exception() {
		return new ResultData<>(ResultCode.ERROR.code.toString());
	}

	protected <T> ResultData<T> error(String message) {
		return new ResultData<>(ResultCode.ERROR.code.toString(), message);
	}

	protected <T> ResultData<T> ret(String code, String message) {
		return new ResultData<>(code, message);
	}

	protected <T> ResultData<T> ret(ResultCode resultCode, String message) {
		return new ResultData<>(resultCode.code.toString(), message);
	}

	protected <T> ResultData<T> ret(ResultCode resultCode) {
		return new ResultData<>(resultCode.code.toString(), resultCode.message);
	}
}
