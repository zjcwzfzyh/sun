package com.lfxwkj.sun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lfxwkj.sun.entity.RoleInfo;
import com.lfxwkj.sun.entity.RolePermRelated;
import com.lfxwkj.sun.mapper.RoleInfoMapper;
import com.lfxwkj.sun.mapper.RolePermRelatedMapper;
import com.lfxwkj.sun.service.IRoleInfoService;
import com.lfxwkj.sun.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author 张永辉
 * @since 2020-05-06
 */
@Service
public class RoleInfoServiceImpl extends ServiceImpl<RoleInfoMapper, RoleInfo> implements IRoleInfoService {

    @Autowired
    private RoleInfoMapper roleInfoMapper;
    @Autowired
    private RolePermRelatedMapper rolePermRelatedMapper;

    /**
     * @Description : 获取角色列表
     * @methodName : getRoleInfoList
     * @param roleInfo :
     * @param pageUtil :
     * @return : com.baomidou.mybatisplus.core.metadata.IPage<com.lfxwkj.tea.entity.RoleInfo>
     * @exception :
     * @author : 张永辉
     */
    @Override
    public IPage<RoleInfo> getRoleInfoList(RoleInfo roleInfo, PageUtil pageUtil) {
        IPage<RoleInfo> iPage = new Page<>(pageUtil.getPage(),pageUtil.getLimit());
        QueryWrapper<RoleInfo> queryWrapper = new QueryWrapper<>();
        if (roleInfo.getRoleName() != null && !"".equals(roleInfo.getRoleName())){
            queryWrapper.like("role_name",roleInfo.getRoleName());
        }
        Optional.ofNullable(roleInfo.getStartTime()).ifPresent(n ->
                queryWrapper.gt("create_time",roleInfo.getStartTime()));
        Optional.ofNullable(roleInfo.getEndTime()).ifPresent(n ->
                queryWrapper.lt("create_time",roleInfo.getEndTime()));
        queryWrapper.eq("is_enable",1);
        iPage = roleInfoMapper.selectPage(iPage,queryWrapper);
        return iPage;
    }

    /**
     * @Description : 添加角色
     * @methodName : addRoleInfo
     * @param roleInfo :
     * @param permIds :
     * @return : boolean
     * @exception :
     * @author : 张永辉
     */
    @Override
    @Transactional
    public boolean addRoleInfo(RoleInfo roleInfo, String permIds) {
        QueryWrapper<RoleInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_name",roleInfo.getRoleName());
        queryWrapper.eq("is_enable",1);
        RoleInfo info = roleInfoMapper.selectOne(queryWrapper);
        if (info != null){
            return false;
        }
        roleInfoMapper.insert(roleInfo);
        String[] split = permIds.split(",");
        for (int i = 0; i < split.length; i++) {
            RolePermRelated rolePermRelated = new RolePermRelated();
            rolePermRelated.setRoleId(roleInfo.getId()).setPermId(Long.parseLong(split[i]));
            rolePermRelatedMapper.insert(rolePermRelated);
        }
        return true;
    }

    /**
     * @Description : 修改角色
     * @methodName : updateRoleInfo
     * @param roleInfo :
     * @param permIds :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    @Override
    @Transactional
    public void updateRoleInfo(RoleInfo roleInfo, String permIds) {
        //删除角色与权限关系
        QueryWrapper<RolePermRelated> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id",roleInfo.getId());
        rolePermRelatedMapper.delete(queryWrapper);
        //修改角色信息
        roleInfoMapper.updateById(roleInfo);
        String[] split = permIds.split(",");
        for (int i = 0; i < split.length; i++) {
            RolePermRelated rolePermRelated = new RolePermRelated();
            rolePermRelated.setRoleId(roleInfo.getId()).setPermId(Long.parseLong(split[i]));
            rolePermRelatedMapper.insert(rolePermRelated);
        }
    }

    /**
     * @Description : 删除角色
     * @methodName : deleteRoleInfo
     * @param id :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    @Override
    public void deleteRoleInfo(Long id) {
        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setId(id).setIsEnable(0);
        roleInfoMapper.updateById(roleInfo);
    }
}
