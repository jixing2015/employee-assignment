package com.sw.basis.utils;

import com.sw.basis.service.SeqService;

/**
 * 序列工具类
 * @author jixing2000
 **/

public class SeqUtil {

	public static SeqService seqService = SpringUtil.getBean("seqServiceImpl");
	/**
	 * seqName，每个service有一个。直接放在这里了
	 */
	public interface ServiceSeqName {

		String DISPATCH_RECORD = "dispatch_record";
		String DISPATCH_PROJECT = "dispatch_project";
		String DISPATCH_PEOPLES = "dispatch_peoples";
		String FLOW = "flow";
		String PROJECT = "project";
		String SECONDMENT_RECORD = "secondment_record";
		String SECONDMENT_DEMAND = "secondment_demand";
		String SECONDMENT_PEOPLES = "secondment_peoples";
		String SYS_DEPT = "sys_dept";
		String SYS_DICT = "sys_dict";
		String SYS_LOG = "sys_log";
		String SYS_MENU = "sys_menu";
		String SYS_ROLE = "sys_role";
		String SYS_ROLE_MENU = "sys_role_menu";
		String SYS_SETTINGS = "sys_settings";
		String SYS_USER = "sys_user";
		String SYS_USER_ROLE = "sys_user_role";
		String DEPT_ROLES = "dept_roles";
		String BUSINESS_LINE = "business_line";
		String RANK_RATE = "rank_rate";
		String SECONDED_PERSONNEL = "seconded_personnel";
		String SYS_VACATION = "sys_vacation";


	}

	public static int nextValue(String seqName) {

		return SeqUtil.seqService.nextValue(seqName);
	}

	public static int getNowMaxValue(String seqName) {

		return SeqUtil.seqService.getNowMaxValue(seqName);
	}

	public static int[] nextValues(String seqName, int n) {

		return SeqUtil.seqService.nextValues(seqName, n);
	}

}
