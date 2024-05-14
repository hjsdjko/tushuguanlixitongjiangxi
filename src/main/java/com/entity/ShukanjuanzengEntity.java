package com.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * 书刊捐赠
 *
 * @author 
 * @email
 */
@TableName("shukanjuanzeng")
public class ShukanjuanzengEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShukanjuanzengEntity() {

	}

	public ShukanjuanzengEntity(T t) {
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
     * 捐赠人姓名
     */
    @TableField(value = "shukanjuanzeng_ren_name")

    private String shukanjuanzengRenName;


    /**
     * 捐赠人联系方式
     */
    @TableField(value = "shukanjuanzeng_ren_phone")

    private String shukanjuanzengRenPhone;


    /**
     * 捐赠人住址
     */
    @TableField(value = "shukanjuanzeng_ren_address")

    private String shukanjuanzengRenAddress;


    /**
     * 图书编号
     */
    @TableField(value = "shukanjuanzeng_uuid_number")

    private String shukanjuanzengUuidNumber;


    /**
     * 图书名称
     */
    @TableField(value = "shukanjuanzeng_name")

    private String shukanjuanzengName;


    /**
     * 作者
     */
    @TableField(value = "shukanjuanzeng_zuozhe")

    private String shukanjuanzengZuozhe;


    /**
     * 图书封面
     */
    @TableField(value = "shukanjuanzeng_fengmian_photo")

    private String shukanjuanzengFengmianPhoto;


    /**
     * 图书类型
     */
    @TableField(value = "tushu_types")

    private Integer tushuTypes;


    /**
     * 出版社
     */
    @TableField(value = "chubanshe")

    private String chubanshe;


    /**
     * 出版日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "chuban_time")

    private Date chubanTime;


    /**
     * 捐赠数量
     */
    @TableField(value = "juanzengshuliang")

    private Integer juanzengshuliang;


    /**
     * 图书详情
     */
    @TableField(value = "shukanjuanzeng_content")

    private String shukanjuanzengContent;


    /**
     * 捐赠时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "juanzeng_time")

    private Date juanzengTime;


    /**
     * 录入时间
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
	 * 设置：捐赠人姓名
	 */
    public String getShukanjuanzengRenName() {
        return shukanjuanzengRenName;
    }
    /**
	 * 获取：捐赠人姓名
	 */

    public void setShukanjuanzengRenName(String shukanjuanzengRenName) {
        this.shukanjuanzengRenName = shukanjuanzengRenName;
    }
    /**
	 * 设置：捐赠人联系方式
	 */
    public String getShukanjuanzengRenPhone() {
        return shukanjuanzengRenPhone;
    }
    /**
	 * 获取：捐赠人联系方式
	 */

    public void setShukanjuanzengRenPhone(String shukanjuanzengRenPhone) {
        this.shukanjuanzengRenPhone = shukanjuanzengRenPhone;
    }
    /**
	 * 设置：捐赠人住址
	 */
    public String getShukanjuanzengRenAddress() {
        return shukanjuanzengRenAddress;
    }
    /**
	 * 获取：捐赠人住址
	 */

    public void setShukanjuanzengRenAddress(String shukanjuanzengRenAddress) {
        this.shukanjuanzengRenAddress = shukanjuanzengRenAddress;
    }
    /**
	 * 设置：图书编号
	 */
    public String getShukanjuanzengUuidNumber() {
        return shukanjuanzengUuidNumber;
    }
    /**
	 * 获取：图书编号
	 */

    public void setShukanjuanzengUuidNumber(String shukanjuanzengUuidNumber) {
        this.shukanjuanzengUuidNumber = shukanjuanzengUuidNumber;
    }
    /**
	 * 设置：图书名称
	 */
    public String getShukanjuanzengName() {
        return shukanjuanzengName;
    }
    /**
	 * 获取：图书名称
	 */

    public void setShukanjuanzengName(String shukanjuanzengName) {
        this.shukanjuanzengName = shukanjuanzengName;
    }
    /**
	 * 设置：作者
	 */
    public String getShukanjuanzengZuozhe() {
        return shukanjuanzengZuozhe;
    }
    /**
	 * 获取：作者
	 */

    public void setShukanjuanzengZuozhe(String shukanjuanzengZuozhe) {
        this.shukanjuanzengZuozhe = shukanjuanzengZuozhe;
    }
    /**
	 * 设置：图书封面
	 */
    public String getShukanjuanzengFengmianPhoto() {
        return shukanjuanzengFengmianPhoto;
    }
    /**
	 * 获取：图书封面
	 */

    public void setShukanjuanzengFengmianPhoto(String shukanjuanzengFengmianPhoto) {
        this.shukanjuanzengFengmianPhoto = shukanjuanzengFengmianPhoto;
    }
    /**
	 * 设置：图书类型
	 */
    public Integer getTushuTypes() {
        return tushuTypes;
    }
    /**
	 * 获取：图书类型
	 */

    public void setTushuTypes(Integer tushuTypes) {
        this.tushuTypes = tushuTypes;
    }
    /**
	 * 设置：出版社
	 */
    public String getChubanshe() {
        return chubanshe;
    }
    /**
	 * 获取：出版社
	 */

    public void setChubanshe(String chubanshe) {
        this.chubanshe = chubanshe;
    }
    /**
	 * 设置：出版日期
	 */
    public Date getChubanTime() {
        return chubanTime;
    }
    /**
	 * 获取：出版日期
	 */

    public void setChubanTime(Date chubanTime) {
        this.chubanTime = chubanTime;
    }
    /**
	 * 设置：捐赠数量
	 */
    public Integer getJuanzengshuliang() {
        return juanzengshuliang;
    }
    /**
	 * 获取：捐赠数量
	 */

    public void setJuanzengshuliang(Integer juanzengshuliang) {
        this.juanzengshuliang = juanzengshuliang;
    }
    /**
	 * 设置：图书详情
	 */
    public String getShukanjuanzengContent() {
        return shukanjuanzengContent;
    }
    /**
	 * 获取：图书详情
	 */

    public void setShukanjuanzengContent(String shukanjuanzengContent) {
        this.shukanjuanzengContent = shukanjuanzengContent;
    }
    /**
	 * 设置：捐赠时间
	 */
    public Date getJuanzengTime() {
        return juanzengTime;
    }
    /**
	 * 获取：捐赠时间
	 */

    public void setJuanzengTime(Date juanzengTime) {
        this.juanzengTime = juanzengTime;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：录入时间
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
        return "Shukanjuanzeng{" +
            "id=" + id +
            ", shukanjuanzengRenName=" + shukanjuanzengRenName +
            ", shukanjuanzengRenPhone=" + shukanjuanzengRenPhone +
            ", shukanjuanzengRenAddress=" + shukanjuanzengRenAddress +
            ", shukanjuanzengUuidNumber=" + shukanjuanzengUuidNumber +
            ", shukanjuanzengName=" + shukanjuanzengName +
            ", shukanjuanzengZuozhe=" + shukanjuanzengZuozhe +
            ", shukanjuanzengFengmianPhoto=" + shukanjuanzengFengmianPhoto +
            ", tushuTypes=" + tushuTypes +
            ", chubanshe=" + chubanshe +
            ", chubanTime=" + chubanTime +
            ", juanzengshuliang=" + juanzengshuliang +
            ", shukanjuanzengContent=" + shukanjuanzengContent +
            ", juanzengTime=" + juanzengTime +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
