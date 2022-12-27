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
		newsInfoEntity.setNewsTitle("新能源召回大户特斯拉的“美式”傲慢｜观潮");
		newsInfoEntity.setNewsImage(
				"http://pics1.baidu.com/feed/71cf3bc79f3df8dcecfa18268a75ee8c46102829.jpeg?token=32875797d2ded1ed2a9334df610bccf7");
		newsInfoEntity.setNewsContent("新浪科技 花子健\r\n" + "从“硬件升级”到“召回”，理想汽车只用了5天。\r\n"
				+ "而不久前的威马汽车召回事件，前后耗时23天，威马汽车将之定义为“史上最快召回”。如果仅仅是简单对比，理想汽车无疑刷新了历史记录。\r\n"
				+ "对于新造车势力来说，受限于工艺和新技术，召回是大概率事件。目前除了小鹏未有实际的召回经历之外，蔚来汽车、威马汽车以及理想汽车，包括外来者特斯拉，都遇到过召回。只不过，中国新造车势力和特斯拉表现出来的态度截然不同。\r\n"
				+ "“惶恐”的造车新势力\r\n" + "11月1日，理想汽车在媒体沟通会上宣布了针对前悬架下摆臂球销和底盘的“免费升级”，其中前悬架下摆臂球销受力太低与理想ONE多次出现断轴事件有关系。\r\n"
				+ "但理想汽车的措辞遭到质疑。一方面是理想汽车CEO李想公开承认“升级肯定是因为产品有缺陷，我们是在行驶当中发生碰撞断掉的几率高于平均值。”而另外一方面，则是在一开始否认“召回”，以“免费升级”代替。\r\n"
				+ "理想汽车销售服务副总裁刘杰强调，升级和那种由于车辆本身在行驶过程中出现故障和质量问题的召回，是不一样的。11月6日，理想汽车最终宣布召回10469辆理想ONE，占已交付车辆的将近50%。\r\n"
				+ "官方披露的信息显示，截至2020年10月31日，理想ONE累计发生了97起前悬架碰撞事故，其中前悬架下摆臂球头从球销脱出的情况超过10起，造成了理想汽车在碰撞之后断轴的严重事故。");
		Assert.assertTrue(newsInfoDao.insert(newsInfoEntity));
	}

	@Test
	public void testDeleteById() throws ClassNotFoundException, SQLException {
		Assert.assertTrue(newsInfoDao.deleteById(1));
	}

	@Test
	public void testUpdate() throws ClassNotFoundException, SQLException {
		NewsInfoEntity entity = newsInfoDao.selectById(2);
		entity.setNewsTitle("图书馆维修，暂停开放一天");
		Assert.assertTrue(newsInfoDao.update(entity));
	}

	@Test
	public void testSelectAll() throws ClassNotFoundException, SQLException {
		System.out.println(newsInfoDao.selectAll());
	}

}