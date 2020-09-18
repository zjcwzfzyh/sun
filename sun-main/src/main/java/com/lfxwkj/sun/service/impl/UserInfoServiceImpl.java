package com.lfxwkj.sun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lfxwkj.sun.common.LoginUserInfoManager;
import com.lfxwkj.sun.entity.UserInfo;
import com.lfxwkj.sun.entity.UserRoleRelated;
import com.lfxwkj.sun.mapper.UserInfoMapper;
import com.lfxwkj.sun.mapper.UserRoleRelatedMapper;
import com.lfxwkj.sun.service.IUserInfoService;
import com.lfxwkj.sun.util.MD5Util;
import com.lfxwkj.sun.util.PageUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 张永辉
 * @since 2020-05-06
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserRoleRelatedMapper userRoleRelatedMapper;

    /**
     * @Description : 获取用户列表信息
     * @methodName : getUserInfoList
     * @param userInfo :
     * @param pageUtil :
     * @return : IPage<UserInfo>
     * @exception :
     * @author : 张永辉
     */
    @Override
    public IPage<UserInfo> getUserInfoList(UserInfo userInfo, PageUtil pageUtil) {
        IPage<UserInfo> iPage = new Page<>(pageUtil.getPage(),pageUtil.getLimit());
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        if (userInfo.getName() != null && !"".equals(userInfo.getName())){
            queryWrapper.like("name",userInfo.getName());
        }
        Optional.ofNullable(userInfo.getStartTime()).ifPresent(n ->
                queryWrapper.gt("create_time",userInfo.getStartTime()));
        Optional.ofNullable(userInfo.getEndTime()).ifPresent(n ->
                queryWrapper.lt("create_time",userInfo.getEndTime()));
        queryWrapper.eq("is_enable",1);
        iPage = userInfoMapper.selectPage(iPage,queryWrapper);
        return iPage;
    }

    /**
     * @Description : 添加用户信息
     * @methodName : addUserInfo
     * @param userInfo :
     * @param roleIds :
     * @return : boolean
     * @exception :
     * @author : zyh
     */
    @Override
    @Transactional
    public boolean addUserInfo(UserInfo userInfo, String[] roleIds) {
        userInfo.setPassword(MD5Util.getMD5(userInfo.getPassword())).setCreateTime(LocalDateTime.now());
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",userInfo.getUserName());
        queryWrapper.eq("is_enable",1);
        UserInfo info = userInfoMapper.selectOne(queryWrapper);
        if (info != null){
            return false;
        }
        userInfoMapper.insert(userInfo);
        //添加用户与角色关系
        for (int i = 1; i < roleIds.length; i++) {
            UserRoleRelated userRoleRelated = new UserRoleRelated();
            userRoleRelated.setUserId(userInfo.getId()).setRoleId(Long.parseLong(roleIds[i]));
            userRoleRelatedMapper.insert(userRoleRelated);
        }
        return true;
    }

    /**
     * @Description : 修改用户信息
     * @methodName : updateUserInfo
     * @param userInfo :
     * @param roleIds :
     * @return : void
     * @exception :
     * @author : zyh
     */
    @Override
    @Transactional
    public void updateUserInfo(UserInfo userInfo, String[] roleIds) {
        //删除用户与角色的所有关系
        QueryWrapper<UserRoleRelated> userRoleRelatedWrapper = new QueryWrapper<>();
        userRoleRelatedWrapper.eq("user_id",userInfo.getId());
        userRoleRelatedMapper.delete(userRoleRelatedWrapper);

        //修改用户信息
        userInfoMapper.updateById(userInfo);
        //插入用户与角色的关系
        for (int i = 1; i < roleIds.length; i++) {
            UserRoleRelated userRoleRelated = new UserRoleRelated();
            userRoleRelated.setUserId(userInfo.getId()).setRoleId(Long.parseLong(roleIds[i]));
            userRoleRelatedMapper.insert(userRoleRelated);
        }
    }

    /**
     * @Description : 删除用户信息
     * @methodName : deleteUserInfo
     * @param id :
     * @return : void
     * @exception :
     * @author : zyh
     */
    @Override
    public void deleteUserInfo(Long id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id).setIsEnable(0);
        userInfoMapper.updateById(userInfo);
    }

    /**
     * @Description : 重置密码
     * @methodName : resetPassword
     * @param userInfo :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    @Override
    public void resetPassword(UserInfo userInfo) {
        userInfo.setPassword(MD5Util.getMD5("123456"));
        userInfoMapper.updateById(userInfo);
    }

    /**
     * @Description : 修改密码
     * @methodName : updateUserPassword
     * @param password :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    @Override
    public boolean updateUserPassword(String oldPassword, String password) {
        UserInfo userInfo = LoginUserInfoManager.getUserInfo();
        if (!userInfo.getPassword().equals(MD5Util.getMD5(oldPassword))){
            return false;
        }
        UserInfo info = new UserInfo();
        info.setId(userInfo.getId()).setPassword(MD5Util.getMD5(password));
        userInfoMapper.updateById(info);
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            subject.logout();
        }
        return true;
    }

    /**
     * @Description : 根据id获取用户信息
     * @methodName : getUserInfoById
     * @param id :
     * @return : java.util.List<java.lang.Object>
     * @exception :
     * @author : 张永辉
     */
    @Override
    public List<Object> getUserInfoById(Long id) {
        List<Object> list = new ArrayList<>();
        UserInfo userInfo = userInfoMapper.selectById(id);
        QueryWrapper<UserRoleRelated> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",id);
        List<UserRoleRelated> roleInfos = userRoleRelatedMapper.selectList(queryWrapper);
        list.add(userInfo);
        list.add(roleInfos);
        return list;
    }
}
