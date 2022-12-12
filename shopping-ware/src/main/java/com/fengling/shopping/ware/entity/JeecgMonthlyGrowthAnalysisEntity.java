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
 * @date 2022-12-12 22:19:34
 */
@Data
@TableName("jeecg_monthly_growth_analysis")
public class JeecgMonthlyGrowthAnalysisEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String year;
	/**
	 * 月份
	 */
	private String month;
	/**
	 * 佣金/主营收入
	 */
	private BigDecimal mainIncome;
	/**
	 * 其他收入
	 */
	private BigDecimal otherIncome;

}
