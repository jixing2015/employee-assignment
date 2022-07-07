package com.sw.basis.utils.enums;

/**
 * @author ITOD008
 */

public enum StateEnum {

    /** 待提交 **/
    TO_BE_COMMIT_5("to_be_commit_5","待提交"),
    /** 待复核 **/
    TO_BE_CHECK_5("to_be_check_5","待复核"),
    /** 复核退回 **/
    CHECK_RETURN_5("check_return_5","退回"),
    /** 已完成 **/
    DONE_5("done_5","已完成");

    private String code;
    private String msg;

    StateEnum(String code, String msg){
        this.code=code;
        this.msg=msg;
    }

    public String getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }
}
