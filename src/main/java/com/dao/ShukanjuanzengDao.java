package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.ShukanjuanzengEntity;
import com.entity.view.ShukanjuanzengView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 书刊捐赠 Dao 接口
 *
 * @author 
 */
public interface ShukanjuanzengDao extends BaseMapper<ShukanjuanzengEntity> {

   List<ShukanjuanzengView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
