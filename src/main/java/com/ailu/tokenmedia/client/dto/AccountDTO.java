package com.ailu.tokenmedia.client.dto;

public class AccountDTO {

	private int id;
	private String bizName;
	private String wechatid;
	private int fans;
	private int weekReadMean;
	private int weekReadCount;
	private int weekPushCount;
	private String logurl;

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

	public String getWechatid() {
		return wechatid;
	}

	public void setWechatid(String wechatid) {
		this.wechatid = wechatid;
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

	public String getLogurl() {
		return logurl;
	}

	public void setLogurl(String logurl) {
		this.logurl = logurl;
	}

}
