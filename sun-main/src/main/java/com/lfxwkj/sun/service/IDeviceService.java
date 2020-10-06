package com.lfxwkj.sun.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lfxwkj.sun.entity.Device;
import com.lfxwkj.sun.util.PageUtil;

import java.util.List;

/**
 * <p>
 * 设备表 服务类
 * </p>
 *
 * @author 张永辉
 * @since 2020-09-16
 */
public interface IDeviceService extends IService<Device> {

    /**
     * @Description : 获取设备列表信息
     * @methodName : getDeviceList
     * @param device
     * @param pageUtil :
     * @return : IPage<Device>
     * @exception :
     * @author : 李阳
     */
    IPage<Device> getDeviceList(Device device, PageUtil pageUtil);

    /**
     * @Description : 删除设备信息
     * @methodName : deleteDevice
     * @param id :
     * @return : void
     * @exception :删除设备信息
     * @author : 李阳
     */
    void deleteDevice(Long id);

    /**
     * @Description : 添加设备信息
     * @methodName : addDevice
     * @param device
     * @param addUser :
     * @return : boolean
     * @exception :添加设备信息
     * @author : 李阳
     */
    boolean addDevice(Device device,String addUser);

    /**
     * @Description : 修改用户信息
     * @methodName : updateUserInfo
     * @param device :
     * @return : void
     * @exception :修改用户信息
     * @author : 李阳
     */
    void updateUserInfo(Device device);

    /**
     * @Description : 根据Id查询设备信息
     * @methodName : getDeviceById
     * @param id :
     * @return : com.lfxwkj.sun.entity.Device
     * @exception :根据Id查询设备信息
     * @author : 李阳
     */
    Device getDeviceById(Long id);
}
