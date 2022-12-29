package com.newcapec.test;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import com.newcapec.dao.NewsInfoDao;
import com.newcapec.entity.NewsInfoEntity;

public class TestNewsInfoDao {

	private NewsInfoDao newsInfoDao = new NewsInfoDao();

	@Test
	public void testInsert() throws ClassNotFoundException, SQLException {
		NewsInfoEntity newsInfoEntity = new NewsInfoEntity();
		newsInfoEntity.setItemId(1);
		newsInfoEntity.setNewsTitle("����Դ�ٻش���˹���ġ���ʽ���������۳�");
		newsInfoEntity.setNewsImage(
				"http://pics1.baidu.com/feed/71cf3bc79f3df8dcecfa18268a75ee8c46102829.jpeg?token=32875797d2ded1ed2a9334df610bccf7");
		newsInfoEntity.setNewsContent("���˿Ƽ� ���ӽ�\r\n" + "�ӡ�Ӳ�������������ٻء�����������ֻ����5�졣\r\n"
				+ "������ǰ�����������ٻ��¼���ǰ���ʱ23�죬����������֮����Ϊ��ʷ������ٻء�����������Ǽ򵥶Աȣ�������������ˢ������ʷ��¼��\r\n"
				+ "�������쳵������˵�������ڹ��պ��¼������ٻ��Ǵ�����¼���Ŀǰ����С��δ��ʵ�ʵ��ٻؾ���֮�⣬ε�����������������Լ�����������������������˹�������������ٻء�ֻ�������й����쳵��������˹�����ֳ�����̬�Ƚ�Ȼ��ͬ��\r\n"
				+ "���̿֡����쳵������\r\n" + "11��1�գ�����������ý�幵ͨ�������������ǰ�����°ڱ������͵��̵ġ����������������ǰ�����°ڱ���������̫��������ONE��γ��ֶ����¼��й�ϵ��\r\n"
				+ "�����������Ĵ���⵽���ɡ�һ��������������CEO���빫�����ϡ������϶�����Ϊ��Ʒ��ȱ�ݣ�����������ʻ���з�����ײ�ϵ��ļ��ʸ���ƽ��ֵ����������һ���棬������һ��ʼ���ϡ��ٻء����ԡ�������������档\r\n"
				+ "�����������۷����ܲ�����ǿ�����������������ڳ�����������ʻ�����г��ֹ��Ϻ�����������ٻأ��ǲ�һ���ġ�11��6�գ������������������ٻ�10469������ONE��ռ�ѽ��������Ľ���50%��\r\n"
				+ "�ٷ���¶����Ϣ��ʾ������2020��10��31�գ�����ONE�ۼƷ�����97��ǰ������ײ�¹ʣ�����ǰ�����°ڱ���ͷ�������ѳ����������10�������������������ײ֮�����������¹ʡ�");
		Assert.assertTrue(newsInfoDao.insert(newsInfoEntity));
	}

	@Test
	public void testDeleteById() throws ClassNotFoundException, SQLException {
		Assert.assertTrue(newsInfoDao.deleteById(1));
	}

	@Test
	public void testUpdate() throws ClassNotFoundException, SQLException {
		NewsInfoEntity entity = newsInfoDao.selectById(2);
		entity.setNewsTitle("ͼ���ά�ޣ���ͣ����һ��");
		Assert.assertTrue(newsInfoDao.update(entity));
	}

	@Test
	public void testSelectAll() throws ClassNotFoundException, SQLException {
		System.out.println(newsInfoDao.selectAll());
	}

}