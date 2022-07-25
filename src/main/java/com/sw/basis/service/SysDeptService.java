package com.sw.basis.service;

import com.sw.basis.entity.SysDeptEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
public interface SysDeptService extends IService<SysDeptEntity> {

    /**
     * 根据部门编号获取板块信息
     * @param deptCode 部门编号
     *
     * @return 板块信息
     **/
    SysDeptEntity getPlageByDeptCode(String deptCode);
}
