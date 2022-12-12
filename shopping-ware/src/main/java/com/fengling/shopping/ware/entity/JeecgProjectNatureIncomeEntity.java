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
@TableName("jeecg_project_nature_income")
public class JeecgProjectNatureIncomeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 项目性质
	 */
	private String nature;
	/**
	 * 保险经纪佣金费
	 */
	private BigDecimal insuranceFee;
	/**
	 * 风险咨询费
	 */
	private BigDecimal riskConsultingFee;
	/**
	 * 承保公估评估费
	 */
	private BigDecimal evaluationFee;
	/**
	 * 保险公估费
	 */
	private BigDecimal insuranceEvaluationFee;
	/**
	 * 投标咨询费
	 */
	private BigDecimal biddingConsultingFee;
	/**
	 * 内控咨询费
	 */
	private BigDecimal interolConsultingFee;

}
