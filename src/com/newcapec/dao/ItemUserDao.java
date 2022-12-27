package com.newcapec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newcapec.entity.ItemUserEntity;
import com.newcapec.utils.DBUtils;

public class ItemUserDao implements BaseDao<ItemUserEntity> {

	public boolean insert(ItemUserEntity t) throws ClassNotFoundException, SQLException {
		boolean flag = false;
		// 获取与数据库的连接
		Connection connection = DBUtils.openConn();
		// ?表示占位符 可以解决sql注入的问题
		String sql = "insert into item_user (user_id,item_id,create_time) values (?,?,now())";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, t.getUserId());
		statement.setInt(2, t.getItemId());
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
		Connection connection = DBUtils.openConn();
		String sql = "delete from item_user where item_user_id = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		int count = statement.executeUpdate();
		if (count > 0) {
			flag = true;
		}
		statement.close();
		connection.close();
		return flag;
	}

	@Override
	public boolean update(ItemUserEntity t) throws ClassNotFoundException, SQLException {
		boolean flag = false;
		// 获取连接
		Connection connection = DBUtils.openConn();
		// sql语句
		String sql = "update item_user set user_id = ?,item_id = ? where item_user_id = ?";
		// 预处理对象
		PreparedStatement statement = connection.prepareStatement(sql);
		// 添加参数
		statement.setInt(1, t.getUserId());
		statement.setInt(2, t.getItemId());
		statement.setInt(3, t.getItemUserId());
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
	public ItemUserEntity selectById(int id) throws ClassNotFoundException, SQLException {
		ItemUserEntity ItemUserEntity = null;
		Connection connection = DBUtils.openConn();
		String sql = "select * from item_user where item_user_id = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			int itemUserId = resultSet.getInt("item_user_id");
			int userId = resultSet.getInt("user_id");
			int itemId = resultSet.getInt("item_id");
			Date createTime = resultSet.getTimestamp("create_time");
			Date updateTime = resultSet.getTimestamp("update_time");
			ItemUserEntity = new ItemUserEntity(itemUserId, userId, itemId, createTime, updateTime);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return ItemUserEntity;
	}

	@Override
	public List<ItemUserEntity> selectAll() throws ClassNotFoundException, SQLException {
		List<ItemUserEntity> list = new ArrayList<>();
		Connection connection = DBUtils.openConn();
		String sql = "select * from item_user  and status = 1";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			int itemUserId = resultSet.getInt("item_user_id");
			int userId = resultSet.getInt("user_id");
			int itemId = resultSet.getInt("item_id");
			Date createTime = resultSet.getTimestamp("create_time");
			Date updateTime = resultSet.getTimestamp("update_time");
			ItemUserEntity itemUserEntity = new ItemUserEntity(itemUserId, userId, itemId, createTime, updateTime);
			list.add(itemUserEntity);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}

	@Override
	public boolean batchDeleteById(int[] ids) throws ClassNotFoundException, SQLException {
		// TODO 自动生成的方法存根
		return false;
	}

}