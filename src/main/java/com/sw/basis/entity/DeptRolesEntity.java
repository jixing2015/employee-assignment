package com.sw.basis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sw.basis.utils.LocalUserUtil;
import com.sw.basis.utils.SeqUtil;
import com.sw.basis.utils.restful.CommonInfo;
import lombok.Data;

import java.util.Date;


/**
 * 部门角色
 *
 * @author jixing2000
 * @since 2022-07-29
 */
@Data
@TableName("dept_roles")
public class DeptRolesEntity {

    /**
     * 主键
     **/
    private Integer id;

    /**
     * 角色（部门负责经理，部门秘书）
     **/
    private String asorgrole;

    /**
     * 角色名称（部门负责经理，部门秘书）
     **/
    private String asorgroleName;
    /**
     * 员工
     **/
    private String asorgroleempEmpid;
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
            this.setId(SeqUtil.nextValue(SeqUtil.ServiceSeqName.DEPT_ROLES));
            this.setDelFlag(CommonInfo.DelFlag.UN_DEL);
            this.setCreateTime(new Date());
            this.setCreateBy(LocalUserUtil.getCurrentUser() != null ? LocalUserUtil.getCurrentUser().getCode() : null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}