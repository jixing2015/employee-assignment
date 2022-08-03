package com.sw.basis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sw.basis.dto.api.DeptRolesDTO;
import com.sw.basis.dto.response.SysDictDTO;
import com.sw.basis.entity.DeptRolesEntity;
import com.sw.basis.utils.Responses;

import java.util.List;

/**
 * <p>
 * 部门角色 服务类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-29
 */
public interface DeptRolesService extends IService<DeptRolesEntity> {

    /**
     * 同步部门角色及人员
     * @param dtoList 部门角色及人员集合
     *
     **/
    void pushDeptRoles(List<DeptRolesDTO> dtoList);

    /**
     * 部门角色字典
     *
     * @return 字典集合
     **/
    Responses<List<SysDictDTO>> deptRolesDict();
}
