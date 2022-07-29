package com.sw.basis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


/**
 * 业务线设置
 *
 * @author jixing2000
 * @since 2022-07-29
 */
@Data
@TableName("business_line")
public class BusinessLineEntity {

    /**
     * 主键
     **/
    private Integer id;
    /**
     * 条线编码
     **/
    private String businesslineCode;
    /**
     * 条线名称
     **/
    private String businesslineName;
    /**
     * 板块
     **/
    private Integer businesslineBusinesstype;
    /**
     * 部门编号
     **/
    private String asorgOrgid;
    /**
     * 部门名称
     **/
    private String asorgOrgname;
    /**
     * 创建人
     **/
    private String createBy;
    /**
     * 创建时间
     **/
    private Date createTime;
    /**
     * 更新人
     **/
    private String updateBy;
    /**
     * 更新时间
     **/
    private Date updateTime;
    /**
     * 是否删除;0表示未删除，1表示删除
     **/
    private Integer delFlag;

}