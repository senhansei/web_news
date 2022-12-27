package com.newcapec.entity;

import java.util.Date;

public class ItemUserEntity extends Object {

	private int itemUserId;
	private int userId;
	private int itemId;
	private Date createTime;
	private Date updateTime;

	public ItemUserEntity() {
	}

	public ItemUserEntity(int itemUserId, int userId, int itemId, Date createTime, Date updateTime) {
		super();
		this.itemUserId = itemUserId;
		this.userId = userId;
		this.itemId = itemId;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public int getItemUserId() {
		return itemUserId;
	}

	public void setItemUserId(int itemUserId) {
		this.itemUserId = itemUserId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
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
		return "ItemUserEntity [itemUserId=" + itemUserId + ", userId=" + userId + ", itemId=" + itemId
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}