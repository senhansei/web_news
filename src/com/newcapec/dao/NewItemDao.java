package com.newcapec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newcapec.entity.NewItemEntity;
import com.newcapec.utils.DBUtils;

public class NewItemDao implements BaseDao<NewItemEntity> {

	public int insert(NewItemEntity t) throws ClassNotFoundException, SQLException {
		Connection connection = DBUtils.openConn();
		String sql = "insert into new_item (item_name,create_time) values (?,now())";
		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, t.getItemName());
		statement.executeUpdate();
		ResultSet resultSet = statement.getGeneratedKeys();
		resultSet.next();
		int id = resultSet.getInt(1);
		statement.close();
		connection.close();
		return id;
	}

	@Override
	public boolean deleteById(int id) throws ClassNotFoundException, SQLException {
		boolean flag = false;
		// 获取连接
		Connection connection = DBUtils.openConn();
		// sql语句
		String sql = "delete from new_item where item_id = ?";
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
	public boolean update(NewItemEntity t) throws ClassNotFoundException, SQLException {
		boolean flag = false;
		// 获取连接
		Connection connection = DBUtils.openConn();
		// sql语句
		String sql = "update new_item set item_name = ? where item_id = ?";
		// 预处理对象
		PreparedStatement statement = connection.prepareStatement(sql);
		// 添加参数
		statement.setString(1, t.getItemName());
		statement.setInt(2, t.getItemId());
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
	public NewItemEntity selectById(int id) throws ClassNotFoundException, SQLException {
		NewItemEntity newItemEntity = null;
		Connection connection = DBUtils.openConn();
		String sql = "select * from new_item where item_id = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			int itemId = resultSet.getInt("item_id");
			String itemName = resultSet.getString("item_name");
			Date createTime = resultSet.getTimestamp("create_time");
			Date updateTime = resultSet.getTimestamp("update_time");
			newItemEntity = new NewItemEntity(itemId, itemName, createTime, updateTime);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return newItemEntity;
	}

	@Override
	public List<NewItemEntity> selectAll() throws ClassNotFoundException, SQLException {
		List<NewItemEntity> list = new ArrayList<>();
		Connection connection = DBUtils.openConn();
		String sql = "select * from new_item ";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			int itemId = resultSet.getInt("item_id");
			String itemName = resultSet.getString("item_name");
			Date createTime = resultSet.getTimestamp("create_time");
			Date updateTime = resultSet.getTimestamp("update_time");
			NewItemEntity newItemEntity = new NewItemEntity(itemId, itemName, createTime, updateTime);
			list.add(newItemEntity);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}

	public List<NewItemEntity> selectAllByUserId(int userId) throws ClassNotFoundException, SQLException {
		List<NewItemEntity> list = new ArrayList<>();
		Connection connection = DBUtils.openConn();
		String sql = "SELECT new_item.`item_id`,new_item.`item_name`,new_item.`create_time`,new_item.`update_time` FROM new_item \r\n"
				+ "	INNER JOIN item_user ON new_item.`item_id` = item_user.`item_id`\r\n"
				+ "	INNER JOIN user_info ON user_info.`user_id` = item_user.`user_id`\r\n"
				+ "	WHERE user_info.user_id = ? and new_item.status = 1";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, userId);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			int itemId = resultSet.getInt("item_id");
			String itemName = resultSet.getString("item_name");
			Date createTime = resultSet.getTimestamp("create_time");
			Date updateTime = resultSet.getTimestamp("update_time");
			NewItemEntity newItemEntity = new NewItemEntity(itemId, itemName, createTime, updateTime);
			list.add(newItemEntity);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}

	public int selectAllByUserIdCount(int userId) throws ClassNotFoundException, SQLException {
		int count = 0;
		Connection connection = DBUtils.openConn();
		String sql = "SELECT count(*) as allCount FROM new_item \r\n"
				+ "	INNER JOIN item_user ON new_item.`item_id` = item_user.`item_id`\r\n"
				+ "	INNER JOIN user_info ON user_info.`user_id` = item_user.`user_id`\r\n where new_item.status = 1 AND user_info.`user_id` = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, userId);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			count = resultSet.getInt("allCount");
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
		// String sql = "delete from new_item where item_id = ?";
		String sql = "update new_item set status = 0 where item_id = ?";
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