package com.sw.basis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.basis.dto.query.SysSettingsPageDTO;
import com.sw.basis.dto.request.SysSettingsModifyDTO;
import com.sw.basis.dto.response.SysSettingsDTO;
import com.sw.basis.entity.SysSettingsEntity;
import com.sw.basis.mapper.SysSettingsMapper;
import com.sw.basis.service.SysSettingsService;
import com.sw.basis.utils.Responses;
import com.sw.basis.utils.constant.StateConstant;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * 系统设置 服务实现类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@Service
public class SysSettingsServiceImpl extends ServiceImpl<SysSettingsMapper, SysSettingsEntity> implements SysSettingsService {

    @Resource
    SysSettingsMapper settingsMapper;


    /**
     * 系统设置-分页列表
     *
     * @param dto 分页查询条件
     * @return 列表
     **/
    @Override
    public Responses<IPage<SysSettingsDTO>> page(SysSettingsPageDTO dto) {
        QueryWrapper<SysSettingsEntity> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysSettingsEntity::getPlage,dto.getPlage());
        Page<SysSettingsEntity> page = new Page<>(dto.getPageNum(),dto.getPageSize());
        IPage<SysSettingsEntity> list = settingsMapper.selectPage(page,wrapper);
        return Responses.success(list.convert(sysSettingsEntity -> {
                    SysSettingsDTO sysSettingsDTO = new SysSettingsDTO();
                    BeanUtils.copyProperties(sysSettingsEntity,sysSettingsDTO);
                    return sysSettingsDTO;
                })
        );
    }

    /**
     * 系统设置-新增
     *
     * @param dto 内容
     * @return 成功/失败
     **/
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Responses<String> add(SysSettingsModifyDTO dto) {
        SysSettingsEntity entity = new SysSettingsEntity();
        BeanUtils.copyProperties(dto,entity);
        entity.preInsert();
        settingsMapper.insert(entity);
        return Responses.success();
    }

    /**
     * 系统设置-根据id修改
     *
     * @param dto 内容
     * @return 成功/失败
     **/
    @Override
    public Responses<String> updateById(SysSettingsModifyDTO dto) {
        SysSettingsEntity entity = new SysSettingsEntity();
        BeanUtils.copyProperties(dto,entity);
        settingsMapper.updateById(entity);
        return Responses.success();
    }

    /**
     * 系统设置-根据id删除
     *
     * @param id id
     * @return 成功/失败
     **/
    @Override
    public Responses<String> del(Integer id) {
        SysSettingsEntity entity = new SysSettingsEntity();
        entity.setId(id);
        entity.setDelFlag(StateConstant.DEL);
        settingsMapper.updateById(entity);
        return Responses.success();
    }

}
