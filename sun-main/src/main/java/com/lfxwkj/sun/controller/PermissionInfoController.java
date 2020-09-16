package com.lfxwkj.sun.controller;

import com.lfxwkj.sun.common.ResponseResult;
import com.lfxwkj.sun.common.ResponseResultEnum;
import com.lfxwkj.sun.entity.PermissionInfo;
import com.lfxwkj.sun.service.IPermissionInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* <p>
* 权限信息表 控制层
* </p>
*
* @author 张永辉
* @since 2020-05-06
*/
@Slf4j
@RestController
@Api(tags = "权限信息表接口")
public class PermissionInfoController {

    @Autowired
    private IPermissionInfoService permissionInfoService;

    /**
     * @Description : 获取权限列表
     * @methodName : getPermissionInfoList
     * @return : com.lfxwkj.storage.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @ApiOperation("获取权限列表")
    @GetMapping("/getPermissionInfoList")
    public ResponseResult getPermissionInfoList(){
        ResponseResult responseResult = null;
        try {
            List<PermissionInfo> list = permissionInfoService.list();
            log.info("获取权限列表成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),list,"获取权限列表成功");
        } catch(Exception e){
            log.error("获取权限列表失败",e);
            responseResult = ResponseResult.failure("获取权限列表失败");
        }
        return responseResult;
    }


}
