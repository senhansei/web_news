package com.newcapec.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class NewItemEntity extends Object {

	private int itemId;
	private String itemName;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

	public NewItemEntity() {
	}

	public NewItemEntity(int itemId, String itemName) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
	}

	public NewItemEntity(int itemId, String itemName, Date createTime, Date updateTime) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
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
		return "NewItemEntity [itemId=" + itemId + ", itemName=" + itemName + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}

}