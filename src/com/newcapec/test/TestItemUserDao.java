package com.newcapec.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.newcapec.dao.ItemUserDao;
import com.newcapec.entity.ItemUserEntity;

public class TestItemUserDao {

	private ItemUserDao ItemUserDao = new ItemUserDao();

	@Test
	public void testInsert() throws ClassNotFoundException, SQLException {
		ItemUserEntity itemUserEntity = new ItemUserEntity();
		itemUserEntity.setUserId(1);
		itemUserEntity.setItemId(1);
		Assert.assertTrue(ItemUserDao.insert(itemUserEntity));
	}

	@Test
	public void testDeleteById() throws ClassNotFoundException, SQLException {
		Assert.assertTrue(ItemUserDao.deleteById(1));
	}

	@Test
	public void testUpdate() throws ClassNotFoundException, SQLException {
		ItemUserEntity entity = ItemUserDao.selectById(2);
		entity.setItemId(2);
		Assert.assertTrue(ItemUserDao.update(entity));
	}

	@Test
	public void testSelectAll() throws ClassNotFoundException, SQLException {
		System.out.println(ItemUserDao.selectAll());
	}

}