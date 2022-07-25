package com.sw.basis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sw.basis.dto.request.ProjectInformationDTO;
import com.sw.basis.dto.request.ProjectModifyDTO;
import com.sw.basis.entity.ProjectEntity;
import com.sw.basis.utils.Responses;

/**
 * <p>
 * 项目表 服务类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
public interface ProjectService extends IService<ProjectEntity> {

    /**
     * 项目派遣-新增
     * @param dto 内容
     *
     * @return 成功/失败
     **/
    Responses<String> add(ProjectModifyDTO dto);

    /**
     * 项目派遣-根据id修改
     * @param dto 内容
     *
     * @return 成功/失败
     **/
    Responses<String> updateById(ProjectModifyDTO dto);

    /**
     * 项目派遣-接受信天游项目信息
     * @param projectInformationDTO 信天游项目信息
     *
     * @return 成功/失败
     **/
    Responses<String> accept(ProjectInformationDTO projectInformationDTO);
}
