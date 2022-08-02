package com.sw.basis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sw.basis.utils.LocalUserUtil;
import com.sw.basis.utils.SeqUtil;
import com.sw.basis.utils.restful.CommonInfo;
import lombok.Data;

import java.util.Date;


/**
 * 休假表
 *
 * @author jixing2000
 * @since 2022-08-02
 */
@TableName("sys_vacation")
@Data
public class SysVacationEntity {

    /**
     * 主键
     **/
    private Integer id;
    /**
     * 请假单编号
     **/
    private String lvleavereqReqid;
    /**
     * 员工编号
     **/
    private String lvleavereqEmpid;
    /**
     * 开始日期
     **/
    private Date lvleavereqBedate;
    /**
     * 结束日期
     **/
    private Date lvleavereqEdate;
    /**
     * 是否全天
     **/
    private Integer lvleavereqBtype;
    /**
     * 开始时间1
     **/
    private Date lvleavereqBbtime;
    /**
     * 结束时间1
     **/
    private Date lvleavereqBetime;
    /**
     * 开始时间2
     **/
    private Date lvleavereqEbtime;
    /**
     * 结束时间2
     **/
    private Date lvleavereqEetime;
    /**
     * 小时数
     **/
    private Integer lvleavereqTotalhours;
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
            this.setId(SeqUtil.nextValue(SeqUtil.ServiceSeqName.SYS_VACATION));
            this.setDelFlag(CommonInfo.DelFlag.UN_DEL);
            this.setCreateTime(new Date());
            this.setCreateBy(LocalUserUtil.getCurrentUser() != null ? LocalUserUtil.getCurrentUser().getCode() : null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}