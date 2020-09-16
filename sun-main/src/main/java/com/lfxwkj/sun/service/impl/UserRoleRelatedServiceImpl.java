package com.lfxwkj.sun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lfxwkj.sun.entity.UserRoleRelated;
import com.lfxwkj.sun.mapper.UserRoleRelatedMapper;
import com.lfxwkj.sun.service.IUserRoleRelatedService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和角色中间表 服务实现类
 * </p>
 *
 * @author 张永辉
 * @since 2020-05-06
 */
@Service
public class UserRoleRelatedServiceImpl extends ServiceImpl<UserRoleRelatedMapper, UserRoleRelated> implements IUserRoleRelatedService {

}
