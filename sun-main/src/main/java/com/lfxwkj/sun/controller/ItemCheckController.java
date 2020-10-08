package com.lfxwkj.sun.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lfxwkj.sun.common.ResponseResult;
import com.lfxwkj.sun.common.ResponseResultEnum;
import com.lfxwkj.sun.entity.ItemCheck;
import com.lfxwkj.sun.service.IItemCheckService;
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
    @Autowired
    private IUserInfoService iUserInfoService;
    /**
     * @Description : 查询所有项目检测接口的列表
     * @methodName : getItemcheckList
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : 张乐
     */
    @GetMapping("/getItemcheckList")
    public ResponseResult getItemcheckList(ItemCheck itemCheck, PageUtil pageUtil){
        ResponseResult responseResult=null;
        try {
            IPage<ItemCheck> iPage = itemCheckService.getItemcheckList(itemCheck,pageUtil);
            log.info("获取项目检测接口列表成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),iPage,"获取项目检测接口列表成功");
        } catch(Exception e) {
            log.error("获取项目检测接口列表失败", e);
            responseResult = ResponseResult.failure("获取项目检测接口列表失败");
        }
        return responseResult;
    }
    /**
     * @Description : 删除项目检测项目
     * @methodName : deleteItemcheck
     * @param id :
     * @return : com.lfxwkj.storage.common.ResponseResult
     * @exception :
     * @author : 张乐
     */
    @DeleteMapping("/deleteItemcheck/{id}")
    public ResponseResult deleteItemcheck(@PathVariable("id") Long id ){
        ResponseResult responseResult=null;
        try {
            itemCheckService.deleteItemcheck(id);
            log.info("删除组件信息成功");
            responseResult= ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"删除组件信息成功");
        } catch (Exception e) {
            log.info("删除组件信息失败",e);
            responseResult= ResponseResult.failure("删除组件信息失败！");
        }
        return responseResult;
    }
    /**
     * @Author zhangle
     * @Description //TODO 添加检测项目信息
     * @Date 16:20 2020/10/3
     * @Param [itemCheck]
     * @return com.lfxwkj.sun.common.ResponseResult
     * @methodName : addItemCheck
     **/
    @PostMapping("/addItemCheck")
    public ResponseResult addItemCheck(ItemCheck itemCheck){
        ResponseResult responseResult=null;
        try{
            boolean b=itemCheckService.addItemCheck(itemCheck);
            if (b){
                log.info("添加检查信息成功！");
                responseResult= ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"添加检查信息成功！");
            }else{
                log.info("添加检查信息失败！");
                responseResult= ResponseResult.failure("添加检查信息失败！");
            }
        } catch (Exception e) {
            log.info("添加检查信息失败！",e);
            responseResult= ResponseResult.failure("添加检查信息失败！");
        }
        return responseResult;
    }
    /**
     * @Author zhangle
     * @Description //TODO
     * @Date 16:02 2020/10/3
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     * @methodName : toAddItemCheck
     **/
    @GetMapping("/toAddItemCheck")
    public ModelAndView toAddItemCheck(){
//        QueryWrapper<RoleInfo> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("is_enable",1);
//        List<RoleInfo> list = roleInfoService.list(queryWrapper);
//        map.put("roleInfoList",list);
        log.info("tianjiatianjia!!!!");
        return new ModelAndView("itemCheck/itemCheck-add");
    }
    /**
     * @Author zhangle
     * @Description id获得组件检查信息
     * @Date 20:45 2020/10/6
     * @Param [id]
     * @return com.lfxwkj.sun.common.ResponseResult
     * @methodName : getItemCheckById
     **/
    @GetMapping("/getItemCheckById/{id}")
    public ResponseResult getItemCheckById(@PathVariable("id") Long id){
        log.info(id+"@@@@@@@@@@@");
        ResponseResult responseResult=null;
        try{
            List<Object>list=itemCheckService.getItemCheckById(id);
            log.info("根据id获得组件检查信息成功！");
            responseResult= ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),list,"根据id获取组件检查信息成功！");

        } catch (Exception e) {
            log.info("根据id获取组件检查信息失败",e);
            responseResult= ResponseResult.failure("根据id获取组件检查信息失败");

        }
        return responseResult;
    }
    /**
     * @Author zhangle
     * @Description 修改组件检查信息
     * @Date 20:53 2020/10/6
     * @Param [itemCheck]
     * @return com.lfxwkj.sun.common.ResponseResult
     * @methodName : updateItemCheck
     **/
    @PutMapping("/updateItemCheck")
    public ResponseResult updateItemCheck(ItemCheck itemCheck){
        ResponseResult responseResult=null;
        try{
            itemCheckService.updateItemCheck(itemCheck);
            log.info("修改组件检查信息成功！");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"修改组件检查信息成功！");
        } catch(Exception e){
            log.error("修改组件检查信息失败！",e);
            responseResult = ResponseResult.failure("修改组件检查信息失败！");
        }
        return responseResult;
    }
    /**
     * @Author zhangle
     * @Description  跳转编辑组件检查信息页面
     * @Date 9:30 2020/10/7
     * @Param [map]
     * @return org.springframework.web.servlet.ModelAndView
     * @methodName : toUpdateItemCheckPage
     **/
    @GetMapping("/toUpdateItemCheckPage")
    public ModelAndView toUpdateItemCheckPage(Map<String,Object> map){
        map.put("id",1);
        log.info("跳转编辑信息页面！！！！！！！！！！");
        return new ModelAndView("itemCheck/itemCheck-edit");
    }

}
