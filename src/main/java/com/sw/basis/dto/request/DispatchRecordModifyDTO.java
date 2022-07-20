package com.sw.basis.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 派遣记录表 ModifyDTO
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@ApiModel(value = "派遣记录表 ModifyDTO")
@Data
public class DispatchRecordModifyDTO {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "订单号")
    private String orderId;

    @ApiModelProperty(value = "用户编号")
    private String userCode;

    @ApiModelProperty(value = "项目编号")
    private String projectCode;

    @ApiModelProperty(value = "派遣开始时间")
    private Date startTime;

    @ApiModelProperty(value = "派遣结束时间")
    private Date endTime;

    @ApiModelProperty(value = "每日派遣小时数")
    private Integer hoursPerDay;

    @ApiModelProperty(value = "执业地点")
    private String address;

    @ApiModelProperty(value = "结算方式;0分成；1人才基地；")
    private Integer settlement;

    @ApiModelProperty(value = "派工成本")
    private BigDecimal dispatchCost;

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新人")
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "是否删除;0表示未删除，1表示删除")
    private Integer delFlag;
}
