package com.sw.basis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.basis.entity.SecondmentPeoplesEntity;
import com.sw.basis.mapper.SecondmentPeoplesMapper;
import com.sw.basis.service.SecondmentPeoplesService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 借调人员 服务实现类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@Service
public class SecondmentPeoplesServiceImpl extends ServiceImpl<SecondmentPeoplesMapper, SecondmentPeoplesEntity> implements SecondmentPeoplesService {

    @Override
    public List<SecondmentPeoplesEntity> getSecondmentPeoplesEntityList(List<SecondmentPeoplesEntity> secondmentPeoplesEntityList) {

        List<SecondmentPeoplesEntity> secondmentPeoplesEntityReturn = new ArrayList<>();
        secondmentPeoplesEntityList.forEach(x -> {
            x.preInsert();
            secondmentPeoplesEntityReturn.add(x);
        });
        return secondmentPeoplesEntityReturn;
    }
}
