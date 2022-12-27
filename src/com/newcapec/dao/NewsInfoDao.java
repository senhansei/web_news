package com.newcapec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newcapec.entity.NewsInfoEntity;
import com.newcapec.utils.DBUtils;

public class NewsInfoDao implements BaseDao<NewsInfoEntity> {

	public boolean insert(NewsInfoEntity t) throws ClassNotFoundException, SQLException {
		boolean flag = false;
		Connection connection = DBUtils.openConn();
		String sql = "insert into news_info (item_id,news_title,news_content,create_time) values (?,?,?,now())";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, t.getItemId());
		statement.setString(2, t.getNewsTitle());
		statement.setString(3, t.getNewsContent());
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
		String sql = "delete from news_info where news_id = ?";
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
	public boolean update(NewsInfoEntity t) throws ClassNotFoundException, SQLException {
		boolean flag = false;
		Connection connection = DBUtils.openConn();
		String sql = "update news_info set item_id = ?, news_title = ?, news_image = ?, news_content=? where news_id = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, t.getItemId());
		statement.setString(2, t.getNewsTitle());
		statement.setString(3, t.getNewsImage());
		statement.setString(4, t.getNewsContent());
		statement.setInt(5, t.getNewsId());
		int count = statement.executeUpdate();
		if (count > 0) {
			flag = true;
		}
		statement.close();
		connection.close();
		return flag;
	}

	@Override
	public NewsInfoEntity selectById(int id) throws ClassNotFoundException, SQLException {
		NewsInfoEntity newsInfoEntity = null;
		Connection connection = DBUtils.openConn();
		String sql = "select * from news_info where news_id = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			int newsId = resultSet.getInt("news_id");
			int itemId = resultSet.getInt("item_id");
			String newsTitle = resultSet.getString("news_title");
			String newsContent = resultSet.getString("news_content");
			String newsImage = resultSet.getString("news_image");
			Date createTime = resultSet.getDate("create_time");
			Date updateTime = resultSet.getDate("update_time");
			newsInfoEntity = new NewsInfoEntity(newsId, itemId, newsTitle, newsImage, newsContent, createTime,
					updateTime);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return newsInfoEntity;
	}

	@Override
	public List<NewsInfoEntity> selectAll() throws ClassNotFoundException, SQLException {
		List<NewsInfoEntity> list = new ArrayList<NewsInfoEntity>();
		Connection connection = DBUtils.openConn();
		String sql = "select * from news_info";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			int newsId = resultSet.getInt("news_id");
			int itemId = resultSet.getInt("item_id");
			String newsTitle = resultSet.getString("news_title");
			String newsContent = resultSet.getString("news_content");
			String newsImage = resultSet.getString("news_image");
			Date createTime = resultSet.getDate("create_time");
			Date updateTime = resultSet.getDate("update_time");
			NewsInfoEntity newsInfoEntity = new NewsInfoEntity(newsId, itemId, newsTitle, newsImage, newsContent,
					createTime, updateTime);
			list.add(newsInfoEntity);
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