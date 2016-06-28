package com.weichat.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	public static final SessionFactory sessionFactory;

	static {
		try {
			// ����Ĭ�ϵ�hibernate.cfg.xml������һ��Configuration��ʵ��
			Configuration configuration = new Configuration().configure();
			// ��Configuration��ʵ��������һ��SessionFactoryʵ��
			sessionFactory = configuration.buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	// ThreadLocal�������̱߳��ػ���ʵ��,�����ֲ߳̾�������Ҳ����˵ÿ��ʹ�øñ������̶߳�����Ϊ
	// �ñ����ṩһ������,ÿ���̸߳ı�ñ�����ֵ�����Ǹı�ø�����ֵ,������Ӱ�������̵߳ĸñ���
	// ��ֵ.

	// ThreadLocal�Ǹ������̵߳����ݹ��������ڶ���߳�֮�乲����Դ,��˲�����Ҫ���߳�ͬ��
	@SuppressWarnings("rawtypes")
	public static final ThreadLocal session = new ThreadLocal();

	@SuppressWarnings("unchecked")
	public static Session currentSession() throws HibernateException {
		Session s = (Session) session.get();
		// ������̻߳�û��Session,�򴴽�һ���µ�Session
		if (s == null) {
			s = sessionFactory.openSession();
			// ����õ�Session�����洢��ThreadLocal����session��
			session.set(s);
		}
		return s;
	}

	@SuppressWarnings("unchecked")
	public static void closeSession() throws HibernateException {
		Session s = (Session) session.get();
		if (s != null)
			s.close();
		session.set(null);
	}
}
