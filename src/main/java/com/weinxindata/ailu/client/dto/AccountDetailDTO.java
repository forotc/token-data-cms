package com.weinxindata.ailu.client.dto;

public class AccountDetailDTO {
	private int id;
	private String bizName;
	private String wechatid;
	private String logurl;
	private String qrcode;
	private String izDesc;

	private int fans;
	private int firstAvgRead;
	private int secondAvgRead;
	private int thirdMoreAvgRead;

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

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	public int getFans() {
		return fans;
	}

	public void setFans(int fans) {
		this.fans = fans;
	}

	public int getFirstAvgRead() {
		return firstAvgRead;
	}

	public void setFirstAvgRead(int firstAvgRead) {
		this.firstAvgRead = firstAvgRead;
	}

	public int getSecondAvgRead() {
		return secondAvgRead;
	}

	public void setSecondAvgRead(int secondAvgRead) {
		this.secondAvgRead = secondAvgRead;
	}

	public int getThirdMoreAvgRead() {
		return thirdMoreAvgRead;
	}

	public void setThirdMoreAvgRead(int thirdMoreAvgRead) {
		this.thirdMoreAvgRead = thirdMoreAvgRead;
	}
}
