package com.sw.basis.service.impl;


import com.sw.basis.service.SeqService;
import com.sw.basis.utils.RedisTemplateUtils;
import com.sw.basis.utils.constant.RedisConstant;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 序列表 service
 * @author jixing2000
 **/
@Component
public class SeqServiceImpl implements SeqService {

	@Resource
	private RedisTemplateUtils redisUtil;

	/**
	 * 返回ID，然后自动加一
	 * 
	 * @param seqName AppServiceSeqName
	 * @return
	 */
	@Override
	public int nextValue(String seqName) {

		Long val = redisUtil.hincr(RedisConstant.HKEY, seqName, RedisConstant.APPLY_ID_BY);
		return val.intValue();
	}

	@Override
	public int getNowMaxValue(String seqName) {

		Long val = redisUtil.hget(RedisConstant.HKEY, seqName, Long.class);
		return val.intValue();
	}

	/**
	 * 一次取n个值
	 * @param seqName 名称
	 * @param n n
	 * @return 值
	 **/
	@Override
	public int[] nextValues(String seqName, int n) {

		Long val = redisUtil.hincr(RedisConstant.HKEY, seqName, n);

		int[] rtv = new int[n];
		int start = val.intValue() - n + 1;
		for (int i = 0; i < n; i++) {
			rtv[i] = start + i;
		}
		return rtv;
	}
}
