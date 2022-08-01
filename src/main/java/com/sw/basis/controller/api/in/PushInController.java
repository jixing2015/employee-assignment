package com.sw.basis.controller.api.in;


import com.sw.basis.annotation.Log;
import com.sw.basis.dto.api.*;
import com.sw.basis.service.*;
import com.sw.basis.utils.Responses;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 外部系统推送进入 前端控制器
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-21
 */
@Api(tags = "外部系统推送进入")
@RestController
@RequestMapping("/api/in/")
public class PushInController {

    @Resource
    SysDeptService sysDeptService;
    @Resource
    DeptRolesService deptRolesService;
    @Resource
    BusinessLineService businessLineService;
    @Resource
    RankRateService rankRateService;
    @Resource
    SecondedPersonnelService secondedPersonnelService;
    @Resource
    SysUserService sysUserService;
    @Resource
    ProjectService projectService;

    final static String PUSH_ORGANIZATION = "同步组织机构信息";
    @Log(desc = PUSH_ORGANIZATION, type = Log.LOG_TYPE.ADD_OR_UPDATE)
    @ApiOperation(value = PUSH_ORGANIZATION)
    @PostMapping("pushOrganization")
    public Responses<String> pushOrganization (@RequestBody List<OrganizationDTO> dtoList) {
        sysDeptService.pushOrganization(dtoList);
        return Responses.success();
    }

    final static String PUSH_DEPT_ROLES = "同步部门角色及人员";
    @Log(desc = PUSH_DEPT_ROLES, type = Log.LOG_TYPE.ADD_OR_UPDATE)
    @ApiOperation(value = PUSH_DEPT_ROLES)
    @PostMapping("pushDeptRoles")
    public Responses<String> pushDeptRoles (@RequestBody List<DeptRolesDTO> dtoList) {
        deptRolesService.pushDeptRoles(dtoList);
        return Responses.success();
    }

    final static String PUSH_BUSINESS_LINE = "同步业务线设置";
    @Log(desc = PUSH_BUSINESS_LINE, type = Log.LOG_TYPE.ADD_OR_UPDATE)
    @ApiOperation(value = PUSH_BUSINESS_LINE)
    @PostMapping("pushBusinessLine")
    public Responses<String> pushBusinessLine (@RequestBody List<BusinessLineDTO> dtoList) {
        businessLineService.pushBusinessLine(dtoList);
        return Responses.success();
    }

    final static String PUSH_RANK_RATE = "同步职级费率";
    @Log(desc = PUSH_RANK_RATE, type = Log.LOG_TYPE.ADD_OR_UPDATE)
    @ApiOperation(value = PUSH_RANK_RATE)
    @PostMapping("pushRankRate")
    public Responses<String> pushRankRate (@RequestBody List<RankRateDTO> dtoList) {
        rankRateService.pushRankRate(dtoList);
        return Responses.success();
    }

    final static String PUSH_SECONDED_PERSONNEL = "同步人员借调批量设置";
    @Log(desc = PUSH_SECONDED_PERSONNEL, type = Log.LOG_TYPE.ADD_OR_UPDATE)
    @ApiOperation(value = PUSH_SECONDED_PERSONNEL)
    @PostMapping("pushSecondedPersonnel")
    public Responses<String> pushSecondedPersonnel (@RequestBody List<SecondedPersonnelDTO> dtoList) {
        secondedPersonnelService.pushSecondedPersonnel(dtoList);
        return Responses.success();
    }

    final static String PUSH_USER = "同步员工档案";
    @Log(desc = PUSH_USER, type = Log.LOG_TYPE.ADD_OR_UPDATE)
    @ApiOperation(value = PUSH_USER)
    @PostMapping("pushUser")
    public Responses<String> pushUser (@RequestBody List<UserDTO> dtoList) {
        sysUserService.pushUser(dtoList);
        return Responses.success();
    }

    final static String PUSH_PROJECT = "同步项目信息";
    @Log(desc = PUSH_PROJECT, type = Log.LOG_TYPE.ADD_OR_UPDATE)
    @ApiOperation(value = PUSH_PROJECT)
    @PostMapping("pushProject")
    public Responses<String> pushProject (@RequestBody List<ProjectDTO> dtoList) {
        projectService.pushProject(dtoList);
        return Responses.success();
    }
}

