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
@TableName("tmp_report_data_income")
public class TmpReportDataIncomeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String bizIncome;
	/**
	 * 
	 */
	private BigDecimal bxJjYongjin;
	/**
	 * 
	 */
	private BigDecimal bxZxMoney;
	/**
	 * 
	 */
	private BigDecimal chengbaoGzMoney;
	/**
	 * 
	 */
	private BigDecimal bxGgMoeny;
	/**
	 * 
	 */
	private BigDecimal tbZxMoney;
	/**
	 * 
	 */
	private BigDecimal neikongZxMoney;
	/**
	 * 
	 */
	private BigDecimal total;

}
