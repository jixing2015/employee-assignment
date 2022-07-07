package com.sw.basis.utils.enums;

/**
 * 1XXX 客户端错误
 * 2XXX 服务器端内部错误
 * 3XXX 警告提示
 * @author jixing2000
 */
public enum ResponseCode {
    /**
     * 成功
     */
    SUCCESS_CODE(0,"成功"),
    /**
     * 错误
     */
    ERROR_CODE(1,"错误"),
    /**
     * 鉴权信息失效
     */
    NO_AUTH_CODE(2, "鉴权信息失效"),
    /**
     * 鉴权信息失效
     */
    AUTH_INVALID_CODE(3, "鉴权信息失效"),
    
    CC_MAX_TIME_CODE(4,"验证码发送超过最大次数"),
    CC_NULL_CODE(5,"验证码不存在或失效"),

    ERROR_CODE_NOTEXIST(6,"用户不存在！"),
    ERROR_CODE_NOTEMPTY(7,"不能为空"),

    ERROR_CODE_USEROUT(8,"用户被禁用，请联系管理员！"),
    /**
     *  3XXX 警告提示
     */
    WARN_CODE(3001, "此操作被禁止"),
    EXIST_CODE(3002,"已存在"),
    OCCUPY_CODE(3003,"已占用");

    private Integer code;
    private String defaultMsg;

    ResponseCode(Integer code, String defaultMsg) {
        this.code = code;
        this.defaultMsg = defaultMsg;
    }

    public Integer getCode() {
        return code;
    }

    public String getDefaultMsg() {
        return defaultMsg;
    }
}
