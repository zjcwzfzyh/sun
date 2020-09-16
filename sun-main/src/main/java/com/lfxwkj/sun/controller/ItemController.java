package com.lfxwkj.sun.controller;

import com.lfxwkj.sun.service.IItemService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* 项目表 控制层
* </p>
*
* @author 张永辉
* @since 2020-09-16
*/
@Slf4j
@RestController
@Api(tags = "项目表接口")
public class ItemController {

    @Autowired
    private IItemService itemService;

}
