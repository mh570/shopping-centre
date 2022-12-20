package com.fengling.shopping.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * Ʒ
 * 
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:24:58
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Ʒ
	 */
	@TableId
	private Long brandId;
	/**
	 * Ʒ
	 */
	@NotBlank
	private String name;
	/**
	 * Ʒ
	 */
	@NotEmpty
	@URL
	private String logo;
	/**
	 * 
	 */
	private String descript;
	/**
	 * 
	 */
	private Integer showStatus;
	/**
	 * 
	 */
	@NotEmpty
	@Pattern(regexp = "/^[a-zA-Z]$/")
	private String firstLetter;
	/**
	 * 
	 */
	@NotNull
	@Min(value = 0)
	private Integer sort;

}
