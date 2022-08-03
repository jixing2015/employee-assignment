package com.sw.basis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.basis.dto.api.UserDTO;
import com.sw.basis.dto.query.SysUserQuery;
import com.sw.basis.dto.request.SysUserModifyDTO;
import com.sw.basis.dto.request.UserInformationDTO;
import com.sw.basis.dto.response.SysDictDTO;
import com.sw.basis.dto.response.SysUserDTO;
import com.sw.basis.entity.SysUserEntity;
import com.sw.basis.mapper.SysUserMapper;
import com.sw.basis.service.SysUserService;
import com.sw.basis.utils.Responses;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
     * 用户_分页列表
     *
     * @param query 查询条件
     * @return java.util.List<com.sw.basis.dto.response.SysUserDTO>
     **/
    @Override
    public IPage<SysUserDTO> page(SysUserQuery query) {
        QueryWrapper<SysUserEntity> wrapper = new QueryWrapper<>();
        wrapper.lambda().like(StringUtils.isNotEmpty(query.getName()),SysUserEntity::getName,query.getName());
        wrapper.lambda().orderByDesc(SysUserEntity::getId);
        Page<SysUserEntity> page = new Page<>(query.getPageNum(),query.getPageSize());
        IPage<SysUserEntity> result = sysUserMapper.selectPage(page,wrapper);
        return result.convert(sysUserEntity -> {
            SysUserDTO sysUserDTO = new SysUserDTO();
            BeanUtils.copyProperties(sysUserEntity,sysUserDTO);
            return sysUserDTO;
        });
    }

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
        wrapper.lambda().orderByDesc(SysUserEntity::getId);
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


    /**
     * 接受信天游的用户信息
     * @param userInformationDTO 信天游的用户信息
     *
     * @return 成功/失败
     **/
    @Override
    public Responses<String> accept(UserInformationDTO userInformationDTO) {
        SysUserEntity sysUserEntity = new SysUserEntity();
        BeanUtils.copyProperties(userInformationDTO,sysUserEntity);
        sysUserEntity.preInsert();
        sysUserMapper.insert(sysUserEntity);
        return Responses.success();
    }

    /**
     * 同步员工档案
     *
     * @param dtoList 员工档案集合
     **/
    @Override
    public void pushUser(List<UserDTO> dtoList) {
        List<SysUserEntity> list = new ArrayList<>();
        for(UserDTO dto : dtoList){
            SysUserEntity entity = new SysUserEntity();
            entity.preInsert();
            entity.setCode(dto.getHrempCode());
            entity.setName(dto.getHrempName());
            entity.setDeptCode(dto.getAsorgOrgid());
            entity.setDeptName(dto.getAsorgOrgname());
            entity.setLevelCode(dto.getHrjobJob());
            entity.setLevelName(dto.getHrjobJobname());
            entity.setState(dto.getHrempStatus());
            entity.setHrempTalentbase(dto.getHrempTalentbase());
            list.add(entity);
        }
        this.saveOrUpdateBatch(list);
    }

    /**
     * 用户职级字典
     *
     * @return 字典集合
     **/
    @Override
    public Responses<List<SysDictDTO>> userLevelDict() {
        QueryWrapper<SysUserEntity> wrapper = new QueryWrapper<>();
        wrapper.select("DISTINCT level_code,level_name").orderByAsc("level_code");
        List<SysUserEntity> list = sysUserMapper.selectList(wrapper);
        List<SysDictDTO> dictList = new ArrayList<>();
        for(SysUserEntity entity : list){
            SysDictDTO dto = new SysDictDTO();
            dto.setCode("userLevel");
            dto.setName("职级字典");
            dto.setItemKey(entity.getLevelCode());
            dto.setItemValue(entity.getLevelName());
            dictList.add(dto);
        }
        return Responses.success(dictList);
    }

    /**
     * 根据职级查询用户列表
     *
     * @param levelCode 职级编号
     * @return 用户列表
     **/
    @Override
    public Responses<List<SysUserDTO>> getUserListByLevel(String levelCode) {
        QueryWrapper<SysUserEntity> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysUserEntity::getLevelCode,levelCode);
        List<SysUserEntity> list = sysUserMapper.selectList(wrapper);
        return Responses.success(list.stream().map(sysUserEntity -> {
                SysUserDTO sysUserDTO = new SysUserDTO();
                BeanUtils.copyProperties(sysUserEntity,sysUserDTO);
                return sysUserDTO;
            }).collect(Collectors.toList())
        );
    }

    /**
     * 根据角色查询用户列表
     *
     * @param roleCode 角色编号
     * @return 用户列表
     **/
    @Override
    public Responses<List<SysUserDTO>> getUserListByRole(String roleCode) {
        List<SysUserEntity> list = sysUserMapper.getUserListByDeptRole(roleCode);
        return Responses.success(list.stream().map(sysUserEntity -> {
                SysUserDTO sysUserDTO = new SysUserDTO();
                BeanUtils.copyProperties(sysUserEntity,sysUserDTO);
                return sysUserDTO;
            }).collect(Collectors.toList())
        );
    }
}
