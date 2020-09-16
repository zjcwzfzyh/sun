package com.lfxwkj.sun.controller;

import com.lfxwkj.sun.service.IDeviceSubService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* 设备的组件信息表 控制层
* </p>
*
* @author 张永辉
* @since 2020-09-16
*/
@Slf4j
@RestController
@Api(tags = "设备的组件信息表接口")
public class DeviceSubController {

    @Autowired
    private IDeviceSubService deviceSubService;

}
