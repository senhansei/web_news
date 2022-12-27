package com.newcapec.entity;

import java.util.Date;

public class NewsInfoEntity extends Object {

	private int newsId;
	private int itemId;
	private String newsTitle;
	private String newsImage;
	private String newsContent;
	private Date createTime;
	private Date updateTime;

	public NewsInfoEntity() {
	}

	public NewsInfoEntity(int newsId, int itemId, String newsTitle, String newsImage, String newsContent,
			Date createTime, Date updateTime) {
		super();
		this.newsId = newsId;
		this.itemId = itemId;
		this.newsTitle = newsTitle;
		this.newsImage = newsImage;
		this.newsContent = newsContent;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsImage() {
		return newsImage;
	}

	public void setNewsImage(String newsImage) {
		this.newsImage = newsImage;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "NewsInfoEntity [newsId=" + newsId + ", itemId=" + itemId + ", newsTitle=" + newsTitle + ", newsImage="
				+ newsImage + ", newsContent=" + newsContent + ", createTime=" + createTime + ", updateTime="
				+ updateTime + "]";
	}

}