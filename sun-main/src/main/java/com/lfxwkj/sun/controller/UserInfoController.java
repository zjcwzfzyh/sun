package com.lfxwkj.sun.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lfxwkj.sun.common.ResponseResult;
import com.lfxwkj.sun.common.ResponseResultEnum;
import com.lfxwkj.sun.entity.RoleInfo;
import com.lfxwkj.sun.entity.UserInfo;
import com.lfxwkj.sun.service.IRoleInfoService;
import com.lfxwkj.sun.service.IUserInfoService;
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
* 用户表 控制层
* </p>
*
* @author 张永辉
* @since 2020-05-06
*/
@Slf4j
@RestController
@Api(tags = "用户表接口")
public class UserInfoController {

    @Autowired
    private IUserInfoService userInfoService;
    @Autowired
    private IRoleInfoService roleInfoService;

    /**
     * @Description : 跳转到添加用户页面
     * @methodName : toAddUserInfoPage
     * @param map :
     * @return : org.springframework.web.servlet.ModelAndView
     * @exception :
     * @author : 张永辉
     */
    @GetMapping("/toAddUserInfoPage")
    public ModelAndView toAddUserInfoPage(Map<String,Object> map){
        QueryWrapper<RoleInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_enable",1);
        List<RoleInfo> list = roleInfoService.list(queryWrapper);
        map.put("roleInfoList",list);
        return new ModelAndView("user/user-add");
    }

    /**
     * @Description : 跳转到修改用户页面
     * @methodName : toUpdateUserInfoPage
     * @param map :
     * @return : ModelAndView
     * @exception :
     * @author : 张永辉
     */
    @GetMapping("/toUpdateUserInfoPage")
    public ModelAndView toUpdateUserInfoPage(Map<String,Object> map){
        QueryWrapper<RoleInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_enable",1);
        List<RoleInfo> list = roleInfoService.list(queryWrapper);
        map.put("roleInfoList",list);
        return new ModelAndView("user/user-edit");
    }

    /**
     * @Description : 获取用户列表信息
     * @methodName : getUserInfoList
     * @param userInfo :
     * @param pageUtil :
     * @return : com.lfxwkj.storage.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @GetMapping("/getUserInfoList")
    public ResponseResult getUserInfoList(UserInfo userInfo, PageUtil pageUtil){
        ResponseResult responseResult = null;
        try {
            IPage<UserInfo> iPage = userInfoService.getUserInfoList(userInfo,pageUtil);
            log.info("获取用户列表信息成功！");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),iPage,"获取用户列表信息成功！");
        } catch(Exception e){
            log.error("获取用户列表信息失败！",e);
            responseResult = ResponseResult.failure("获取用户列表信息失败！");
        }
        return responseResult;
    }

    /**
     * @Description : 添加用户信息
     * @methodName : addUserInfo
     * @param userInfo :
     * @return : com.lfxwkj.storage.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @PostMapping("/addUserInfo")
    public ResponseResult addUserInfo(UserInfo userInfo, @RequestParam("roleIds") String[] roleIds){
        ResponseResult responseResult = null;
        try {
            boolean b = userInfoService.addUserInfo(userInfo, roleIds);
            if (b){
                log.info("添加用户信息成功！");
                responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"添加用户信息成功！");
            }else {
                log.info("用户名重复，添加用户信息失败！");
                responseResult = ResponseResult.failure("用户名重复，添加用户信息失败！");
            }
        } catch(Exception e){
            log.error("添加用户失败！",e);
            responseResult = ResponseResult.failure("添加用户信息失败！");
        }
        return responseResult;
    }

    /**
     * @Description : 修改用户信息
     * @methodName : updateUserInfo
     * @param userInfo :
     * @param roleIds :
     * @return : com.lfxwkj.storage.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @PutMapping("/updateUserInfo")
    public ResponseResult updateUserInfo(UserInfo userInfo, String[] roleIds) {
        ResponseResult responseResult = null;
        try {
            userInfoService.updateUserInfo(userInfo,roleIds);
            log.info("修改用户信息成功！");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"修改用户信息成功！");
        } catch(Exception e){
            log.error("修改用户信息失败！",e);
            responseResult = ResponseResult.failure("修改用户信息失败！");
        }
        return responseResult;
    }

    /**
     * @Description : 删除用户信息
     * @methodName : deleteUserInfo
     * @param id :
     * @return : com.lfxwkj.storage.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @DeleteMapping("/deleteUserInfo/{id}")
    public ResponseResult deleteUserInfo(@PathVariable("id") Long id) {
        ResponseResult responseResult = null;
        try {
            userInfoService.deleteUserInfo(id);
            log.info("删除用户信息成功！");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"删除用户信息成功！");
        } catch(Exception e){
            log.error("删除用户信息失败！",e);
            responseResult = ResponseResult.failure("删除用户信息失败！");
        }
        return responseResult;
    }

    /**
     * @Description : 根据id获取用户信息
     * @methodName : getUserInfoById
     * @param id :
     * @return : com.lfxwkj.storage.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @GetMapping("/getUserInfoById/{id}")
    public ResponseResult getUserInfoById(@PathVariable("id") Long id){
        ResponseResult responseResult = null;
        try {
            List<Object> list = userInfoService.getUserInfoById(id);
            log.info("根据id获取用户信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),list,"根据id获取用户信息成功");
        } catch(Exception e){
            log.error("根据id获取用户信息失败",e);
            responseResult = ResponseResult.failure("根据id获取用户信息失败");
        }
        return responseResult;
    }

    /**
     * @Description : 重置密码
     * @methodName : resetPassword
     * @param userInfo :
     * @return : com.lfxwkj.storage.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @PutMapping("/resetPassword")
    public ResponseResult resetPassword(UserInfo userInfo) {
        ResponseResult responseResult = null;
        try {
            userInfoService.resetPassword(userInfo);
            log.info("重置密码成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"重置密码成功");
        } catch(Exception e){
            log.error("重置密码失败",e);
            responseResult = ResponseResult.failure("重置密码失败");
        }
        return responseResult;
    }

    /**
     * @Description : 修改用户密码
     * @methodName : updatePassword
     * @param password :
     * @return : com.lfxwkj.storage.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @PutMapping("/updatePassword")
    public ResponseResult updatePassword(String password){
        ResponseResult responseResult = null;
        try {
            userInfoService.updateUserPassword(password);
            log.info("修改用户密码成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"修改用户密码成功");
        } catch(Exception e){
            log.error("修改用户密码失败",e);
            responseResult = ResponseResult.failure("修改用户密码失败");
        }
        return responseResult;
    }

    /**
     * @Description : 获取用户列表，用于下拉框
     * @methodName : getUsers
     * @return : com.lfxwkj.storage.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @GetMapping("/getUsers")
    public ResponseResult getUsers(){
        ResponseResult responseResult = null;
        try {
            QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("is_enable",1);
            List<UserInfo> list = userInfoService.list(queryWrapper);
            log.info("获取用户列表，用于下拉框成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),list,"获取用户列表，用于下拉框成功");
        } catch(Exception e){
            log.error("获取用户列表，用于下拉框失败",e);
            responseResult = ResponseResult.failure("获取用户列表，用于下拉框失败");
        }
        return responseResult;
    }

}
