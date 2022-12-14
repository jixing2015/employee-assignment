package com.sw.basis.service;

import com.sw.basis.entity.SysLogEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sw.basis.utils.Responses;

/**
 * <p>
 * 用户日志表 服务类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
public interface SysLogService extends IService<SysLogEntity> {

    Responses<String> addSysLog (SysLogEntity entity);
}
