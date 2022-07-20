package com.sw.basis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sw.basis.dto.ValidateVO;
import com.sw.basis.entity.FlowEntity;
import com.sw.basis.utils.Responses;

/**
 * <p>
 * 流程表 服务类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
public interface FlowService extends IService<FlowEntity> {

    /**
     * 校验
     * @param vo 校验所需条件
     *
     * @return 成功/提示
     **/
    Responses<String> validate(ValidateVO vo);
}
