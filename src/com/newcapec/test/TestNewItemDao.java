package com.newcapec.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.newcapec.dao.NewItemDao;
import com.newcapec.entity.NewItemEntity;

public class TestNewItemDao {

	private NewItemDao newItemDao = new NewItemDao();

	@Test
	public void testInsert() throws ClassNotFoundException, SQLException {
		NewItemEntity newItemEntity = new NewItemEntity();
		newItemEntity.setItemId(1);
		newItemEntity.setItemName("≤Â»Î≤‚ ‘");
		// Assert.assertTrue(newItemDao.insert(newItemEntity));
	}

	@Test
	public void testDeleteById() throws ClassNotFoundException, SQLException {
		Assert.assertTrue(newItemDao.deleteById(14));
	}

	@Test
	public void testUpdate() throws ClassNotFoundException, SQLException {
		NewItemEntity entity = newItemDao.selectById(1);
		entity.setItemName("∏¸–¬item≤‚ ‘");
		Assert.assertTrue(newItemDao.update(entity));
	}

	@Test
	public void testSelectAll() throws ClassNotFoundException, SQLException {
		System.out.println(newItemDao.selectAll());
	}

}