package com.sw.basis.utils.restful;

import com.google.common.collect.Maps;
import lombok.Data;

import java.util.Collection;
import java.util.Map;

/**
 * 返回数据
 * @author jixing2000
 **/
@Data
public class ResultData<T> {

	private String code;
	private String message;
	private Map<String, Object> data;

	public ResultData() {
		super();
		this.code = ResultCode.SUCCESS.code.toString();
		this.message = ResultCode.get(code);
		this.data = Maps.newHashMap();
	}

	public ResultData(String code) {
		this.code = code;
		this.message = ResultCode.get(code);
	}

	public ResultData(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public ResultData(Map<String, Object> data) {
		this();
		this.data = data;
	}

	public ResultData(Collection<T> list) {
		this();
		this.data.put(ResultConstant.LIST, list);
	}

	public ResultData(T t) {
		this();
		this.data.put(ResultConstant.OBJECT, t);
	}

	public ResultData(PageResult<T> pageResult) {
		this();
		this.data.put(ResultConstant.LIST, pageResult.getList());
		this.data.put(ResultConstant.PAGE_NO, pageResult.getPageNo());
		this.data.put(ResultConstant.PAGE_SIZE, pageResult.getPageSize());
		this.data.put(ResultConstant.PAGE_TOTAL, pageResult.getPageTotal());
	}

	public ResultData<T> set(String key, Object value) {
		if (this.data == null) {
			data = Maps.newHashMap();
		}
		this.data.put(key, value);
		return this;
	}

	public ResultData<T> setList(Collection<T> list) {
		if (this.data == null) {
			data = Maps.newHashMap();
		}
		this.data.put(ResultConstant.LIST, list);
		return this;
	}

	public ResultData<T> setObject(T t) {
		if (this.data == null) {
			data = Maps.newHashMap();
		}
		this.data.put(ResultConstant.OBJECT, t);
		return this;
	}

}
