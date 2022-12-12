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
@TableName("rep_demo_employee")
public class RepDemoEmployeeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private String id;
	/**
	 * 编号
	 */
	private String num;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 出生日期
	 */
	private Date birthday;
	/**
	 * 民族
	 */
	private String nation;
	/**
	 * 政治面貌
	 */
	private String political;
	/**
	 * 籍贯
	 */
	private String nativePlace;
	/**
	 * 身高
	 */
	private String height;
	/**
	 * 体重
	 */
	private String weight;
	/**
	 * 健康状况
	 */
	private String health;
	/**
	 * 身份证号
	 */
	private String idCard;
	/**
	 * 学历
	 */
	private String education;
	/**
	 * 毕业学校
	 */
	private String school;
	/**
	 * 专业
	 */
	private String major;
	/**
	 * 联系地址
	 */
	private String address;
	/**
	 * 邮编
	 */
	private String zipCode;
	/**
	 * Email
	 */
	private String email;
	/**
	 * 手机号
	 */
	private String phone;
	/**
	 * 外语语种
	 */
	private String foreignLanguage;
	/**
	 * 外语水平
	 */
	private String foreignLanguageLevel;
	/**
	 * 计算机水平
	 */
	private String computerLevel;
	/**
	 * 毕业时间
	 */
	private Date graduationTime;
	/**
	 * 到职时间
	 */
	private Date arrivalTime;
	/**
	 * 职称
	 */
	private String positionalTitles;
	/**
	 * 教育经历
	 */
	private String educationExperience;
	/**
	 * 工作经历
	 */
	private String workExperience;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改人
	 */
	private String updateBy;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 删除标识0-正常,1-已删除
	 */
	private Integer delFlag;

}
