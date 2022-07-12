package com.sw.basis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.basis.dto.query.SysUserQuery;
import com.sw.basis.dto.request.SysUserModifyDTO;
import com.sw.basis.dto.response.SysUserDTO;
import com.sw.basis.entity.SysUserEntity;
import com.sw.basis.mapper.SysUserMapper;
import com.sw.basis.service.SysUserService;
import com.sw.basis.utils.Responses;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements SysUserService {

    @Resource
    SysUserMapper sysUserMapper;

    /**
     * 用户列表
     *
     * @param query 查询条件
     * @return java.util.List<com.sw.basis.dto.response.SysUserDTO>
     **/
    @Override
    public List<SysUserDTO> getUserList(SysUserQuery query) {
        QueryWrapper<SysUserEntity> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(StringUtils.isNotEmpty(query.getCode()),SysUserEntity::getCode,query.getCode());
        wrapper.lambda().eq(StringUtils.isNotEmpty(query.getName()),SysUserEntity::getName,query.getName());
        wrapper.lambda().eq(query.getState() != null,SysUserEntity::getState,query.getState());
        List<SysUserEntity> list = sysUserMapper.selectList(wrapper);
        return list.stream().map(sysUserEntity -> {
            SysUserDTO sysUserDTO = new SysUserDTO();
            BeanUtils.copyProperties(sysUserEntity,sysUserDTO);
            return sysUserDTO;
        }).collect(Collectors.toList());
    }

    /**
     * 新增
     *
     * @param dto 人员信息
     * @return 成功/失败
     **/
    @Override
    public Responses<String> add(SysUserModifyDTO dto) {
        SysUserEntity sysUserEntity = new SysUserEntity();
        BeanUtils.copyProperties(dto,sysUserEntity);
        sysUserEntity.preInsert();
        sysUserMapper.insert(sysUserEntity);
        return Responses.success();
    }
}
