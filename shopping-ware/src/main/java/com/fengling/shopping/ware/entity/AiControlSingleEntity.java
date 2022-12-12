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
@TableName("ai_control_single")
public class AiControlSingleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新人
	 */
	private String updateBy;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 所属部门
	 */
	private String sysOrgCode;
	/**
	 * 单价
	 */
	private BigDecimal price;
	/**
	 * 用户名
	 */
	private String name;
	/**
	 * 密码
	 */
	private String miMa;
	/**
	 * 字典下拉
	 */
	private String xiala;
	/**
	 * 字典单选
	 */
	private String danxuan;
	/**
	 * 字典多选
	 */
	private String duoxuan;
	/**
	 * 开关
	 */
	private String kaiguan;
	/**
	 * 日期
	 */
	private Date riqi;
	/**
	 * 年月日时分秒
	 */
	private Date nyrsfm;
	/**
	 * 时间
	 */
	private String shijian;
	/**
	 * 文件
	 */
	private String wenjian;
	/**
	 * 图片
	 */
	private String tupian;
	/**
	 * 多行文本框
	 */
	private String dhwb;
	/**
	 * 字典下拉多选框
	 */
	private String xldx;
	/**
	 * 字典表下拉搜索框
	 */
	private String xlss;
	/**
	 * popup弹窗
	 */
	private String popup;
	/**
	 * popback
	 */
	private String popback;
	/**
	 * 分类字典树
	 */
	private String flzds;
	/**
	 * 部门选择
	 */
	private String bmxz;
	/**
	 * 用户选择
	 */
	private String yhxz;
	/**
	 * 富文本
	 */
	private String fwb;
	/**
	 * markdown
	 */
//	private unknowType markdown;
	/**
	 * 省市区
	 */
	private String shq;
	/**
	 * 联动组件一
	 */
	private String ldzuy;
	/**
	 * 联动组件二
	 */
	private String ldzje;
	/**
	 * 联动组件三
	 */
	private String ldzjs;
	/**
	 * 自定义树
	 */
	private String zdys;
	/**
	 * double类型
	 */
	private Double yuanjia;
	/**
	 * integer类型
	 */
	private Integer geshu;
	/**
	 * 唯一检验
	 */
	private String jycs;
	/**
	 * 输入2到10位的字母
	 */
	private String province;
	/**
	 * 自定义查询
	 */
	private String zdmrz;
	/**
	 * 字典表下拉
	 */
	private String zdbxl;
	/**
	 * 字典表单选
	 */
	private String zdbdx;
	/**
	 * 字典表多选
	 */
	private String zdbduoxuan;
	/**
	 * 字典表下拉多选
	 */
	private String zdbxldx;
	/**
	 * 字典表带条件下拉
	 */
	private String zddtjxl;
	/**
	 * 字典表带条件单选
	 */
	private String zddtjdx;
	/**
	 * 字典表带条件多选
	 */
	private String zddtjduox;
	/**
	 * 字典表带条件下拉多选
	 */
	private String zddtjxldx;
	/**
	 * 字典表带条件下拉搜索
	 */
	private String zddtjxlss;

}
