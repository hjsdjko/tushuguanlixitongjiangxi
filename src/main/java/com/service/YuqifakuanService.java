package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YuqifakuanEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 逾期罚款 服务类
 */
public interface YuqifakuanService extends IService<YuqifakuanEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}