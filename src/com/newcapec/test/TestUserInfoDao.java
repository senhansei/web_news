package com.newcapec.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.newcapec.dao.UserInfoDao;
import com.newcapec.entity.UserInfoEntity;

public class TestUserInfoDao {

	private UserInfoDao userInfoDao = new UserInfoDao();

	@Test
	public void testInsert() throws ClassNotFoundException, SQLException {
		/*
		 * UserInfoEntity userInfoEntity = new UserInfoEntity();
		 * userInfoEntity.setUserName("ÃÔ∆ﬂ"); userInfoEntity.setUserPwd("123456");
		 * //userInfoDao.insert(userInfoEntity);
		 * Assert.assertTrue(userInfoDao.insert(userInfoEntity));
		 */
		for (int i = 1; i <= 100; i++) {
			UserInfoEntity userInfoEntity = new UserInfoEntity();
			userInfoEntity.setUserName("userName" + i);
			userInfoEntity.setUserPwd("123456");
			// userInfoDao.insert(userInfoEntity);
			Assert.assertTrue(userInfoDao.insert(userInfoEntity));
		}
	}

	@Test
	public void testSelect() throws ClassNotFoundException, SQLException {
		List<UserInfoEntity> list = userInfoDao.selectAll();
		System.out.println(list);
	}

	@Test
	public void testDeleteById() throws ClassNotFoundException, SQLException {
		Assert.assertTrue(userInfoDao.deleteById(7));
	}

	@Test
	public void testUpdate() throws ClassNotFoundException, SQLException {
		UserInfoEntity userInfoEntity = userInfoDao.selectById(1);
		userInfoEntity.setUserName("zhangsan");
		userInfoDao.update(userInfoEntity);
	}

	@Test
	public void testselectById() throws ClassNotFoundException, SQLException {
		System.out.println(userInfoDao.selectById(1));
	}

}