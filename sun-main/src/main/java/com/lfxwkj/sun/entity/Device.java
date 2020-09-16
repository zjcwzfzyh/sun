package com.lfxwkj.sun.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
* <p>
* 设备表
* </p>
*
* @author 张永辉
* @since 2020-09-16
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ToString(callSuper = true)
@TableName("tbl_gb_device")
@ApiModel(value="Device对象", description="设备表")
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "设备的编号")
    @TableField("dev_code")
    private String devCode;

    @ApiModelProperty(value = "设备种类，与数据字典对应不关联")
    @TableField("dev_type")
    private Long devType;

    @ApiModelProperty(value = "设备名称")
    @TableField("dev_name")
    private String devName;

    @ApiModelProperty(value = "添加时间")
    @TableField("add_time")
    private LocalDateTime addTime;

    @ApiModelProperty(value = "添加人")
    @TableField("add_user")
    private Long addUser;

    @ApiModelProperty(value = "设备的位置")
    @TableField("location")
    private String location;

    @ApiModelProperty(value = "备注")
    @TableField("remarks")
    private String remarks;

    @ApiModelProperty(value = "设备状态， 与数据字典对应不关联")
    @TableField("state")
    private Integer state;


}