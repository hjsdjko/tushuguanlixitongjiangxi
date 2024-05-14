package com.dao;

import com.entity.YuqifakuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YuqifakuanView;

/**
 * 逾期罚款 Dao 接口
 *
 * @author 
 */
public interface YuqifakuanDao extends BaseMapper<YuqifakuanEntity> {

   List<YuqifakuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
