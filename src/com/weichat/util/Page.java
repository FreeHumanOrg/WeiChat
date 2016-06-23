package com.weichat.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Page分页实体类
 * 
 * 
 * 项目名称：WeiChat 类名称：Page.java 类描述：TODO 创建人：王晶 创建时间：2016年6月23日 上午8:50:58 修改人：王晶
 * 修改时间：2016年6月23日 上午8:50:58 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public class Page<T> implements Serializable {
	private static final long serialVersionUID = -2053800594583879853L;
	private static final int MAX_PAGE_STEP = 10;

	/** 内容. */
	private final List<T> content = new ArrayList<T>();

	/** 总记录数. */
	private final long total;

	/** 分页信息. */
	private final Pageable pageable;
	private long stepBegin;
	private long stepEnd;

	/**
	 * 初始化一个新创建的Page对象.
	 */
	public Page() {
		this.total = 0L;
		this.pageable = new Pageable();
	}

	/**
	 * @param content
	 *            内容
	 * @param total
	 *            总记录数
	 * @param pageable
	 *            分页信息
	 */
	public Page(List<T> content, long total, Pageable pageable) {
		this.content.addAll(content);
		this.total = total;
		this.pageable = pageable;
		initStepPage();
	}

	/**
	 * . .
	 */
	private void initStepPage() {
		int pageNum = pageable.getPageNumber();
		int totalPages = getTotalPages();
		if (pageNum < MAX_PAGE_STEP) {
			stepBegin = 1;
			stepEnd = MAX_PAGE_STEP <= totalPages ? MAX_PAGE_STEP : totalPages;
			return;
		}
		if ((totalPages - pageNum) < MAX_PAGE_STEP) {
			stepBegin = totalPages - MAX_PAGE_STEP;
			stepEnd = totalPages;
			return;
		}
		stepBegin = (pageNum - (int) Math.ceil((double) MAX_PAGE_STEP / 2));

		if (stepBegin < 1) {
			stepBegin = 1;
		}
		stepEnd = pageNum + (MAX_PAGE_STEP / 2);
		if (stepEnd > totalPages) {
			stepEnd = totalPages;
		}
	}

	/**
	 * @return the stepBegin
	 */
	public long getStepBegin() {
		return stepBegin;
	}

	/**
	 * @return the stepEnd
	 */
	public long getStepEnd() {
		return stepEnd;
	}

	/**
	 * 获取页码.
	 * 
	 * @return 页码
	 */
	public int getPageNumber() {
		return pageable.getPageNumber();
	}

	/**
	 * 获取每页记录数.
	 * 
	 * @return 每页记录数
	 */
	public int getPageSize() {
		return pageable.getPageSize();
	}

	/**
	 * 获取搜索属性.
	 * 
	 * @return 搜索属性
	 */
	public String getSearchProperty() {
		return pageable.getSearchProperty();
	}

	/**
	 * 获取搜索值.
	 * 
	 * @return 搜索值
	 */
	public String getSearchValue() {
		return pageable.getSearchValue();
	}

	/**
	 * 获取总页数.
	 * 
	 * @return 总页数
	 */
	public int getTotalPages() {
		return (int) Math.ceil((double) getTotal() / (double) getPageSize());
	}

	/**
	 * 获取内容.
	 * 
	 * @return 内容
	 */
	public List<T> getContent() {
		return content;
	}

	/**
	 * 获取总记录数.
	 * 
	 * @return 总记录数
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * 获取分页信息.
	 * 
	 * @return 分页信息
	 */
	public Pageable getPageable() {
		return pageable;
	}
}
