package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 逾期罚款
 *
 * @author 
 * @email
 */
@TableName("yuqifakuan")
public class YuqifakuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YuqifakuanEntity() {

	}

	public YuqifakuanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 罚款金额
     */
    @TableField(value = "yuqifakuan_number")

    private Double yuqifakuanNumber;


    /**
     * 罚款原因
     */
    @TableField(value = "qinyoumokuai_text")

    private String qinyoumokuaiText;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：罚款金额
	 */
    public Double getYuqifakuanNumber() {
        return yuqifakuanNumber;
    }
    /**
	 * 获取：罚款金额
	 */

    public void setYuqifakuanNumber(Double yuqifakuanNumber) {
        this.yuqifakuanNumber = yuqifakuanNumber;
    }
    /**
	 * 设置：罚款原因
	 */
    public String getQinyoumokuaiText() {
        return qinyoumokuaiText;
    }
    /**
	 * 获取：罚款原因
	 */

    public void setQinyoumokuaiText(String qinyoumokuaiText) {
        this.qinyoumokuaiText = qinyoumokuaiText;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Yuqifakuan{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", yuqifakuanNumber=" + yuqifakuanNumber +
            ", qinyoumokuaiText=" + qinyoumokuaiText +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
