package com.sw.basis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.basis.dto.request.ProjectModifyDTO;
import com.sw.basis.entity.ProjectEntity;
import com.sw.basis.mapper.ProjectMapper;
import com.sw.basis.service.ProjectService;
import com.sw.basis.utils.Responses;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 项目表 服务实现类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, ProjectEntity> implements ProjectService {

    @Resource
    ProjectMapper projectMapper;

    /**
     * 项目派遣-新增
     *
     * @param dto 内容
     * @return 成功/失败
     **/
    @Override
    public Responses<String> add(ProjectModifyDTO dto) {
        ProjectEntity entity = new ProjectEntity();
        BeanUtils.copyProperties(dto,entity);
        entity.preInsert();
        projectMapper.insert(entity);
        return Responses.success();
    }

    /**
     * 项目派遣-根据id修改
     *
     * @param dto 内容
     * @return 成功/失败
     **/
    @Override
    public Responses<String> updateById(ProjectModifyDTO dto) {
        ProjectEntity entity = new ProjectEntity();
        BeanUtils.copyProperties(dto,entity);
        projectMapper.updateById(entity);
        return Responses.success();
    }

}
