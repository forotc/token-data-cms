package com.weinxindata.ailu.client.dto;

public class AccountDetailDTO {
	private int id;
	private String bizName;
	private String wechatid;
	private String logurl;

	private String izDesc;

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

	public String getLogurl() {
		return logurl;
	}

	public void setLogurl(String logurl) {
		this.logurl = logurl;
	}

	public String getIzDesc() {
		return izDesc;
	}

	public void setIzDesc(String izDesc) {
		this.izDesc = izDesc;
	}
}
