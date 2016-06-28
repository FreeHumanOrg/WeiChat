package com.weichat.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Java JDBC���ݿ����ӹ�����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�JDBCUtils.java ��������TODO �����ˣ����� ����ʱ�䣺2016��6��28�� ����1:52:34
 * �޸��ˣ����� �޸�ʱ�䣺2016��6��28�� ����1:52:34 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public class JDBCUtils {

	/**
	 * ����������
	 */
	static String driver;

	/**
	 * ���ݿ����ӵ�ַ
	 */
	static String url;

	/**
	 * �û���
	 */
	static String username;

	/**
	 * ����
	 */
	static String password;

	/**
	 * ��ʼ�����ݿ�������Ϣ
	 */
	static {
		Properties properties = new Properties();
		try {
			properties.load(JDBCUtils.class
					.getResourceAsStream("/hibernate.properties"));
			driver = properties.getProperty("dataSource.driverClassName");
			url = properties.getProperty("dataSource.url");
			username = properties.getProperty("dataSource.username");
			password = properties.getProperty("dataSource.password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡ���ݿ����Ӷ���.
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = (Connection) DriverManager.getConnection(url, username,
					password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * �ͷ���Դ.
	 * 
	 * @param o
	 */
	private static void release(Object o) {
		if (o == null) {
			return;
		}
		if (o instanceof ResultSet) {
			try {
				((ResultSet) o).close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (o instanceof Statement) {
			try {
				((Statement) o).close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (o instanceof Connection) {
			Connection c = (Connection) o;
			try {
				if (!c.isClosed()) {
					c.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * �ر����ӣ��ͷ���Դ.
	 * 
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		release(rs);
		release(stmt);
		release(conn);
	}
}
