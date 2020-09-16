package com.lfxwkj.sun.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lfxwkj.sun.entity.RoleInfo;
import com.lfxwkj.sun.util.PageUtil;

/**
 * <p>
 * 角色信息表 服务类
 * </p>
 *
 * @author 张永辉
 * @since 2020-05-06
 */
public interface IRoleInfoService extends IService<RoleInfo> {

    /**
     * @Description : 获取角色列表
     * @methodName : getRoleInfoList
     * @param roleInfo :
     * @param pageUtil :
     * @return : com.baomidou.mybatisplus.core.metadata.IPage<com.lfxwkj.tea.entity.RoleInfo>
     * @exception :
     * @author : 张永辉
     */
    IPage<RoleInfo> getRoleInfoList(RoleInfo roleInfo, PageUtil pageUtil);

    /**
     * @Description : 添加角色
     * @methodName : addRoleInfo
     * @param roleInfo :
     * @param permIds :
     * @return : boolean
     * @exception :
     * @author : 张永辉
     */
    boolean addRoleInfo(RoleInfo roleInfo, String permIds);

    /**
     * @Description : 修改角色
     * @methodName : updateRoleInfo
     * @param roleInfo :
     * @param permIds :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    void updateRoleInfo(RoleInfo roleInfo, String permIds);

    /**
     * @Description : 删除角色
     * @methodName : deleteRoleInfo
     * @param id :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    void deleteRoleInfo(Long id);

}
