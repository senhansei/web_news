package com.newcapec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newcapec.entity.LogsInfoEntity;
import com.newcapec.utils.DBUtils;

public class LogsInfoDao implements BaseDao<LogsInfoEntity> {

	public boolean insert(LogsInfoEntity t) throws ClassNotFoundException, SQLException {
		boolean flag = false;
		Connection connection = DBUtils.openConn();
		String sql = "insert into logs_info (user_id,logs_content,create_time) values (?,?,now())";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, t.getUserId());
		statement.setString(2, t.getLogsContent());
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
		String sql = "delete from logs_info where logs_id = ?";
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
	public boolean update(LogsInfoEntity t) throws ClassNotFoundException, SQLException {
		boolean flag = false;
		Connection connection = DBUtils.openConn();
		String sql = "update logs_info set user_id = ?, logs_content = ? where logs_id = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, t.getUserId());
		statement.setString(2, t.getLogsContent());
		statement.setInt(3, t.getLogsId());
		int count = statement.executeUpdate();
		if (count > 0) {
			flag = true;
		}
		statement.close();
		connection.close();
		return flag;
	}

	@Override
	public LogsInfoEntity selectById(int id) throws ClassNotFoundException, SQLException {
		LogsInfoEntity logsInfoEntity = null;
		Connection connection = DBUtils.openConn();
		String sql = "select * from logs_info where logs_id = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			int newsId = resultSet.getInt("logs_id");
			int itemId = resultSet.getInt("user_id");
			String logsContent = resultSet.getString("logs_content");
			Date createTime = resultSet.getDate("create_time");
			Date updateTime = resultSet.getDate("update_time");
			logsInfoEntity = new LogsInfoEntity(newsId, itemId, logsContent, createTime, updateTime);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return logsInfoEntity;
	}

	@Override
	public List<LogsInfoEntity> selectAll() throws ClassNotFoundException, SQLException {
		List<LogsInfoEntity> list = new ArrayList<LogsInfoEntity>();
		Connection connection = DBUtils.openConn();
		String sql = "select * from logs_info";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			int newsId = resultSet.getInt("logs_id");
			int itemId = resultSet.getInt("user_id");
			String logsContent = resultSet.getString("logs_content");
			Date createTime = resultSet.getDate("create_time");
			Date updateTime = resultSet.getDate("update_time");
			LogsInfoEntity logsInfoEntity = new LogsInfoEntity(newsId, itemId, logsContent, createTime, updateTime);
			list.add(logsInfoEntity);
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