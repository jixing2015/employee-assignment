package com.sw.basis.service;

import org.springframework.stereotype.Component;

/**
 * 序列表 service
 * @author jsxzshd
 **/
@Component
public interface SeqService {

	/**
	 * 返回ID，然后自动加一
	 * 
	 * @param seqName AppServiceSeqName
	 * @return
	 */
	int nextValue(String seqName) ;

	int getNowMaxValue(String seqName) ;

	/**
	 * 一次取n个值
	 * @param seqName 名称
	 * @param n n
	 * @return 值
	 **/
	int[] nextValues(String seqName, int n) ;
}
