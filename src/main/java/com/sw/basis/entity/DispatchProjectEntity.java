package com.sw.basis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


/**
 * 派遣项目关联表
 *
 * @author jixing2000
 * @since 2022-07-22
 */
@Data
@TableName("dispatch_project")
public class DispatchProjectEntity {

    /**
     * 主键
     **/
    private Integer id;
    /**
     * 派遣订单号
     **/
    private String orderId;
    /**
     * 项目编号
     **/
    private String projectCode;
    /**
     * 项目名称
     **/
    private String projectName;
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