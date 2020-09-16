package com.lfxwkj.sun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lfxwkj.sun.entity.Item;
import com.lfxwkj.sun.mapper.ItemMapper;
import com.lfxwkj.sun.service.IItemService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 项目表 服务实现类
 * </p>
 *
 * @author 张永辉
 * @since 2020-09-16
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements IItemService {

}
