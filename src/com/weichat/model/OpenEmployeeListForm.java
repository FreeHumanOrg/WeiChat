package com.weichat.model;

public class OpenEmployeeListForm {
	private Integer startRow;//��ҳ��ʼ
	private Integer endRow;//��ҳ����
	private Integer pageSize;//ҳ��
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public Integer getEndRow() {
		return endRow;
	}
	public void setEndRow(Integer endRow) {
		this.endRow = endRow;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
