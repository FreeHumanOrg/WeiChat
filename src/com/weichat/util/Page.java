package com.weichat.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ��ҳ������
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�Page.java ��������TODO �����ˣ����� ����ʱ�䣺2016��6��24�� ����3:55:51 �޸��ˣ�����
 * �޸�ʱ�䣺2016��6��24�� ����3:55:51 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public class Page<T> implements Serializable {
	private static final long serialVersionUID = -4964432304535229190L;

	/**
	 * Ĭ�ϵ���ҳ��
	 */
	private static Integer DEFAULT_TOTAL_PAGE_SIZE = 0;

	/**
	 * Ĭ�ϵ�ĩҳҳ��
	 */
	private static Integer DEFAULT_LAST_PAGE_INDEX = 0;

	/**
	 * Ĭ��ÿҳ��ʾ������
	 */
	private static Integer DEFAULT_PAGE_SIZE = 10;

	/**
	 * Ĭ�ϵ�����������
	 */
	private static Integer DEFAULT_TOTAL_COUNT = 0;

	/**
	 * ��ǰҳ�������
	 */
	private Integer pageIndex;

	/**
	 * ��ҳ��
	 */
	private Integer totalPageSize = DEFAULT_TOTAL_PAGE_SIZE;

	/**
	 * ��һҳ��ҳ��
	 */
	private Integer prevPageIndex;

	/**
	 * ��һҳ��ҳ��
	 */
	private Integer nextPageIndex;

	/**
	 * ĩҳ��ҳ��
	 */
	private Integer lastPageIndex = DEFAULT_LAST_PAGE_INDEX;

	/**
	 * ÿҳҪ��ʾ����Ϣ����
	 */
	private Integer pageSize = DEFAULT_PAGE_SIZE;

	/**
	 * ��������
	 */
	private String searchProperty;

	/**
	 * ����ֵ
	 */
	private String searchValue;

	/**
	 * ��������
	 */
	private Integer totalCount = DEFAULT_TOTAL_COUNT;

	/**
	 * ���ݼ���
	 */
	private List<T> content;

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	public Integer getPageIndex() {
		if (null == pageIndex) {
			pageIndex = 1;
		}
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	/**
	 * ������ҳ��
	 * 
	 * @return
	 */
	public Integer getTotalPageSize() {
		if (totalCount % pageSize == 0) {
			totalPageSize = totalCount / pageSize;
		} else {
			totalPageSize = totalCount / pageSize + 1;
		}
		return totalPageSize;
	}

	public void setTotalPageSize(Integer totalPageSize) {
		this.totalPageSize = totalPageSize;
	}

	/**
	 * ������һҳ��ҳ��
	 * 
	 * @return
	 */
	public Integer getPrevPageIndex() {
		if (pageIndex <= 1) {
			prevPageIndex = 1;
		} else if (pageIndex > 1 && pageIndex < totalPageSize) {
			prevPageIndex = pageIndex - 1;
		} else if (pageIndex >= totalPageSize) {
			prevPageIndex = pageIndex - 1;
		}
		return prevPageIndex;
	}

	public void setPrevPageIndex(Integer prevPageIndex) {
		this.prevPageIndex = prevPageIndex;
	}

	/**
	 * ������һҳ��ҳ��
	 * 
	 * @return
	 */
	public Integer getNextPageIndex() {
		if (pageIndex <= 1) {
			nextPageIndex = pageIndex + 1;
		} else if (pageIndex > 1 && pageIndex < totalPageSize) {
			nextPageIndex = pageIndex + 1;
		} else if (pageIndex >= totalPageSize) {
			nextPageIndex = pageIndex;
		}
		return nextPageIndex;
	}

	public void setNextPageIndex(Integer nextPageIndex) {
		this.nextPageIndex = nextPageIndex;
	}

	/**
	 * ����ĩҳ��ҳ��
	 * 
	 * @return
	 */
	public Integer getLastPageIndex() {
		this.lastPageIndex = getTotalPageSize();
		return lastPageIndex;
	}

	public void setLastPageIndex(Integer lastPageIndex) {
		this.lastPageIndex = lastPageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getSearchProperty() {
		return searchProperty;
	}

	public void setSearchProperty(String searchProperty) {
		this.searchProperty = searchProperty;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Page() {
	}

	/**
	 * ���췽�������������ҳ��������
	 * 
	 * @param contentList
	 *            ��ҳʱЯ�������ݼ���
	 * @param totalCount
	 *            ��������
	 * @param pageIndex
	 *            ��ǰҳ��
	 */
	public Page(List<T> contentList, Integer totalCount, Integer pageIndex) {
		content = new ArrayList<T>();
		this.content.addAll(contentList);
		this.totalCount = totalCount;
		this.pageIndex = pageIndex;
	}
}
