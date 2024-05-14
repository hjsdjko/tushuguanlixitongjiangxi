package com.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.ShukanjuanzengDao;
import com.entity.ShukanjuanzengEntity;
import com.entity.view.ShukanjuanzengView;
import com.service.ShukanjuanzengService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 书刊捐赠 服务实现类
 */
@Service("shukanjuanzengService")
@Transactional
public class ShukanjuanzengServiceImpl extends ServiceImpl<ShukanjuanzengDao, ShukanjuanzengEntity> implements ShukanjuanzengService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ShukanjuanzengView> page =new Query<ShukanjuanzengView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
