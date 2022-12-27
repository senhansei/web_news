package com.newcapec.entity;

import java.util.Date;

public class LogsInfoEntity extends Object {

	private int logsId;
	private int userId;
	private String logsContent;
	private Date createTime;
	private Date updateTime;

	public LogsInfoEntity() {
	}

	public LogsInfoEntity(int logsId, int userId, String logsContent, Date createTime, Date updateTime) {
		super();
		this.logsId = logsId;
		this.userId = userId;
		this.logsContent = logsContent;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public int getLogsId() {
		return logsId;
	}

	public void setLogsId(int logsId) {
		this.logsId = logsId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getLogsContent() {
		return logsContent;
	}

	public void setLogsContent(String logsContent) {
		this.logsContent = logsContent;
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
		return "LogsInfoEntity [logsId=" + logsId + ", userId=" + userId + ", logsContent=" + logsContent
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}