package com.weichat.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Page��ҳʵ����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�Page.java ��������TODO �����ˣ����� ����ʱ�䣺2016��6��23�� ����8:50:58 �޸��ˣ�����
 * �޸�ʱ�䣺2016��6��23�� ����8:50:58 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public class Page<T> implements Serializable {
	private static final long serialVersionUID = -2053800594583879853L;
	private static final int MAX_PAGE_STEP = 10;

	/** ����. */
	private final List<T> content = new ArrayList<T>();

	/** �ܼ�¼��. */
	private final long total;

	/** ��ҳ��Ϣ. */
	private final Pageable pageable;
	private long stepBegin;
	private long stepEnd;

	/**
	 * ��ʼ��һ���´�����Page����.
	 */
	public Page() {
		this.total = 0L;
		this.pageable = new Pageable();
	}

	/**
	 * @param content
	 *            ����
	 * @param total
	 *            �ܼ�¼��
	 * @param pageable
	 *            ��ҳ��Ϣ
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
	 * ��ȡҳ��.
	 * 
	 * @return ҳ��
	 */
	public int getPageNumber() {
		return pageable.getPageNumber();
	}

	/**
	 * ��ȡÿҳ��¼��.
	 * 
	 * @return ÿҳ��¼��
	 */
	public int getPageSize() {
		return pageable.getPageSize();
	}

	/**
	 * ��ȡ��������.
	 * 
	 * @return ��������
	 */
	public String getSearchProperty() {
		return pageable.getSearchProperty();
	}

	/**
	 * ��ȡ����ֵ.
	 * 
	 * @return ����ֵ
	 */
	public String getSearchValue() {
		return pageable.getSearchValue();
	}

	/**
	 * ��ȡ��ҳ��.
	 * 
	 * @return ��ҳ��
	 */
	public int getTotalPages() {
		return (int) Math.ceil((double) getTotal() / (double) getPageSize());
	}

	/**
	 * ��ȡ����.
	 * 
	 * @return ����
	 */
	public List<T> getContent() {
		return content;
	}

	/**
	 * ��ȡ�ܼ�¼��.
	 * 
	 * @return �ܼ�¼��
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * ��ȡ��ҳ��Ϣ.
	 * 
	 * @return ��ҳ��Ϣ
	 */
	public Pageable getPageable() {
		return pageable;
	}
}
