package com.ailu.tokenmedia.client.dto;

public class AccountDTO {

	private int id;
	private String bizName;
	private String wechatId;
	private int fans;
	private int weekReadMean;
	private int weekReadCount;
	private int weekPushCount;
	private String head;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBizName() {
		return bizName;
	}

	public void setBizName(String bizName) {
		this.bizName = bizName;
	}

	public int getFans() {
		return fans;
	}

	public void setFans(int fans) {
		this.fans = fans;
	}

	public int getWeekReadMean() {
		return weekReadMean;
	}

	public void setWeekReadMean(int weekReadMean) {
		this.weekReadMean = weekReadMean;
	}

	public int getWeekReadCount() {
		return weekReadCount;
	}

	public void setWeekReadCount(int weekReadCount) {
		this.weekReadCount = weekReadCount;
	}

	public int getWeekPushCount() {
		return weekPushCount;
	}

	public void setWeekPushCount(int weekPushCount) {
		this.weekPushCount = weekPushCount;
	}

	public String getWechatId() {
		return wechatId;
	}

	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

}
