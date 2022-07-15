package com.sw.basis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.basis.entity.SecondmentDemandEntity;
import com.sw.basis.mapper.SecondmentDemandMapper;
import com.sw.basis.service.SecondmentDemandService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 借调需求 服务实现类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@Service
public class SecondmentDemandServiceImpl extends ServiceImpl<SecondmentDemandMapper, SecondmentDemandEntity> implements SecondmentDemandService {

    @Override
    public List<SecondmentDemandEntity> getSecondmentDemandEntityList(List<SecondmentDemandEntity> secondmentDemandEntityList) {

        List<SecondmentDemandEntity> secondmentDemandEntityReturn = new ArrayList<>();
        secondmentDemandEntityList.stream().forEach(x -> {
            x.preInsert();
            secondmentDemandEntityReturn.add(x);
        });
        return secondmentDemandEntityReturn;
    }


}
