package com.weichat.util;

import java.io.Serializable;

/**
 * Pageable��ҳ������
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�Pageable.java ��������TODO �����ˣ����� ����ʱ�䣺2016��6��23�� ����8:50:38
 * �޸��ˣ����� �޸�ʱ�䣺2016��6��23�� ����8:50:38 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public class Pageable implements Serializable {
	private static final long serialVersionUID = -3930180379790344299L;

	/** Ĭ��ҳ��. */
	private static final int DEFAULT_PAGE_NUMBER = 1;

	/** Ĭ��ÿҳ��¼��. */
	private static final int DEFAULT_PAGE_SIZE = 20;

	/** ���ÿҳ��¼��. */
	private static final int MAX_PAGE_SIZE = 1000;

	/** ҳ��. */
	private int pageNumber = DEFAULT_PAGE_NUMBER;

	/** ÿҳ��¼��. */
	private int pageSize = DEFAULT_PAGE_SIZE;

	/** ��������. */
	private String searchProperty;

	/** ����ֵ. */
	private String searchValue;

	/**
	 * ��ʼ��һ���´�����Pageable����.
	 */
	public Pageable() {
	}

	/**
	 * ��ʼ��һ���´�����Pageable����.
	 * 
	 * @param pageNumber
	 *            ҳ��
	 * @param pageSize
	 *            ÿҳ��¼��
	 */
	public Pageable(Integer pageNumber, Integer pageSize) {
		if ((pageNumber != null) && (pageNumber >= 1)) {
			this.pageNumber = pageNumber;
		}
		if ((pageSize != null) && (pageSize >= 1)
				&& (pageSize <= MAX_PAGE_SIZE)) {
			this.pageSize = pageSize;
		}
	}

	/**
	 * ��ȡҳ��.
	 * 
	 * @return ҳ��
	 */
	public int getPageNumber() {
		return pageNumber;
	}

	/**
	 * ����ҳ��.
	 * 
	 * @param pageNumber
	 *            ҳ��
	 */
	public void setPageNumber(int pageNumber) {
		if (pageNumber < 1) {
			pageNumber = DEFAULT_PAGE_NUMBER;
		}
		this.pageNumber = pageNumber;
	}

	/**
	 * ��ȡÿҳ��¼��.
	 * 
	 * @return ÿҳ��¼��
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * ����ÿҳ��¼��.
	 * 
	 * @param pageSize
	 *            ÿҳ��¼��
	 */
	public void setPageSize(int pageSize) {
		if ((pageSize < 1) || (pageSize > MAX_PAGE_SIZE)) {
			pageSize = DEFAULT_PAGE_SIZE;
		}
		this.pageSize = pageSize;
	}

	/**
	 * ��ȡ��������.
	 * 
	 * @return ��������
	 */
	public String getSearchProperty() {
		return searchProperty;
	}

	/**
	 * ������������.
	 * 
	 * @param searchProperty
	 *            ��������
	 */
	public void setSearchProperty(String searchProperty) {
		this.searchProperty = searchProperty;
	}

	/**
	 * ��ȡ����ֵ.
	 * 
	 * @return ����ֵ
	 */
	public String getSearchValue() {
		return searchValue;
	}

	/**
	 * ��������ֵ.
	 * 
	 * @param searchValue
	 *            ����ֵ
	 */
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
}
