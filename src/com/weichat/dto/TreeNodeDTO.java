package com.weichat.dto;

import java.io.Serializable;

/**
 * 适用于Easy UI Tree的DTO类
 * 
 * 
 * 项目名称：WeiChat 类名称：TreeNodeDTO.java 类描述：TODO 创建人：王晶 创建时间：2016年6月26日 下午3:29:40
 * 修改人：王晶 修改时间：2016年6月26日 下午3:29:40 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public class TreeNodeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 编号
	 */
	private Double id;

	/**
	 * 文本
	 */
	private String text;

	/**
	 * 图标样式
	 */
	private String iconCls;

	/**
	 * 节点选中状态
	 */
	private Boolean checked;

	public Double getId() {
		return id;
	}

	public void setId(Double id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public TreeNodeDTO(Double id, String text, String iconCls, Boolean checked) {
		super();
		this.id = id;
		this.text = text;
		this.iconCls = iconCls;
		this.checked = checked;
	}

	public TreeNodeDTO() {
	}
}
