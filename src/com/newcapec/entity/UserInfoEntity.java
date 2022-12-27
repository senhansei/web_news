package com.newcapec.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class UserInfoEntity {

	private int userId;
	private String userName;
	private String userPwd;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

	public UserInfoEntity() {
	}

	public UserInfoEntity(int userId, String userName, String userPwd) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
	}

	public UserInfoEntity(int userId, String userName, String userPwd, Date createTime, Date updateTime) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
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
		return "UserInfoEntity [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", createTime="
				+ createTime + ", updateTime=" + updateTime + "]";
	}

}