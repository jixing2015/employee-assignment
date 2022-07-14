package com.sw.basis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sw.basis.entity.SecondmentDemandEntity;

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

    List<SecondmentDemandEntity> getSecondmentDemandEntityList(List<SecondmentDemandEntity> secondmentDemandEntityList);

}
