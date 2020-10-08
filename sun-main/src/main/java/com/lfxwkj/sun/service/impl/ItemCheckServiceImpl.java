package com.lfxwkj.sun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lfxwkj.sun.entity.ItemCheck;
import com.lfxwkj.sun.mapper.ItemCheckMapper;
import com.lfxwkj.sun.service.IItemCheckService;
import com.lfxwkj.sun.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 项目的检测项 服务实现类
 * </p>
 *
 * @author 张永辉
 * @since 2020-09-16
 */
@Service
public class ItemCheckServiceImpl extends ServiceImpl<ItemCheckMapper, ItemCheck> implements IItemCheckService {
    @Autowired
    private ItemCheckMapper itemCheckMapper;
    /**
     * @Description : 获取检测项目列表
     * @methodName : getItemcheckList
     * @param itemCheck :
     * @param pageUtil :
     * @return : IPage<ItemCheck>
     * @exception :
     * @author : 张乐
     */
    @Override
    public IPage<ItemCheck> getItemcheckList(ItemCheck itemCheck, PageUtil pageUtil) {
        IPage<ItemCheck> iPage = new Page<>(pageUtil.getPage(),pageUtil.getLimit());
        QueryWrapper<ItemCheck> queryWrapper = new QueryWrapper<>();
        if (itemCheck.getItemName() != null && !"".equals(itemCheck.getItemName())){
            queryWrapper.like("item_name",itemCheck.getItemName());
        }
        queryWrapper.eq("state",1);
        iPage = itemCheckMapper.selectPage(iPage,queryWrapper);
        return iPage;
    }
    /**
     * @Description : 删除项目检测信息
     * @methodName : deleteItemcheck
     * @param id :
     * @return : void
     * @exception :
     * @author : 张乐
     */
    @Override
    public void deleteItemcheck(Long id) {
        ItemCheck itemCheck=new ItemCheck();
        itemCheck.setId(id).setState(0);
        itemCheckMapper.updateById(itemCheck);
    }
    /**
     * @Description : 添加项目检查信息
     * @methodName : addItemCheck
     * @param itemCheck :
     * @return : boolean
     * @exception :
     * @author : 张乐
     */
    @Override
    public boolean addItemCheck(ItemCheck itemCheck) {


//        userInfo.setPassword(MD5Util.getMD5(userInfo.getPassword())).setCreateTime(LocalDateTime.now());
//        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("user_name",userInfo.getUserName());
//        queryWrapper.eq("is_enable",1);
        LocalDateTime now = LocalDateTime.now();
        itemCheck.setAddTime(now);
        itemCheckMapper.insert(itemCheck);
        return true;
    }
    /**
     * @Author zhangle
     * @Description  根据id获取用户信息
     * @Date 20:36 2020/10/6
     * @Param [id]
     * @return java.util.List<java.lang.Object>
     * @methodName : getItemCheckById
     **/
    @Override
    public List<Object> getItemCheckById(Long id) {
        List<Object>list=new ArrayList<>();
        ItemCheck itemCheck=itemCheckMapper.selectById(id);
        list.add(itemCheck);
        return list;
    }
    /**
     * @Author zhangle
     * @Description 修改组件检查信息
     * @Date 20:46 2020/10/6
     * @Param [itemCheck]
     * @return void
     * @methodName : updateItemCheck
     **/
    @Override
    public void updateItemCheck(ItemCheck itemCheck) {
        //修改组件检查信息
        itemCheckMapper.updateById(itemCheck);
    }

}
