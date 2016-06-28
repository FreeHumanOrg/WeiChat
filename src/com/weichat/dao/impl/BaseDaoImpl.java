package com.weichat.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.weichat.dao.BaseDao;
import com.weichat.util.Page;

/**
 * DAO����ӿڵ�ʵ����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�BaseDaoImpl.java ��������TODO �����ˣ����� ����ʱ�䣺2016-6-20 ����11:30:04
 * �޸��ˣ����� �޸�ʱ�䣺2016-6-20 ����11:30:04 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public class BaseDaoImpl<T, ID extends Serializable> implements BaseDao<T, ID> {
	private static Logger LOGGER = LoggerFactory.getLogger(BaseDaoImpl.class);

	/**
	 * ��������ö��
	 * 
	 * 
	 * ��Ŀ���ƣ�WeiChat �����ƣ�BaseDaoImpl.java ��������TODO �����ˣ����� ����ʱ�䣺2016��6��23��
	 * ����9:53:14 �޸��ˣ����� �޸�ʱ�䣺2016��6��23�� ����9:53:14 �޸ı�ע��
	 * 
	 * FreeHuman Soft Team
	 * 
	 * @version 1.0 Beta
	 */
	public enum SearchType {
		// ����������
		NONE("none"),

		// ģ��ƥ��
		ILIKE("ilike"),

		// ��ȷƥ��
		EQUAL("equal");

		private String value;

		private SearchType(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	/**
	 * ʵ�������͵�����
	 */
	private final Class<T> entityClass;

	@Resource
	protected HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		Type type = getClass().getGenericSuperclass();
		Type[] parameterizedType = ((ParameterizedType) type)
				.getActualTypeArguments();
		entityClass = (Class<T>) parameterizedType[0];
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return hibernateTemplate.executeFind(new HibernateCallback<List<T>>() {
			@Override
			public List<T> doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session.createCriteria(entityClass).list();
			}
		});
	}

	@Override
	public T findById(final ID id) {
		return hibernateTemplate.execute(new HibernateCallback<T>() {
			@SuppressWarnings("unchecked")
			@Override
			public T doInHibernate(Session session) throws HibernateException,
					SQLException {
				return (T) session.get(entityClass, id);
			}
		});
	}

	@Override
	public T findTById(final ID id) {
		return hibernateTemplate.execute(new HibernateCallback<T>() {
			@Override
			public T doInHibernate(Session session) throws HibernateException,
					SQLException {
				return (T) session.createCriteria(entityClass)
						.add(Restrictions.eq("infomation.id", id))
						.uniqueResult();
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<T> findPage(Page<T> page, SearchType searchType) {
		final Page<T> pageIn = page;
		final SearchType searchTypeIn = searchType;
		List<T> contentList = hibernateTemplate
				.executeFind(new HibernateCallback<List<T>>() {
					@Override
					public List<T> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria criteria = session.createCriteria(entityClass);
						criteria.setFirstResult((pageIn.getPageIndex() - 1)
								* pageIn.getPageSize());
						criteria.setMaxResults(pageIn.getPageSize());

						// ģ��ƥ��
						if (searchTypeIn.hashCode() == SearchType.ILIKE
								.hashCode()) {
							criteria.add(Restrictions.ilike(
									pageIn.getSearchProperty(),
									pageIn.getSearchValue()));
							// ��ȷƥ��
						} else if (searchTypeIn.hashCode() == SearchType.EQUAL
								.hashCode()) {
							criteria.add(Restrictions.eq(
									pageIn.getSearchProperty(),
									pageIn.getSearchValue()));
						}
						return criteria.list();
					}
				});

		Long totalCount = hibernateTemplate
				.execute(new HibernateCallback<Long>() {
					@Override
					public Long doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria criteria = session.createCriteria(entityClass);

						// ģ��ƥ��
						if (searchTypeIn.hashCode() == SearchType.ILIKE
								.hashCode()) {
							criteria.add(Restrictions.ilike(
									pageIn.getSearchProperty(),
									pageIn.getSearchValue()));
							// ��ȷƥ��
						} else if (searchTypeIn.hashCode() == SearchType.EQUAL
								.hashCode()) {
							criteria.add(Restrictions.eq(
									pageIn.getSearchProperty(),
									pageIn.getSearchValue()));
						}
						criteria.setProjection(Projections.rowCount());
						Object result = criteria.uniqueResult();
						return Long.valueOf(result.toString());
					}
				});
		return new Page<T>(contentList, totalCount.intValue(),
				pageIn.getPageIndex());
	}

	@Override
	public Boolean save(T entity) {
		try {
			hibernateTemplate.save(entity);
			return true;
		} catch (DataAccessException dataAccessException) {
			dataAccessException.printStackTrace();
			LOGGER.error("Save an entity was filed!Because of:"
					+ dataAccessException.getMessage());
		} catch (Exception e) {
			e.getMessage();
			LOGGER.error("Save an entity was filed!Because of:"
					+ e.getMessage());
		}
		LOGGER.error("Save an entity was filed!");
		return false;
	}

	@Override
	public Boolean remove(T entity) {
		try {
			hibernateTemplate.delete(entity);
			return true;
		} catch (DataAccessException dataAccessException) {
			dataAccessException.printStackTrace();
			LOGGER.error("Delete an entity was filed!Because of:"
					+ dataAccessException.getMessage());
		} catch (Exception e) {
			e.getMessage();
			LOGGER.error("Delete an entity was filed!Because of:"
					+ e.getMessage());
		}
		LOGGER.error("Delete an entity was filed!");
		return false;
	}

	@Override
	public List<T> findsById(final ID id) {
		return hibernateTemplate.execute(new HibernateCallback<List<T>>() {
			@SuppressWarnings("unchecked")
			@Override
			public List<T> doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session.createCriteria(entityClass)
						.add(Restrictions.eq("infomation.id", id)).list();
			}
		});
	}

	@Override
	public Boolean update(T entity) {
		try {
			//Illegal attempt to associate a collection with two open sessions����
			hibernateTemplate.update(hibernateTemplate.merge(entity));
			return true;
		} catch (DataAccessException dataAccessException) {
			dataAccessException.printStackTrace();
			LOGGER.error("Update an entity was filed!Because of:"
					+ dataAccessException.getMessage());
		} catch (Exception e) {
			e.getMessage();
			LOGGER.error("Update an entity was filed!Because of:"
					+ e.getMessage());
		}
		LOGGER.error("Update an entity was filed!");
		return false;
	}
}
