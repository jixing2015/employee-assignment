package com.sw.basis.utils.restful;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

/**
 * 页面返回
 * @author jixing2000
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {

	private Collection<T> list;
	/**
	 * 页码
	 */
	private int pageNo;
	/**
	 * 每页数据条数
	 */
	private int pageSize;
	/**
	 * 总页数
	 */
	private long pageTotal;

}
