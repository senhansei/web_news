package com.newcapec.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

/**
 * ��ȡ�����ݿ������ �˴�������Ҫʹ�ð���Ͱ͵�druid���ݿ����ӳ��Ż�
 * 
 * @author user
 *
 */
public class DBUtils {



	public static Connection openConn() throws ClassNotFoundException, SQLException {
		// �������ݿ���Ҫ��
		// url username password driver
		String user = "root";
		String password = "123456";
		// String driver = "com.mysql.jdbc.Driver";
		// String url = "jdbc:mysql://127.0.0.1:3306/zykkk?characterEncoding=UTF-8";
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/zykkk?characterEncoding=utf-8&serverTimezone=UTC";// (UTC��ʾ��׼ʱ��)
		// ע�����ݿ�����
		Class.forName(driver);

		return DriverManager.getConnection(url, user, password);
	}

}