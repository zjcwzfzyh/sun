package com.lfxwkj.sun.controller;

import com.lfxwkj.sun.service.IUserRoleRelatedService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* 用户和角色中间表 控制层
* </p>
*
* @author 张永辉
* @since 2020-05-06
*/
@Slf4j
@RestController
@Api(tags = "用户和角色中间表接口")
public class UserRoleRelatedController {

    @Autowired
    private IUserRoleRelatedService userRoleRelatedService;

}
