package com.sw.basis.dto.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


/**
 * 休假表DTO
 *
 * @author jixing2000
 * @since 2022-08-02
 */
@ApiModel(value = "休假表DTO")
@Data
public class VacationDTO {

    @ApiModelProperty(value = "请假单编号")
    private String lvleavereqReqid;

    @ApiModelProperty(value = "员工编号")
    private String lvleavereqEmpid;

    @ApiModelProperty(value = "开始日期")
    private Date lvleavereqBedate;

    @ApiModelProperty(value = "结束日期")
    private Date lvleavereqEdate;

    @ApiModelProperty(value = "是否全天")
    private Integer lvleavereqBtype;

    @ApiModelProperty(value = "开始时间1")
    private Date lvleavereqBbtime;

    @ApiModelProperty(value = "结束时间1")
    private Date lvleavereqBetime;

    @ApiModelProperty(value = "开始时间2")
    private Date lvleavereqEbtime;

    @ApiModelProperty(value = "结束时间2")
    private Date lvleavereqEetime;

    @ApiModelProperty(value = "小时数")
    private Integer lvleavereqTotalhours;

}