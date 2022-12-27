package com.newcapec.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.newcapec.dao.LogsInfoDao;
import com.newcapec.entity.LogsInfoEntity;

public class TestLogsInfoDao {

	private LogsInfoDao logsInfoDao = new LogsInfoDao();

	@Test
	public void testInsert() throws ClassNotFoundException, SQLException {
		LogsInfoEntity logsInfoEntity = new LogsInfoEntity();
		logsInfoEntity.setUserId(1);
		logsInfoEntity.setLogsContent("woshishenren");
		// userInfoDao.insert(userInfoEntity);
		Assert.assertTrue(logsInfoDao.insert(logsInfoEntity));
	}

	@Test
	public void testSelect() throws ClassNotFoundException, SQLException {
		List<LogsInfoEntity> list = logsInfoDao.selectAll();
		System.out.println(list);
	}

	@Test
	public void testDeleteById() throws ClassNotFoundException, SQLException {
		Assert.assertTrue(logsInfoDao.deleteById(2));
	}

	@Test
	public void testUpdate() throws ClassNotFoundException, SQLException {
		LogsInfoEntity logsInfoEntity = logsInfoDao.selectById(2);
		logsInfoEntity.setUserId(1);
		logsInfoDao.update(logsInfoEntity);
	}

	@Test
	public void testselectById() throws ClassNotFoundException, SQLException {
		System.out.println(logsInfoDao.selectById(1));
	}

}