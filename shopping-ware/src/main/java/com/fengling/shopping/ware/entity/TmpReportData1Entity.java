package com.fengling.shopping.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
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
@TableName("tmp_report_data_1")
public class TmpReportData1Entity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 月份
	 */
	@TableId
	private String monty;
	/**
	 * 
	 */
	private BigDecimal mainIncome;
	/**
	 * 
	 */
	private BigDecimal total;
	/**
	 * 
	 */
	private BigDecimal hisLowest;
	/**
	 * 
	 */
	private BigDecimal hisAverage;
	/**
	 * 
	 */
	private BigDecimal hisHighest;

}
