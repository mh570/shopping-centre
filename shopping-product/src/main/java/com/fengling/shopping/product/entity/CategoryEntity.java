package com.fengling.shopping.product.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fengling.common.valid.AddGroup;
import com.fengling.common.valid.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 
 * 
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:24:58
 */
@Data
@TableName("pms_category")
public class CategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long catId;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private Long parentCid;
	/**
	 * 
	 */
	private Integer catLevel;
	/**
	 * 
	 */
	@TableLogic(value = "1",delval = "0")
	private Integer showStatus;
	/**
	 * 
	 */
	@NotNull(groups={AddGroup.class})
	@Min(value = 0,message = "排序必须大于等于0",groups={AddGroup.class, UpdateGroup.class})
	private Integer sort;
	/**
	 * ͼ
	 */
	private String icon;
	/**
	 * 
	 */
	private String productUnit;
	/**
	 * 
	 */
	private Integer productCount;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@TableField(exist = false)
	private List<CategoryEntity> children;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CategoryEntity that = (CategoryEntity) o;
		return Objects.equals(catId, that.catId) && Objects.equals(name, that.name) && Objects.equals(parentCid, that.parentCid) && Objects.equals(catLevel, that.catLevel) && Objects.equals(showStatus, that.showStatus) && Objects.equals(sort, that.sort) && Objects.equals(icon, that.icon) && Objects.equals(productUnit, that.productUnit) && Objects.equals(productCount, that.productCount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(catId, name, parentCid, catLevel, showStatus, sort, icon, productUnit, productCount);
	}
}
