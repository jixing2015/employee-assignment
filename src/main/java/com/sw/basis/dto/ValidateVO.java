package com.sw.basis.dto;

import com.sw.basis.dto.request.ProjectModifyDTO;
import com.sw.basis.dto.request.SysUserModifyDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 校验 VO
 * @author jixing2000
 * @date 2022/7/20 0020 15:39:43
 **/
@ApiModel(value = "校验 VO")
@Data
public class ValidateVO {

    @ApiModelProperty(value = "派遣开始时间")
    private Date startTime;

    @ApiModelProperty(value = "派遣结束时间")
    private Date endTime;

    @ApiModelProperty(value = "项目列表")
    private List<ProjectModifyDTO> projectList;

    @ApiModelProperty(value = "人员列表")
    private List<SysUserModifyDTO> userList;

}
