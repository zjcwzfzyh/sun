package com.lfxwkj.sun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lfxwkj.sun.entity.Device;
import com.lfxwkj.sun.mapper.DeviceMapper;
import com.lfxwkj.sun.service.IDeviceService;
import org.springframework.stereotype.Service;

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

}
