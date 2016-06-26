package com.weichat.dto;

import java.io.Serializable;

/**
 * ������Easy UI Tree��DTO��
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�TreeNodeDTO.java ��������TODO �����ˣ����� ����ʱ�䣺2016��6��26�� ����3:29:40
 * �޸��ˣ����� �޸�ʱ�䣺2016��6��26�� ����3:29:40 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public class TreeNodeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ���
	 */
	private Double id;

	/**
	 * �ı�
	 */
	private String text;

	/**
	 * ͼ����ʽ
	 */
	private String iconCls;

	/**
	 * �ڵ�ѡ��״̬
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
