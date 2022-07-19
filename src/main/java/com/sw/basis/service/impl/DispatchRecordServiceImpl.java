package com.sw.basis.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.basis.dto.query.personnelDimensionPageDTO;
import com.sw.basis.dto.query.projectDimensionPageDTO;
import com.sw.basis.dto.response.DispatchRecordDTO;
import com.sw.basis.entity.DispatchRecordEntity;
import com.sw.basis.mapper.DispatchRecordMapper;
import com.sw.basis.service.DispatchRecordService;
import com.sw.basis.utils.Responses;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 派遣记录表 服务实现类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@Service
public class DispatchRecordServiceImpl extends ServiceImpl<DispatchRecordMapper, DispatchRecordEntity> implements DispatchRecordService {

    /**
     * 项目派遣-人员维度-分页列表
     *
     * @param dto 查询条件
     * @return 分页列表
     **/
    @Override
    public Responses<IPage<DispatchRecordDTO>> pageByPersonnelDimension(personnelDimensionPageDTO dto) {
        return null;
    }

    /**
     * 项目派遣-人员维度-分页列表
     *
     * @param dto 查询条件
     * @return 分页列表
     **/
    @Override
    public Responses<IPage<DispatchRecordDTO>> pageByProjectDimension(projectDimensionPageDTO dto) {
        return null;
    }
}
