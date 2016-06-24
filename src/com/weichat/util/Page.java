package com.weichat.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页工具类
 * 
 * 
 * 项目名称：WeiChat 类名称：Page.java 类描述：TODO 创建人：王晶 创建时间：2016年6月24日 下午3:55:51 修改人：王晶
 * 修改时间：2016年6月24日 下午3:55:51 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public class Page<T> implements Serializable {
	private static final long serialVersionUID = -4964432304535229190L;

	/**
	 * 默认的总页数
	 */
	private static Integer DEFAULT_TOTAL_PAGE_SIZE = 0;

	/**
	 * 默认的末页页数
	 */
	private static Integer DEFAULT_LAST_PAGE_INDEX = 0;

	/**
	 * 默认每页显示的条数
	 */
	private static Integer DEFAULT_PAGE_SIZE = 10;

	/**
	 * 默认的数据总条数
	 */
	private static Integer DEFAULT_TOTAL_COUNT = 0;

	/**
	 * 当前页面的索引
	 */
	private Integer pageIndex;

	/**
	 * 总页数
	 */
	private Integer totalPageSize = DEFAULT_TOTAL_PAGE_SIZE;

	/**
	 * 上一页的页码
	 */
	private Integer prevPageIndex;

	/**
	 * 下一页的页码
	 */
	private Integer nextPageIndex;

	/**
	 * 末页的页码
	 */
	private Integer lastPageIndex = DEFAULT_LAST_PAGE_INDEX;

	/**
	 * 每页要显示的信息条数
	 */
	private Integer pageSize = DEFAULT_PAGE_SIZE;

	/**
	 * 搜索属性
	 */
	private String searchProperty;

	/**
	 * 搜索值
	 */
	private String searchValue;

	/**
	 * 数据总数
	 */
	private Integer totalCount = DEFAULT_TOTAL_COUNT;

	/**
	 * 数据集合
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
	 * 设置总页数
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
	 * 设置上一页的页码
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
	 * 设置下一页的页码
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
	 * 设置末页的页码
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
	 * 构造方法，用于填入分页基础数据
	 * 
	 * @param contentList
	 *            分页时携带的数据集合
	 * @param totalCount
	 *            数据总数
	 * @param pageIndex
	 *            当前页数
	 */
	public Page(List<T> contentList, Integer totalCount, Integer pageIndex) {
		content = new ArrayList<T>();
		this.content.addAll(contentList);
		this.totalCount = totalCount;
		this.pageIndex = pageIndex;
	}
}
