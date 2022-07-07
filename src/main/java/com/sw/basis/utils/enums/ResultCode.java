package com.sw.basis.utils.enums;

import com.google.common.collect.Lists;

/**
 * 返回代码
 * @author jsxzshd
 **/
@SuppressWarnings("AlibabaEnumConstantsMustHaveComment")
public enum ResultCode {

    SUCCESS(200, "成功"),
    ERROR(500, "未知异常"),
    EXCEPTION(501, "系统异常"),

    REQ_PARAMS_ERROR(400, "参数不正确"),
    REQ_METHOD_NOT_SUPPORT(405, "请求方法不支持"),

    AUTH_AUTH_FAILED(301, "身份验证失败"),
    AUTH_AUTH_EXPIRED(302, "身份验证过期"),
    AUTH_PERMISSION_DENIED(303, "权限不足"),
    AUTH_UN_LOGIN(304, "请登录"),

    LOGIN_ACCOUNT_ERROR(1001, "用户名或密码不正确"),
    LOGIN_ACCOUNT_LOCKED(1002, "用户名被锁定"),
    
    DATA_NOT_FOUND(2001, "数据不存在"),
    USER_NOT_FOUND(2002, "用户未找到"),
    
    DATA_DUPLICATE(2003, "数据重复"),
    
    UPDATE_PWD_OLDPWD_ERROR(2010, "旧密码不正确"),
    UPDATE_PWD_OLD_NEW_SAME_ERROR(2011, "新密码不能和旧密码一致"),
    
    EMAIL_SEND_EXCEPTION(2020, "邮件发送失败，请联系系统管理员"),

    AUTH_ADDINFO(2022, "需要先完成项目实施及成果文件再进行成果评价文件"),
    ;

    public Integer code;
    public String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String get(String code) {
        ResultCode resultCode = Lists.newArrayList(values()).stream().filter((rc) -> rc.code.equals(code)).findFirst().orElse(null);
        return resultCode == null ? null : resultCode.message;
    }


}
