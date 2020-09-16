package com.lfxwkj.sun.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lfxwkj.sun.common.ResponseResult;
import com.lfxwkj.sun.common.ResponseResultEnum;
import com.lfxwkj.sun.entity.RolePermRelated;
import com.lfxwkj.sun.service.IRolePermRelatedService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* <p>
* 角色和权限中间表 控制层
* </p>
*
* @author 张永辉
* @since 2020-05-06
*/
@Slf4j
@RestController
@Api(tags = "角色和权限中间表接口")
public class RolePermRelatedController {

    @Autowired
    private IRolePermRelatedService rolePermRelatedService;

    /**
     * @Description : 获取指定角色与权限的关系列表
     * @methodName : getRolePermRelatedList
     * @param roleId :
     * @return : com.lfxwkj.storage.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @GetMapping("/getRolePermRelatedList/{roleId}")
    public ResponseResult getRolePermRelatedList(@PathVariable("roleId") Long roleId){
        ResponseResult responseResult = null;
        try {
            QueryWrapper<RolePermRelated> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("role_id",roleId);
            List<RolePermRelated> list = rolePermRelatedService.list(queryWrapper);
            log.info("获取指定角色与权限的关系列表成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),list,"获取指定角色与权限的关系列表成功");
        } catch(Exception e){
            log.error("获取指定角色与权限的关系列表失败",e);
            responseResult = ResponseResult.failure("获取指定角色与权限的关系列表失败");
        }
        return responseResult;
    }

}
