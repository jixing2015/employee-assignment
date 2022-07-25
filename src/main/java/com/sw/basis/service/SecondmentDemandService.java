package com.sw.basis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sw.basis.dto.request.SecondmentApplyDTO;
import com.sw.basis.entity.SecondmentDemandEntity;
import com.sw.basis.entity.SecondmentPeoplesEntity;
import com.sw.basis.entity.SecondmentRecordEntity;
import com.sw.basis.entity.SysLogEntity;
import com.sw.basis.utils.Responses;

import java.util.List;

/**
 * <p>
 * 借调需求 服务类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
public interface SecondmentDemandService extends IService<SecondmentDemandEntity> {

    /**
     * 获取借调需求信息
     *
     * @param secondmentDemandEntityList 借调需求入参
     * @return 借调需求信息
     **/
    List<SecondmentDemandEntity> getSecondmentDemandEntityList(List<SecondmentDemandEntity> secondmentDemandEntityList);

    /**
     * 借调申请-新增借调信息
     *
     * @param secondmentRecordEntity 借调记录表信息
     * @param secondmentDemandEntityList 借调需求表信息
     * @param secondmentPeoplesEntityList 借调人员表信息
     * @param sysLogEntity 日志表信息
     **/
    Responses getResponses(SecondmentRecordEntity secondmentRecordEntity, List<SecondmentDemandEntity> secondmentDemandEntityList, List<SecondmentPeoplesEntity> secondmentPeoplesEntityList, SysLogEntity sysLogEntity);

    /**
     * 获取借调记录信息
     *
     * @param secondmentApplyDTO 新建借调申请入参
     * @return 借调记录信息
     **/
    SecondmentRecordEntity getSecondmentRecordEntity(SecondmentApplyDTO secondmentApplyDTO);
}
