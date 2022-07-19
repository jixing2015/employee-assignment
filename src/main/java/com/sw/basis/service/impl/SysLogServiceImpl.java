package com.sw.basis.service.impl;

import com.sw.basis.entity.SysLogEntity;
import com.sw.basis.mapper.SysLogMapper;
import com.sw.basis.service.SysLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.basis.utils.Responses;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户日志表 服务实现类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLogEntity> implements SysLogService {

    @Resource
    SysLogMapper sysLogMapper;

    @Override
    public Responses<String> addSysLog(SysLogEntity entity) {
        entity.preInsert();
        sysLogMapper.insert(entity);
        return Responses.success();
    }
}
