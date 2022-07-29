package com.sw.basis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


/**
 * 人员借调批量设置
 *
 * @author jixing2000
 * @since 2022-07-29
 */
@Data
@TableName("seconded_personnel")
public class SecondedPersonnelEntity {

    /**
     * 主键
     **/
    private Integer id;
    /**
     * 项目负责部门
     **/
    private String pmressetPrjentity;
    /**
     * 派遣指定部门
     **/
    private String pmressetDispatchentity;
    /**
     * 派遣指定职级
     **/
    private String pmressetJobid;
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