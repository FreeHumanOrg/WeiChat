package com.weichat.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Java JDBC数据库连接工具类
 * 
 * 
 * 项目名称：WeiChat 类名称：JDBCUtils.java 类描述：TODO 创建人：王晶 创建时间：2016年6月28日 下午1:52:34
 * 修改人：王晶 修改时间：2016年6月28日 下午1:52:34 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public class JDBCUtils {

	/**
	 * 驱动包名称
	 */
	static String driver;

	/**
	 * 数据库连接地址
	 */
	static String url;

	/**
	 * 用户名
	 */
	static String username;

	/**
	 * 密码
	 */
	static String password;

	/**
	 * 初始化数据库连接信息
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
	 * 获取数据库连接对象.
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
	 * 释放资源.
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
	 * 关闭连接，释放资源.
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
