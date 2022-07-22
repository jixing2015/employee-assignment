package com.sw.basis.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


/**
 * 派遣项目关联表
 *
 * @author jixing2000
 * @since 2022-07-22
 */
@ApiModel(value = "派遣项目关联表 ModifyDTO")
@Data
public class DispatchProjectModifyDTO {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "派遣订单号")
    private String orderId;

    @ApiModelProperty(value = "项目编号")
    private String projectCode;

    @ApiModelProperty(value = "项目名称")
    private String projectName;

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