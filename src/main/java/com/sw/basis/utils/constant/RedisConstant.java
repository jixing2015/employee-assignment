package com.sw.basis.utils.constant;

/**
 * Redis 常量
 * @Author jixing2000
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
     * 人员派遣前缀
     */
    String CENTERPORTAL_PREFIX = "emp_ass_";

    /**
     * Redis Key 发起的需求数量
     */
    String ORDER_ID_SEQ = "emp_ass_order_id";
}
