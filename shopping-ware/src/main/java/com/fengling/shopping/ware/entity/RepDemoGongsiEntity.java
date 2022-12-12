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
 * @date 2022-12-12 22:19:33
 */
@Data
@TableName("rep_demo_gongsi")
public class RepDemoGongsiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 货品名称
	 */
	private String gname;
	/**
	 * 返利
	 */
	private String gdata;
	/**
	 * 备注
	 */
	private String tdata;
	/**
	 * 
	 */
	private String didian;
	/**
	 * 
	 */
	private String zhaiyao;
	/**
	 * 
	 */
	private String num;

}
