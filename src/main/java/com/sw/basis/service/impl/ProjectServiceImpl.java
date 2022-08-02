package com.sw.basis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.basis.dto.api.ProjectDTO;
import com.sw.basis.dto.api.ProjectMembersDTO;
import com.sw.basis.dto.request.ProjectInformationDTO;
import com.sw.basis.dto.request.ProjectModifyDTO;
import com.sw.basis.entity.ProjectEntity;
import com.sw.basis.entity.ProjectMembersEntity;
import com.sw.basis.mapper.ProjectMapper;
import com.sw.basis.service.ProjectMembersService;
import com.sw.basis.service.ProjectService;
import com.sw.basis.utils.Responses;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    @Resource
    ProjectMembersService projectMembersService;

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


    /**
     * 项目派遣-接受信天游项目信息
     * @param projectInformationDTO 信天游项目信息
     *
     * @return 成功/失败
     **/
    @Override
    public Responses<String> accept(ProjectInformationDTO projectInformationDTO) {
        ProjectEntity entity = new ProjectEntity();
        BeanUtils.copyProperties(projectInformationDTO,entity);
        projectMapper.updateById(entity);
        return Responses.success();
    }

    /**
     * 同步项目信息
     *
     * @param dtoList 项目信息集合
     **/
    @Override
    public void pushProject(List<ProjectDTO> dtoList) {
        List<ProjectEntity> list = new ArrayList<>();
        List<ProjectMembersDTO> membersList = new ArrayList<>();
        for(ProjectDTO dto : dtoList){
            ProjectEntity entity = new ProjectEntity();
            entity.preInsert();
            entity.setProjectCode(dto.getPmprojectCode());
            entity.setProjectName(dto.getPmprojectName());
            entity.setDeptCode(dto.getPmprojectEntity());
            entity.setBusinessType(dto.getPmprojectServicetype());
            entity.setApprovalDate(dto.getApprovalDate());
            entity.setPmprojectBusinesstype(dto.getPmprojectBusinesstype());
            entity.setPmprojectPrjtmpid(dto.getPmprojectPrjtmpid());
            entity.setPmprojectCustomer(dto.getPmprojectCustomer());
            entity.setPmprojectExaminate(dto.getPmprojectExaminate());
            entity.setPmbusutakeTimecost(dto.getPmbusutakeTimecost());
            entity.setPmprojectStatus(dto.getPmprojectStatus());
            entity.setPmprojectManager(dto.getPmprojectManager());
            entity.setPmprojectManager2(dto.getPmprojectManager2());
            entity.setPmprojectManager2status(dto.getPmprojectManager2status());
            entity.setPmprojectCedperson(dto.getPmprojectCedperson());
            entity.setPmprojectPartner(dto.getPmprojectPartner());
            list.add(entity);
            membersList.addAll(dto.getMembersList());
        }
        //存储或更新项目信息
        this.saveOrUpdateBatch(list);
        //存储或更新项目组成员信息
        List<ProjectMembersEntity> projectMembersEntityList = membersList.stream().map(projectMembersDTO -> {
            ProjectMembersEntity projectMembersEntity = new ProjectMembersEntity();
            BeanUtils.copyProperties(projectMembersDTO,projectMembersEntity);
            return projectMembersEntity;
        }).collect(Collectors.toList());
        projectMembersService.saveOrUpdateBatch(projectMembersEntityList);
    }

}
