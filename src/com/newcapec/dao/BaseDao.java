package com.newcapec.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * JDBC�ں�����Ҫʹ��hibernate/mybatis�Ż�
 * 
 * @author user
 *
 * @param <T>
 */
public interface BaseDao<T> {
	// public int insert(T t) throws ClassNotFoundException, SQLException;
	
	public boolean deleteById(int id) throws ClassNotFoundException, SQLException;

	public boolean batchDeleteById(int[] ids) throws ClassNotFoundException, SQLException;

	public boolean update(T t) throws ClassNotFoundException, SQLException;

	public T selectById(int id) throws ClassNotFoundException, SQLException;

	public List<T> selectAll() throws ClassNotFoundException, SQLException;
}