package com.sw.basis.utils.constant;

/**
 * Redis 常量
 * @Author jixing2000
 * @Date 2022/3/21 0021 9:30:04
 **/
public interface RedisConstant {

    /**
     * Redis Key
     */
    String HKEY = "emp_ass_seq";

    /**
     * 要增加几(大于0)
     */
    Integer APPLY_ID_BY = 1;

    /**
     * Redis Key 同一个项目发起的需求数量
     */
    String PROJECT_SEQ = "emp_ass_project_seq";

    /**
     * Redis Key 用户的token
     */
    String CENTERPORTAL_USER_TOKENS = "emp_ass_user_tokens";

    /**
     * Redis Key 用户的信息
     */
    String CENTERPORTAL_USER_INFO = "emp_ass_user_info";

    /**
     * 中台前缀
     */
    String CENTERPORTAL_PREFIX = "emp_ass_";
}
