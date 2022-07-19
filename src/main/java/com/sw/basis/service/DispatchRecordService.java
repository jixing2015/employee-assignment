package com.sw.basis.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sw.basis.dto.query.personnelDimensionPageDTO;
import com.sw.basis.dto.query.projectDimensionPageDTO;
import com.sw.basis.dto.response.DispatchRecordDTO;
import com.sw.basis.entity.DispatchRecordEntity;
import com.sw.basis.utils.Responses;

/**
 * <p>
 * 派遣记录表 服务类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
public interface DispatchRecordService extends IService<DispatchRecordEntity> {

    /**
     * 项目派遣-人员维度-分页列表
     * @param dto 查询条件
     *
     * @return 分页列表
     **/
    Responses<IPage<DispatchRecordDTO>> pageByPersonnelDimension(personnelDimensionPageDTO dto);

    /**
     * 项目派遣-人员维度-分页列表
     * @param dto 查询条件
     *
     * @return 分页列表
     **/
    Responses<IPage<DispatchRecordDTO>> pageByProjectDimension(projectDimensionPageDTO dto);
}
