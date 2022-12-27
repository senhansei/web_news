package com.newcapec.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

/**
 * 获取与数据库的连接 此处后期需要使用阿里巴巴的druid数据库连接池优化
 * 
 * @author user
 *
 */
public class DBUtils {



	public static Connection openConn() throws ClassNotFoundException, SQLException {
		// 连接数据库四要素
		// url username password driver
		String user = "root";
		String password = "123456";
		// String driver = "com.mysql.jdbc.Driver";
		// String url = "jdbc:mysql://127.0.0.1:3306/zykkk?characterEncoding=UTF-8";
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/zykkk?characterEncoding=utf-8&serverTimezone=UTC";// (UTC表示标准时区)
		// 注册数据库驱动
		Class.forName(driver);

		return DriverManager.getConnection(url, user, password);
	}

}