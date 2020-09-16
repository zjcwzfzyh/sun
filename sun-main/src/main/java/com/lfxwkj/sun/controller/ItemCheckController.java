package com.lfxwkj.sun.controller;

import com.lfxwkj.sun.service.IItemCheckService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* 项目的检测项 控制层
* </p>
*
* @author 张永辉
* @since 2020-09-16
*/
@Slf4j
@RestController
@Api(tags = "项目的检测项接口")
public class ItemCheckController {

    @Autowired
    private IItemCheckService itemCheckService;

}
