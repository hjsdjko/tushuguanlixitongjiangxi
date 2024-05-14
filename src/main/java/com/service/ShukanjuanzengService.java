package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.entity.ShukanjuanzengEntity;
import com.utils.PageUtils;

import java.util.Map;

/**
 * 书刊捐赠 服务类
 */
public interface ShukanjuanzengService extends IService<ShukanjuanzengEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}