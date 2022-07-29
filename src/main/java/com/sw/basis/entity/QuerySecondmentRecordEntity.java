package com.sw.basis.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author DongLinmo
 * @create 2022/7/26
 */
@Data
public class QuerySecondmentRecordEntity {

    /**
     * 借调记录id
     */
    private Integer id;
    /**
     * 创建时间/借调申请日期
     */
    private Data createTime;
    /**
     * 用户名称/借调申请人
     */
    private String name;
    /**
     * 用户编号/借调申请人编号
     */
    private String code;
    /**
     * 职级名称
     */
    private String levelName;
    /**
     * 职级编号
     */
    private String levelCode;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 部门编号
     */
    private String deptCode;
    /**
     * 借调项目名称
     */
    private String projectName;
    /**
     * 借调项目编号
     */
    private String projectCode;
    /**
     * 借调协调人
     */
    private String coordinator;
    /**
     * 被借调人姓名
     */
    private String eName;
    /**
     * 被借调人编号
     */
    private String eCode;
    /**
     * 被借调人部门名称
     */
    private String eDeptName;
    /**
     * 被借调人部门编号
     */
    private String eDeptCode;
    /**
     * 被借调人职级名称
     */
    private String eLevelName;
    /**
     * 被借调人职级编号
     */
    private String eLevelCode;
    /**
     * 派遣开始时间
     */
    private Data startTime;
    /**
     * 派遣结束日期
     */
    private Data endTime;
    /**
     * 结算方式
     */
    private String settlement;
    /**
     * 每天派遣小时数
     */
    private Integer hoursPerDay;



}
