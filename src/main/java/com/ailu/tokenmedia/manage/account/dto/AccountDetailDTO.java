package com.ailu.tokenmedia.manage.account.dto;

public class AccountDetailDTO {
	private int id;
	private String head;
	private String qrCode;
	private String wechatId;
	private String bizName;
	private String bizDesc;
	private int fans;
	private int firstAvgRead;
	private int secondAvgRead;
	private int thirdMoreAvgRead;
	private int articleCount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public String getWechatId() {
		return wechatId;
	}

	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
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

	public int getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}

	public String getBizDesc() {
		return bizDesc;
	}

	public void setBizDesc(String bizDesc) {
		this.bizDesc = bizDesc;
	}
}
