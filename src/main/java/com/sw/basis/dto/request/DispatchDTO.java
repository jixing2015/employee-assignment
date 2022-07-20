package com.sw.basis.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 派遣表单 DTO
 * @author jixing2000
 * @date 2022/7/20 0020 15:39:43
 **/
@ApiModel(value = "派遣表单 DTO")
@Data
public class DispatchDTO {

    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    @ApiModelProperty(value = "每日派工小时数")
    private Integer hoursPerDay;

    @ApiModelProperty(value = "项目列表")
    private List<ProjectModifyDTO> projectList;

    @ApiModelProperty(value = "执业地点")
    private String address;

    @ApiModelProperty(value = "结算方式;0分成；1人才基地；")
    private Integer settlement;

    @ApiModelProperty(value = "人员列表")
    private List<SysUserModifyDTO> userList;

}
