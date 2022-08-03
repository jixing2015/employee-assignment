package com.sw.basis.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sw.basis.annotation.Log;
import com.sw.basis.dto.query.SysSettingsPageDTO;
import com.sw.basis.dto.request.SysSettingsModifyDTO;
import com.sw.basis.dto.response.SysSettingsDTO;
import com.sw.basis.entity.SysSettingsEntity;
import com.sw.basis.service.SysSettingsService;
import com.sw.basis.utils.Responses;
import com.sw.basis.utils.vo.CodeVO;
import com.sw.basis.utils.vo.IdVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 系统设置 前端控制器
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@Api(tags = "系统设置")
@RequestMapping("/sysSettings")
@RestController
public class SysSettingsController {

    @Resource
    SysSettingsService sysSettingsService;

    final static String PAGE = "系统设置_列表";
    @Log(desc = PAGE, type = Log.LOG_TYPE.SELECT)
    @ApiOperation(value = PAGE)
    @PostMapping(value = "/page")
    public Responses<IPage<SysSettingsDTO>> page(@RequestBody SysSettingsPageDTO dto){
        return sysSettingsService.page(dto);
    }

    final static String ADD = "系统设置_新增";
    @Log(desc = ADD, type = Log.LOG_TYPE.ADD)
    @ApiOperation(value = ADD)
    @PostMapping(value = "/add")
    public Responses<String> add(@RequestBody SysSettingsModifyDTO dto){
        return sysSettingsService.add(dto);
    }

    final static String UPDATEBYID = "系统设置_根据id修改";
    @Log(desc = UPDATEBYID, type = Log.LOG_TYPE.UPDATE)
    @ApiOperation(value = UPDATEBYID)
    @PostMapping(value = "/updateById")
    public Responses<String> updateById(@RequestBody SysSettingsModifyDTO dto){
        return sysSettingsService.updateById(dto);
    }

    final static String DEL = "系统设置_删除";
    @Log(desc = DEL, type = Log.LOG_TYPE.DEL)
    @ApiOperation(value = DEL)
    @PostMapping(value = "/del")
    public Responses<String> del(@RequestBody IdVO vo){
        return sysSettingsService.del(vo.getId());
    }

    final static String DETAIL = "系统设置_详情";
    @Log(desc = DETAIL, type = Log.LOG_TYPE.SELECT)
    @ApiOperation(value = DETAIL)
    @PostMapping(value = "/detail")
    public Responses<SysSettingsDTO> detail(@RequestBody CodeVO vo){
        SysSettingsEntity sysSettingsEntity = sysSettingsService.detail(vo.getCode());
        SysSettingsDTO dto = new SysSettingsDTO();
        if(sysSettingsEntity != null){
            BeanUtils.copyProperties(sysSettingsEntity,dto);
        }
        return Responses.success(dto);
    }
}

