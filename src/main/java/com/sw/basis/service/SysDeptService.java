package com.sw.basis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sw.basis.dto.api.OrganizationDTO;
import com.sw.basis.dto.request.DepartmentInformationDTO;
import com.sw.basis.entity.SysDeptEntity;
import com.sw.basis.utils.Responses;

import java.util.List;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author donglinmo
 * @since 2022-07-21
 */
public interface SysDeptService extends IService<SysDeptEntity> {

    /**
     * 根据部门编号获取板块信息
     * @param deptCode 部门编号
     *
     * @return 板块信息
     **/
    SysDeptEntity getPlageByDeptCode(String deptCode);
    /**
     * 部门表-新增
     * @param departmentInformationDTO 内容
     *
     * @return 成功/失败
     **/
    Responses<String> insert(DepartmentInformationDTO departmentInformationDTO);

    /**
     * 同步组织机构信息
     * @param dtoList 组织机构信息集合
     *
     **/
    void pushOrganization(List<OrganizationDTO> dtoList);
}
