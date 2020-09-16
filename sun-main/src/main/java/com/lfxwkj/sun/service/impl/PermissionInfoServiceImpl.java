package com.lfxwkj.sun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lfxwkj.sun.entity.PermissionInfo;
import com.lfxwkj.sun.mapper.PermissionInfoMapper;
import com.lfxwkj.sun.service.IPermissionInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限信息表 服务实现类
 * </p>
 *
 * @author 张永辉
 * @since 2020-05-06
 */
@Service
public class PermissionInfoServiceImpl extends ServiceImpl<PermissionInfoMapper, PermissionInfo> implements IPermissionInfoService {

}
