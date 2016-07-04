package com.weichat.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.weichat.dao.UserDao;
import com.weichat.model.User;

/**
 * 用户接口的实现类
 * 
 * 
 * 项目名称：WeiChat 类名称：BaseDaoImpl.java 类描述：TODO 创建人：王晶 创建时间：2016-6-20 上午11:30:04
 * 修改人：王晶 修改时间：2016-6-20 上午11:30:04 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Repository("userDaoImpl")
public class UserDaoImpl extends BaseDaoImpl<User, Double> implements UserDao {

	@Override
	public List<User> findAll() {
		return super.findAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findUsersByIds(final String[] genJinRenIds) {
		return hibernateTemplate
				.executeFind(new HibernateCallback<List<User>>() {

					@Override
					public List<User> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria criteria = session.createCriteria(User.class);
						Disjunction disjunction = Restrictions.disjunction();
						for (int i = 0; i < genJinRenIds.length; i++) {
							disjunction.add(Restrictions.eq("id",
									Double.valueOf(genJinRenIds[i].toString())));
						}
						criteria.add(disjunction);
						return criteria.list();
					}
				});
	}

	@Override
	public Boolean addUser(User user) {
		try {
			this.hibernateTemplate.save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User findUserByOpenId(String openId) {
		List<User> users = this.hibernateTemplate.find(
				"from User t where t.openid=?", new Object[] { openId });
		if (users != null && users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	@Override
	public User findUserByOperateCode(final Double operateCode) {
		return hibernateTemplate.execute(new HibernateCallback<User>() {
			@Override
			public User doInHibernate(Session session)
					throws HibernateException, SQLException {
				return (User) session
						.createQuery("from User u where u.id = :operateCode")
						.setParameter("operateCode", operateCode)
						.uniqueResult();
			}
		});
	}
}
