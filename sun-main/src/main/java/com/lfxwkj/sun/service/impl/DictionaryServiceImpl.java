package com.lfxwkj.sun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lfxwkj.sun.entity.Dictionary;
import com.lfxwkj.sun.mapper.DictionaryMapper;
import com.lfxwkj.sun.service.IDictionaryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统数据字典表 服务实现类
 * </p>
 *
 * @author 张永辉
 * @since 2020-05-07
 */
@Service
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, Dictionary> implements IDictionaryService {

}
