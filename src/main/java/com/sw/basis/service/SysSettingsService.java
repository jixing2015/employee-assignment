package com.sw.basis.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sw.basis.dto.query.SysSettingsPageDTO;
import com.sw.basis.dto.request.SysSettingsModifyDTO;
import com.sw.basis.dto.response.SysSettingsDTO;
import com.sw.basis.entity.SysSettingsEntity;
import com.sw.basis.utils.Responses;

/**
 * <p>
 * 系统设置 服务类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
public interface SysSettingsService extends IService<SysSettingsEntity> {

    /**
     * 系统设置-列表
     * @param dto 查询条件
     *
     * @return 列表
     **/
    Responses<IPage<SysSettingsDTO>> page(SysSettingsPageDTO dto);

    /**
     * 系统设置-新增
     * @param dto 内容
     *
     * @return 成功/失败
     **/
    Responses<String> add(SysSettingsModifyDTO dto);

    /**
     * 系统设置-根据id修改
     * @param dto 内容
     *
     * @return 成功/失败
     **/
    Responses<String> updateById(SysSettingsModifyDTO dto);

    /**
     * 系统设置-根据id删除
     * @param id id
     *
     * @return 成功/失败
     **/
    Responses<String> del(Integer id);

    /**
     * 系统设置-详情
     * @param plageCode 板块编号
     *
     * @return 配置详情
     **/
    SysSettingsEntity detail(String plageCode);

}
