package com.sw.basis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sw.basis.dto.query.SysRolePageDTO;
import com.sw.basis.dto.request.SysRoleModifyDTO;
import com.sw.basis.dto.response.SysRoleDTO;
import com.sw.basis.entity.SysRoleEntity;
import com.sw.basis.utils.Responses;

import java.util.List;

/**
 * <p>
 * 岗位管理 服务类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
public interface SysRoleService extends IService<SysRoleEntity> {

    /**
     * 岗位管理_分页列表
     * @param dto 查询条件
     *
     * @return 分页列表
     **/
    Responses<List<SysRoleDTO>> page(SysRolePageDTO dto);

    /**
     * 岗位管理_新增
     * @param dto 岗位信息
     *
     * @return 成功/失败
     **/
    Responses<String> add(SysRoleModifyDTO dto);

    /**
     * 岗位管理_根据id修改
     * @param dto 岗位信息
     *
     * @return 成功/失败
     **/
    Responses<String> updateById(SysRoleModifyDTO dto);

    /**
     * 岗位管理_禁用
     * @param dto 岗位信息
     *
     * @return 成功/失败
     **/
    Responses<String> disableSwitch(SysRoleModifyDTO dto);

    /**
     * 岗位管理_详情
     * @param id ID
     *
     * @return 详情
     **/
    Responses<SysRoleDTO> detail(Integer id);
}
