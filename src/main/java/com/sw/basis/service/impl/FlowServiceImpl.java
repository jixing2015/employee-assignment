package com.sw.basis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.basis.dto.ValidateVO;
import com.sw.basis.entity.FlowEntity;
import com.sw.basis.mapper.FlowMapper;
import com.sw.basis.service.FlowService;
import com.sw.basis.utils.Responses;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 流程表 服务实现类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@Service
public class FlowServiceImpl extends ServiceImpl<FlowMapper, FlowEntity> implements FlowService {

    /**
     * 校验
     * @param vo 校验所需条件
     *
     * @return com.sw.basis.utils.Responses<java.lang.String>
     **/
    @Override
    public Responses<String> validate(ValidateVO vo) {
        //todo
        return Responses.success();
    }
}
