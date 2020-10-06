package com.lfxwkj.sun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lfxwkj.sun.entity.Device;
import com.lfxwkj.sun.entity.UserInfo;
import com.lfxwkj.sun.entity.UserRoleRelated;
import com.lfxwkj.sun.mapper.DeviceMapper;
import com.lfxwkj.sun.mapper.UserInfoMapper;
import com.lfxwkj.sun.service.IDeviceService;
import com.lfxwkj.sun.util.MD5Util;
import com.lfxwkj.sun.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 设备表 服务实现类
 * </p>
 *
 * @author 张永辉
 * @since 2020-09-16
 */
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements IDeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * @Description : 获取设备列表信息
     * @methodName : getDeviceList
     * @param device
     * @param pageUtil :
     * @return : IPage<Device>
     * @exception :
     * @author : 李阳
     */
    @Override
    public IPage<Device> getDeviceList(Device device, PageUtil pageUtil) {

        IPage<Device> iPage = new Page<>(pageUtil.getPage(),pageUtil.getLimit());
        QueryWrapper<Device> queryWrapper = new QueryWrapper<>();
        if (device.getDevName() != null && !"".equals(device.getDevName())){
            queryWrapper.like("dev_name",device.getDevName());
        }
        queryWrapper.eq("state",1);
        iPage = deviceMapper.selectPage(iPage,queryWrapper);
        return iPage;
    }

    /**
     * @Description : 删除设备信息
     * @methodName : deleteDevice
     * @param id :
     * @return : void
     * @exception :删除设备信息
     * @author : 李阳
     */
    @Override
    public void deleteDevice(Long id) {
        Device device = new Device();
        device.setId(id).setState(0);
        deviceMapper.updateById(device);
    }

    /**
     * @Description : 添加设备信息
     * @methodName : addDevice
     * @param device
     * @param addUser :
     * @return : boolean
     * @exception :添加设备信息
     * @author : 李阳
     */
    @Override
    @Transactional
    public boolean addDevice(Device device,String addUser) {

        QueryWrapper<Device> queryWrapperDevice = new QueryWrapper<>();
        queryWrapperDevice.eq("dev_code",device.getDevCode());
        queryWrapperDevice.eq("state",1);
        Device device1 = deviceMapper.selectOne(queryWrapperDevice);
        if (device1 != null){
            return false;
        }
        QueryWrapper<UserInfo> queryWrapperUser = new QueryWrapper<>();
        queryWrapperUser.eq("user_name",addUser);
        UserInfo userInfo = userInfoMapper.selectOne(queryWrapperUser);

        device.setAddUser(userInfo.getId());
        device.setState(1);
        deviceMapper.insert(device);
        return true;
    }

    /**
     * @Description : 修改用户信息
     * @methodName : updateUserInfo
     * @param device :
     * @return : void
     * @exception :修改用户信息
     * @author : 李阳
     */
    @Override
    @Transactional
    public void updateUserInfo(Device device) {

        //修改用户信息
        deviceMapper.updateById(device);
    }

    /**
     * @Description : 根据Id查询设备信息
     * @methodName : getDeviceById
     * @param id :
     * @return : com.lfxwkj.sun.entity.Device
     * @exception :根据Id查询设备信息
     * @author : 李阳
     */
    @Override
    public Device getDeviceById(Long id) {
        return deviceMapper.selectById(id);
    }
}
