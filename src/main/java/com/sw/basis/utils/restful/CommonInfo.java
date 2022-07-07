package com.sw.basis.utils.restful;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公用信息
 * @author jsxzshd
 **/
public class CommonInfo {
	/**
	 * 语言
	 **/
	public static String SYS_CONFIG_LANGUAGE = "zh";
	/**
	 * 项目名称
	 **/
	public static String CONST_APP_NAME = "centerportal";

	public static final String VARNAME_SSO_TOKEN_NAME = CONST_APP_NAME + "_" + "ssoToken";

	public static final String VARNAME_SESSION_USER = CONST_APP_NAME + "_" + "user";

//	public static final String VARNAME_SESSION_CURRENT_USER = CONST_APP_NAME + "_" + "currentUser";

	public static final String VARNAME_SESSION_USER_CODE = CONST_APP_NAME + "_" + "userCode";

	public static final String VARNAME_SESSION_LANGE = CONST_APP_NAME + "_" + "language";

	public static final String VARNAME_SESSION_ID_NAME = "Authorization";

	public static final Integer PARENT_ROOT = -1;

	public static final Integer PARENT_ZERO = 0;
	/**
	 * 管理员配置
	 **/
	public static final String ADMIN_ID = "1";
	/**
	 * 菜单根目录
	 **/
	public static final String MENU_ROOT_ID = "ROOT";
	/**
	 * 公司邮箱识别后缀
	 **/
	public static final String COMPANY_EMAIL_SUFFIX = "@shinewing.com";
	/**
	 * 项目菜单的权限标志
	 **/
	public static final String MENU_PROJECT_PERMISSION_CODE = "project";

	public interface RedisTemplateKey {
//
//		// 注册用户时使用
//		String REGISTRATION_USER_KEY = "registration_user_key";
//
//		// 文件上传时使用
//		String FILE_CUT_FILE_KEY = "file_cut_file_key";
	}
	/**
	 * minio 文件系统 桶的名称
	 **/
	public static final String MINIO_BUCKET_NAME = "center-portal";
	/**
	 * 文件保存时，保存前使用此前缀
	 **/
	public interface MinioFixedBucketName {

		public static final String PROJECT = "project";

		public static final String PROJECT_WORK_PAPER = "workpaper";

		public static final String PROJECT_ATTACHMENE = "attachment";

		public static final String WP_TEMPLATE = "wptemplate";

		// project_task_work_paper 项目底稿中保存文件时保存在以projectId为名的bucket中
	}

	public static final long MILLIS_PER_SECOND = 1000;

	public static final long MILLIS_PER_MINUTE = 60 * MILLIS_PER_SECOND;
	/**
	 * MILLIS_PER_HOUR
	 **/
	public static final long MILLIS_PER_HOUR = 60 * MILLIS_PER_MINUTE;
	/**
	 * 全选
	 **/
	public static final Integer ROLE_MENU_SELECTED = 1;
	/**
	 * 半选
	 **/
	public static final Integer ROLE_MENU_PARTIAL_SELECTED = 2;

	public interface DelFlag {
		Integer UN_DEL = 0;
		Integer DEL = 1;
	}

	public enum YesOrNoEnum {
		/**
		 * 不是、是
		 **/
		NO(0, "不是"), YES(1, "是");

		public int code;
		public String message;

		YesOrNoEnum(int code, String message) {
			this.code = code;
			this.message = message;
		}

		public static String get(int code) {
			YesOrNoEnum resultCode = Lists.newArrayList(values()).stream().filter((rc) -> rc.code == code).findFirst()
					.orElse(null);
			return resultCode == null ? null : resultCode.message;
		}
	}

	/**
	 * 结果的标志,0-失败;1-成功
	 */
	public enum SuccessedOrFailedEnum {
		/**
		 * 失败、成功
		 **/
		FAILED("失败", 0), SUCCESSED("成功", 1);

		public int value;
		public String name;

		SuccessedOrFailedEnum(String name, Integer value) {
			this.name = name;
			this.value = value;
		}

		public static String getName(Integer value) {
			SuccessedOrFailedEnum status = Lists.newArrayList(values()).stream().filter((rc) -> rc.value == value)
					.findFirst().orElse(null);
			return status == null ? "" : status.name;
		}
	}

	/**
	 * 员工登录权限状态enum 0-禁用;1-启用
	 */
	public enum AccountStatusEnum {
		/**
		 * 0-禁用;1-启用
		 **/
		disable("禁用", false), available("启用", true);

		public String name;
		public boolean value;

		AccountStatusEnum(String name, boolean value) {
			this.name = name;
			this.value = value;
		}

		public static String getName(boolean value) {
			AccountStatusEnum status = Lists.newArrayList(values()).stream().filter((rc) -> rc.value == value)
					.findFirst().orElse(null);
			return status == null ? "" : status.name;
		}

	}

	/**
	 * 系统菜单类型enum
	 */
	public enum SysMenuTypeEnum {
		/**
		 * 目录、菜单、按钮
		 */
		catalogue("目录", 1), menu("菜单", 2), button("按钮", 3);

		public String name;
		public int code;

		SysMenuTypeEnum(String name, int code) {
			this.name = name;
			this.code = code;
		}

		public static String getName(Integer code) {
			if (code == null) {
				return null;
			}
			SysMenuTypeEnum status = Lists.newArrayList(values()).stream().filter((rc) -> rc.code == code).findFirst()
					.orElse(null);
			return status == null ? "" : status.name;
		}
	}

	/**
	 * 员工职级enum
	 */
	public enum PostLevelEnum {
		/**
		 * 业务初级、业务中级、业务高级、项目经理(一)、项目经理(二)、副经理、经理、高级经理、总监、合伙人
		 */
		junior("业务初级", 1), middle("业务中级", 2), senior("业务高级", 3), manager1("项目经理(一)", 4), manager2("项目经理(二)", 5),
		deputyManager("副经理", 6), normalManager("经理", 7), seniorManager("高级经理", 8), director("总监", 9),
		partner("合伙人", 10);

		public String name;
		public int code;

		PostLevelEnum(String name, int code) {
			this.name = name;
			this.code = code;
		}

		public static String getName(Integer code) {
			if (code == null) {
				return null;
			}
			PostLevelEnum status = Lists.newArrayList(values()).stream().filter((rc) -> rc.code == code).findFirst()
					.orElse(null);
			return status == null ? "" : status.name;
		}

		/**
		 * 角色菜单的职级下拉数据
		 * @return list
		 **/
		public static List<Map<String, Object>> getPostLevelComboboxForRoleMenu() {
			List<Map<String, Object>> list = new ArrayList<>();
			for (PostLevelEnum level : PostLevelEnum.values()) {
				Map<String, Object> map = new HashMap<>();
				map.put("name", level.name);
				map.put("code", level.code);
				list.add(map);
			}
			return list;
		}
		/**
		 * 职级下拉数据
		 * @return list
		 **/
		public static List<Map<String, Object>> getCommonPostLevelCombobox() {
			List<Map<String, Object>> list = new ArrayList<>();
			for (PostLevelEnum level : PostLevelEnum.values()) {
				Map<String, Object> map = new HashMap<>();
				map.put("name", level.name);
				map.put("code", level.code);
				list.add(map);
			}
			return list;
		}

	}

}
