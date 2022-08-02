package com.sw.basis.dto.api;

import com.sw.basis.dto.request.DispatchProjectModifyDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 同步派遣记录DTO
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@ApiModel(value = "同步派遣记录DTO")
@Data
public class EmployeeAssignmentDTO {

    @ApiModelProperty(value = "派遣单号")
    private String orderId;

    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    @ApiModelProperty(value = "每日派工小时数")
    private Integer hoursPerDay;

    @ApiModelProperty(value = "项目列表")
    private List<DispatchProjectModifyDTO> projectList;

    @ApiModelProperty(value = "执业地点")
    private String address;

    @ApiModelProperty(value = "结算方式;0分成；1人才基地；")
    private Integer settlement;

    @ApiModelProperty(value = "人员列表")
    private List<DispatchPeoplesApiDTO> userList;
}
