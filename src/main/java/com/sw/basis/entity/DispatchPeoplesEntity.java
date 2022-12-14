package com.sw.basis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sw.basis.utils.LocalUserUtil;
import com.sw.basis.utils.SeqUtil;
import com.sw.basis.utils.restful.CommonInfo;
import lombok.Data;

import java.math.BigDecimal;
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
     * 派遣成本
     **/
    private BigDecimal dispatchCost;
    /**
     * 结算方式
     **/
    private String settlement;
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

    /**
     * 新增前初始化
     **/
    public void preInsert() {
        try {
            this.setId(SeqUtil.nextValue(SeqUtil.ServiceSeqName.DISPATCH_PEOPLES));
            this.setDelFlag(CommonInfo.DelFlag.UN_DEL);
            this.setCreateTime(new Date());
            this.setCreateBy(LocalUserUtil.getCurrentUser() != null ? LocalUserUtil.getCurrentUser().getCode() : null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}