package com.sw.basis.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 字典DTO
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@ApiModel(value = "字典 DTO")
@Data
public class SysDictDTO {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "字典编号")
    private String code;

    @ApiModelProperty(value = "父级字典编号")
    private String pcode;

    @ApiModelProperty(value = "字典名称")
    private String name;

    @ApiModelProperty(value = "键")
    private String itemKey;

    @ApiModelProperty(value = "值")
    private String itemValue;

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
