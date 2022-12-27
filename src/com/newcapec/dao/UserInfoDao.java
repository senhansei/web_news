package com.newcapec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newcapec.entity.UserInfoEntity;
import com.newcapec.utils.DBUtils;

public class UserInfoDao implements BaseDao<UserInfoEntity> {

	public UserInfoEntity login(String userName, String userPwd) throws ClassNotFoundException, SQLException {
		UserInfoEntity userInfoEntity = null;
		Connection connection = DBUtils.openConn();
		String sql = "select * from user_info where user_name = ? and user_pwd = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, userName);
		statement.setString(2, userPwd);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			int userId = resultSet.getInt("user_id");
			Date createTime = resultSet.getTimestamp("create_time");
			Date updateTime = resultSet.getTimestamp("update_time");
			userInfoEntity = new UserInfoEntity(userId, userName, userPwd, createTime, updateTime);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return userInfoEntity;
	}

	public boolean insert(UserInfoEntity t) throws ClassNotFoundException, SQLException {
		boolean flag = false;
		// 获取与数据库的连接
		Connection connection = DBUtils.openConn();
		// ?表示占位符 可以解决sql注入的问题
		String sql = "insert into user_info (user_name,user_pwd,create_time) values (?,?,now())";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, t.getUserName());
		statement.setString(2, t.getUserPwd());
		// 执行sql语句
		int count = statement.executeUpdate();
		if (count > 0) {
			flag = true;
		}
		statement.close();
		connection.close();
		return flag;
	}

	@Override
	public boolean deleteById(int id) throws ClassNotFoundException, SQLException {
		boolean flag = false;
		// 获取连接
		Connection connection = DBUtils.openConn();
		// sql语句
		// String sql = "delete from user_info where user_id = ?";
		String sql = "update user_info set status = 0 where user_id = ?";
		// 预处理对象
		PreparedStatement statement = connection.prepareStatement(sql);
		// 添加参数
		statement.setInt(1, id);
		// 执行预处理对象
		int count = statement.executeUpdate();
		if (count > 0) {
			flag = true;
		}
		statement.close();
		connection.close();
		return flag;
	}

	@Override
	public boolean update(UserInfoEntity t) throws ClassNotFoundException, SQLException {
		boolean flag = false;
		// 获取连接
		Connection connection = DBUtils.openConn();
		// sql语句
		String sql = "update user_info set user_name = ?,user_pwd = ? where user_id = ?";
		// 预处理对象
		PreparedStatement statement = connection.prepareStatement(sql);
		// 添加参数
		statement.setString(1, t.getUserName());
		statement.setString(2, t.getUserPwd());
		statement.setInt(3, t.getUserId());
		// 执行预处理对象
		int count = statement.executeUpdate();
		if (count > 0) {
			flag = true;
		}
		statement.close();
		connection.close();
		return flag;
	}

	@Override
	public UserInfoEntity selectById(int id) throws ClassNotFoundException, SQLException {
		UserInfoEntity userInfoEntity = null;
		Connection connection = DBUtils.openConn();
		String sql = "select * from user_info where user_id = ? and status = 1";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			int userId = resultSet.getInt("user_id");
			String userName = resultSet.getString("user_name");
			String userPwd = resultSet.getString("user_pwd");
			Date createTime = resultSet.getTimestamp("create_time");
			Date updateTime = resultSet.getTimestamp("update_time");
			userInfoEntity = new UserInfoEntity(userId, userName, userPwd, createTime, updateTime);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return userInfoEntity;
	}

	@Override
	public List<UserInfoEntity> selectAll() throws ClassNotFoundException, SQLException {
		List<UserInfoEntity> list = new ArrayList<>();
		Connection connection = DBUtils.openConn();
		String sql = "select * from user_info";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			int userId = resultSet.getInt("user_id");
			String userName = resultSet.getString("user_name");
			String userPwd = resultSet.getString("user_pwd");
			Date createTime = resultSet.getTimestamp("create_time");
			Date updateTime = resultSet.getTimestamp("update_time");
			UserInfoEntity userInfoEntity = new UserInfoEntity(userId, userName, userPwd, createTime, updateTime);
			list.add(userInfoEntity);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}

	public List<UserInfoEntity> selectByPage(int offset, int limit) throws ClassNotFoundException, SQLException {
		List<UserInfoEntity> list = new ArrayList<>();
		Connection connection = DBUtils.openConn();
		String sql = "select * from user_info where status = 1 limit ?,?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, offset);
		statement.setInt(2, limit);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			int userId = resultSet.getInt("user_id");
			String userName = resultSet.getString("user_name");
			String userPwd = resultSet.getString("user_pwd");
			Date createTime = resultSet.getTimestamp("create_time");
			Date updateTime = resultSet.getTimestamp("update_time");
			UserInfoEntity userInfoEntity = new UserInfoEntity(userId, userName, userPwd, createTime, updateTime);
			list.add(userInfoEntity);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}

	public int selectCount() throws ClassNotFoundException, SQLException {
		int count = 0;
		Connection connection = DBUtils.openConn();
		String sql = "SELECT COUNT(*) AS userCount FROM user_info where status = 1";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			count = resultSet.getInt("userCount");
		}
		resultSet.close();
		statement.close();
		connection.close();
		return count;
	}

	@Override
	public boolean batchDeleteById(int[] ids) throws ClassNotFoundException, SQLException {
		boolean flag = false;
		// 获取连接
		Connection connection = DBUtils.openConn();
		// sql语句
		// String sql = "delete from user_info where user_id = ?";
		String sql = "update user_info set status = 0 where user_id = ?";
		// 预处理对象
		PreparedStatement statement = connection.prepareStatement(sql);
		// 添加参数
		for (int id : ids) {
			statement.setInt(1, id);
			statement.addBatch();
		}
		int[] result = statement.executeBatch();
		// 执行预处理对象
		// int count = statement.executeUpdate();
		if (result.length > 0) {
			flag = true;
		}
		statement.close();
		connection.close();
		return flag;
	}

}