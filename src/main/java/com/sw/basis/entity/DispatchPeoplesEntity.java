package com.sw.basis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


/**
 * 派遣人员管理表
 *
 * @author jixing2000
 * @since 2022-07-22
 */
@Data
@TableName("dispatch_peoples")
public class DispatchPeoplesEntity {

    /**
     * 主键
     **/
    private Integer id;
    /**
     * 派遣订单号
     **/
    private String orderId;
    /**
     * 用户编号
     **/
    private String userCode;
    /**
     * 用户名称
     **/
    private String userName;
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