package com.lfxwkj.sun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
* <p>
* 权限信息表
* </p>
*
* @author 张永辉
* @since 2020-05-06
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ToString(callSuper = true)
@TableName("tbl_gb_permission_info")
@ApiModel(value="PermissionInfo对象", description="权限信息表")
public class PermissionInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "权限主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "权限名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "权限")
    @TableField("perm")
    private String perm;

    @ApiModelProperty(value = "权限父标识")
    @TableField("p_id")
    private Long pId;


}