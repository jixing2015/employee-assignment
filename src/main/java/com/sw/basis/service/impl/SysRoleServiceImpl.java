package com.sw.basis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.basis.dto.query.SysRolePageDTO;
import com.sw.basis.dto.request.SysRoleModifyDTO;
import com.sw.basis.dto.response.SysRoleDTO;
import com.sw.basis.entity.SysRoleEntity;
import com.sw.basis.mapper.SysRoleMapper;
import com.sw.basis.service.SysRoleService;
import com.sw.basis.utils.LocalUserUtil;
import com.sw.basis.utils.Responses;
import com.sw.basis.utils.constant.StateConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 岗位管理 服务实现类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRoleEntity> implements SysRoleService {

    @Resource
    SysRoleMapper sysRoleMapper;

    /**
     * 岗位管理_列表
     *
     * @param dto 查询条件
     * @return 分页列表
     **/
    @Override
    public Responses<List<SysRoleDTO>> page(SysRolePageDTO dto) {
        QueryWrapper<SysRoleEntity> wrapper = new QueryWrapper<>();
        wrapper.lambda().like(StringUtils.isNotEmpty(dto.getRoleCode()),SysRoleEntity::getRoleCode,dto.getRoleCode());
        wrapper.lambda().like(StringUtils.isNotEmpty(dto.getRoleName()),SysRoleEntity::getRoleName,dto.getRoleName());
        wrapper.lambda().eq(dto.getState()!=null,SysRoleEntity::getState,dto.getState());
        wrapper.lambda().orderByDesc(SysRoleEntity::getId);
        List<SysRoleEntity> result = sysRoleMapper.selectList(wrapper);
        return Responses.success(
            result.stream().map(sysRoleEntity -> {
                SysRoleDTO sysRoleDTO = new SysRoleDTO();
                BeanUtils.copyProperties(sysRoleEntity,sysRoleDTO);
                return sysRoleDTO;
            }).collect(Collectors.toList())
        );
    }

    /**
     * 岗位管理_新增
     *
     * @param dto 岗位信息
     * @return 成功/失败
     **/
    @Override
    public Responses<String> add(SysRoleModifyDTO dto) {
        SysRoleEntity sysRoleEntity = new SysRoleEntity();
        BeanUtils.copyProperties(dto,sysRoleEntity);
        sysRoleEntity.setState(StateConstant.ENABLE);
        sysRoleEntity.preInsert();
        sysRoleMapper.insert(sysRoleEntity);
        return Responses.success();
    }

    /**
     * 岗位管理_根据id修改
     *
     * @param dto 岗位信息
     * @return 成功/失败
     **/
    @Override
    public Responses<String> updateById(SysRoleModifyDTO dto) {
        SysRoleEntity sysRoleEntity = new SysRoleEntity();
        BeanUtils.copyProperties(dto,sysRoleEntity);
        sysRoleEntity.setUpdateBy(LocalUserUtil.getCurrentUser() != null ? LocalUserUtil.getCurrentUser().getCode() : null);
        sysRoleEntity.setUpdateName(LocalUserUtil.getCurrentUser() != null ? LocalUserUtil.getCurrentUser().getName() : null);
        sysRoleEntity.setUpdateTime(new Date());
        sysRoleMapper.updateById(sysRoleEntity);
        return Responses.success();
    }

    /**
     * 岗位管理_禁用
     *
     * @param dto 岗位信息
     * @return 成功/失败
     **/
    @Override
    public Responses<String> disableSwitch(SysRoleModifyDTO dto) {
        SysRoleEntity sysRoleEntity = new SysRoleEntity();
        sysRoleEntity.setId(dto.getId());
        sysRoleEntity.setState(dto.getState());
        sysRoleMapper.updateById(sysRoleEntity);
        return Responses.success();
    }

    /**
     * 岗位管理_详情
     *
     * @param id ID
     * @return 详情
     **/
    @Override
    public Responses<SysRoleDTO> detail(Integer id) {
        SysRoleDTO sysRoleDTO = new SysRoleDTO();


        return Responses.success(sysRoleDTO);
    }
}
