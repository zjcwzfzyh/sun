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
* 设备采集数据表
* </p>
*
* @author 张永辉
* @since 2020-09-16
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ToString(callSuper = true)
@TableName("tbl_gb_collect_data")
@ApiModel(value="CollectData对象", description="设备采集数据表")
public class CollectData implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "设备的编号")
    @TableField("dev_code")
    private String devCode;

    @ApiModelProperty(value = "设备种类，与数据字典对应不关联")
    @TableField("sub_code")
    private String subCode;

    @ApiModelProperty(value = "设备名称")
    @TableField("sub_name")
    private String subName;

    @ApiModelProperty(value = "添加时间")
    @TableField("add_time")
    private LocalDateTime addTime;

    @ApiModelProperty(value = "采集方式： 主动采集，自动上传。 取自数据字典，对应不关联")
    @TableField("add_user")
    private Long addUser;

    @ApiModelProperty(value = "备注")
    @TableField("remarks")
    private String remarks;

    @ApiModelProperty(value = "数据状态 与数据字典对应不关联")
    @TableField("state")
    private Integer state;

    @ApiModelProperty(value = "采集设备数据01   温度")
    @TableField("basic01")
    private String basic01;

    @ApiModelProperty(value = "采集设备数据02   湿度")
    @TableField("basic02")
    private String basic02;

    @ApiModelProperty(value = "设备数据03   电源状态")
    @TableField("basic03")
    private String basic03;


}