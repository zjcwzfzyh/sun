package com.lfxwkj.sun.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lfxwkj.sun.entity.ItemCheck;
import com.lfxwkj.sun.util.PageUtil;

import java.util.List;

/**
 * <p>
 * 项目的检测项 服务类
 * </p>
 *
 * @author 张永辉
 * @since 2020-09-16
 */
public interface IItemCheckService extends IService<ItemCheck> {
    /**
     * @Description : 查询所有项目检测项的信息列表
     * @methodName : getItemcheckList
     * @param itemCheck :
     * @param pageUtil :
     * @return : IPage<ItemCheck>
     * @exception :
     * @author : 张乐
     */
    IPage<ItemCheck> getItemcheckList(ItemCheck itemCheck, PageUtil pageUtil);
    /**
     * @Description : 删除项目检测信息
     * @methodName : deleteItemcheck
     * @param id :
     * @return : void
     * @exception :
     * @author : 张乐
     */
    void deleteItemcheck(Long id);
    /**
     * @Description : 添加检测信息
     * @methodName : addItemCheck
     * @param itemCheck :
     * @return : boolean
     * @exception :
     * @author : 张乐
     */
    boolean addItemCheck(ItemCheck itemCheck);
    /**
     * @Author zhangle
     * @Description  根据id获取组件检查信息
     * @Date 20:31 2020/10/6
     * @Param [id]
     * @return java.util.List<java.lang.Object>
     * @methodName : getItemCheckById
     **/
    List<Object> getItemCheckById(Long id);
    /**
     * @Author zhangle
     * @Description 修改组件检查信息
     * @Date 20:43 2020/10/6
     * @Param [itemCheck]
     * @return void
     * @methodName : updateItemCheck
     **/
    void updateItemCheck(ItemCheck itemCheck);
}
