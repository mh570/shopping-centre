package com.fengling.shopping.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
@Data
@TableName("rep_demo_jianpiao")
public class RepDemoJianpiaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String bnum;
	/**
	 * 
	 */
	private String ftime;
	/**
	 * 
	 */
	private String sfkong;
	/**
	 * 
	 */
	private String kaishi;
	/**
	 * 
	 */
	private String jieshu;
	/**
	 * 
	 */
	private String hezairen;
	/**
	 * 
	 */
	private String jpnum;
	/**
	 * 
	 */
	private String shihelv;
	/**
	 * 
	 */
	private Integer sId;

}
