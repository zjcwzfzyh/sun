package com.lfxwkj.sun.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lfxwkj.sun.common.ResponseResult;
import com.lfxwkj.sun.common.ResponseResultEnum;
import com.lfxwkj.sun.entity.Device;
import com.lfxwkj.sun.entity.RoleInfo;
import com.lfxwkj.sun.entity.UserInfo;
import com.lfxwkj.sun.service.IDeviceService;
import com.lfxwkj.sun.util.PageUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
* <p>
* 设备表 控制层
* </p>
*
* @author 张永辉
* @since 2020-09-16
*/
@Slf4j
@RestController
@Api(tags = "设备表接口")
public class DeviceController {

    @Autowired
    private IDeviceService deviceService;

    /**
     * @Description : 跳转添加设备信息页面
     * @methodName : toAddDevicePage
     * @param map :
     * @return : org.springframework.web.servlet.ModelAndView
     * @exception :跳转添加设备信息页面
     * @author : 李阳
     */
    @GetMapping("/toAddDevicePage")
    public ModelAndView toAddDevicePage(Map<String,Object> map){
        return new ModelAndView("device/device-add");
    }

    /**
     * @Description : 添加设备信息
     * @methodName : addDevice
     * @param device :
     * @return : com.lfxwkj.sun.common.ResponseResult
     * @exception :添加设备信息
     * @author : 李阳
     */
    @PostMapping("/addDevice")
    public ResponseResult addDevice(Device device,@RequestParam("addUsername") String addUser){
        ResponseResult responseResult = null;
        try {
            boolean b = deviceService.addDevice(device,addUser);
            if (b){
                log.info("添加设备信息成功！");
                responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"添加设备信息成功！");
            }else {
                log.info("设备编号重复，添加用户信息失败！");
                responseResult = ResponseResult.failure("设备编号重复，添加用户信息失败！");
            }
        } catch(Exception e){
            log.error("添加用户设备！",e);
            responseResult = ResponseResult.failure("添加设备信息失败！");
        }
        return responseResult;
    }

    /**
     * @Description : 跳转修改用户信息页面
     * @methodName : toUpdateDevicePage
     * @param map :
     * @return : org.springframework.web.servlet.ModelAndView
     * @exception :跳转修改用户信息页面
     * @author : 李阳
     */
    @GetMapping("/toUpdateDevicePage")
    public ModelAndView toUpdateDevicePage(Map<String,Object> map){
        return new ModelAndView("device/device-edit");
    }

    /**
     * @Description : 根据id获取设备信息
     * @methodName : getDeviceById
     * @param id :
     * @return : com.lfxwkj.sun.common.ResponseResult
     * @exception :根据id获取设备信息
     * @author : 李阳
     */
    @GetMapping("/getDeviceById/{id}")
    public ResponseResult getDeviceById(@PathVariable("id") Long id){

        ResponseResult responseResult = null;
        try {
            Device device = deviceService.getDeviceById(id);
            log.info("根据id获取设备信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),device,"根据id获取设备信息成功");
        } catch(Exception e){
            log.error("根据id获取设备信息失败",e);
            responseResult = ResponseResult.failure("根据id获取设备信息失败");
        }
        return responseResult;
    }

    /**
     * @Description : 修改设备信息
     * @methodName : UpdateDevice
     * @param device :
     * @return : com.lfxwkj.sun.common.ResponseResult
     * @exception :修改设备信息
     * @author : 李阳
     */
    @PutMapping("/UpdateDevice")
    public ResponseResult UpdateDevice(Device device) {

        ResponseResult responseResult = null;
        try {
            deviceService.updateUserInfo(device);
            log.info("修改设备信息成功！");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"修改设备信息成功！");
        } catch(Exception e){
            log.error("修改设备信息失败！",e);
            responseResult = ResponseResult.failure("修改设备信息失败！");
        }
        return responseResult;
    }

    /**
     * @Description : 获取设备列表信息
     * @methodName : getDeviceList
     * @param device
     * @param pageUtil :
     * @return : com.lfxwkj.sun.common.ResponseResult
     * @exception :获取设备列表信息
     * @author : 李阳
     */
    @GetMapping("/getDeviceList")
    public ResponseResult getDeviceList(Device device, PageUtil pageUtil){
        ResponseResult responseResult = null;
        try {
            IPage<Device> iPage = deviceService.getDeviceList(device,pageUtil);
            log.info("获取设备列表信息成功！");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),iPage,"获取设备列表信息成功！");
        } catch(Exception e){
            log.error("获取设备列表信息失败！",e);
            responseResult = ResponseResult.failure("获取设备列表信息失败！");
        }
        return responseResult;
    }

    /**
     * @Description : 删除设备列表信息
     * @methodName : deleteDeviceList
     * @param id :
     * @return : com.lfxwkj.sun.common.ResponseResult
     * @exception :删除设备信息
     * @author : 李阳
     */
    @DeleteMapping("/deleteDevice/{id}")
    public ResponseResult deleteDeviceList(@PathVariable("id") Long id){

        ResponseResult responseResult = null;
        try {
            deviceService.deleteDevice(id);
            log.info("删除设备列表信息成功！");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"删除设备列表信息成功！");
        } catch(Exception e){
            log.error("删除设备列表信息失败！",e);
            responseResult = ResponseResult.failure("删除设备列表信息失败！");
        }
        return responseResult;
    }
}
