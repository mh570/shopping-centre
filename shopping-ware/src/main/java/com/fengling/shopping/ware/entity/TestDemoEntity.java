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
@TableName("test_demo")
public class TestDemoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private String id;
	/**
	 * 创建人登录名称
	 */
	private String createBy;
	/**
	 * 创建日期
	 */
	private Date createTime;
	/**
	 * 更新人登录名称
	 */
	private String updateBy;
	/**
	 * 更新日期
	 */
	private Date updateTime;
	/**
	 * 用户名
	 */
	private String name;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 描述
	 */
	private String descc;
	/**
	 * 生日
	 */
	private Date birthday;
	/**
	 * 用户编码
	 */
	private String userCode;
	/**
	 * 附件
	 */
	private String fileKk;
	/**
	 * 头像
	 */
	private String topPic;
	/**
	 * 城市
	 */
	private String chegnshi;
	/**
	 * checkbox
	 */
	private String ceck;
	/**
	 * 下拉多选
	 */
	private String xiamuti;
	/**
	 * 搜索下拉
	 */
	private String searchSel;
	/**
	 * 弹窗
	 */
	private String pop;
	/**
	 * 下拉字典表
	 */
	private String selTable;

}
