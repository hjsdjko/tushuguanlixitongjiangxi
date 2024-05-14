package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.ShukanjuanzengEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * 书刊捐赠
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shukanjuanzeng")
public class ShukanjuanzengView extends ShukanjuanzengEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 图书类型的值
		*/
		private String tushuValue;



	public ShukanjuanzengView() {

	}

	public ShukanjuanzengView(ShukanjuanzengEntity shukanjuanzengEntity) {
		try {
			BeanUtils.copyProperties(this, shukanjuanzengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 图书类型的值
			*/
			public String getTushuValue() {
				return tushuValue;
			}
			/**
			* 设置： 图书类型的值
			*/
			public void setTushuValue(String tushuValue) {
				this.tushuValue = tushuValue;
			}












}
