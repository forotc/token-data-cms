package com.ailu.tokenmedia.manage.schedule;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ailu.tokenmedia.manage.account.service.ManageAccountService;
import com.ailu.tokenmedia.manage.obtain.service.ObtainService;

@Component
public class PullData {
	private final static Logger log = LoggerFactory.getLogger(PullData.class);
	@Autowired
	ManageAccountService manageAccountService;
	@Autowired
	ObtainService obtainService;

	public void pull() {
		List<String> list = manageAccountService.getNull();
		obtainService.saveWechatInfo(list);
	}

	@Scheduled(cron = "0 0 0 * * ? ")
	private void dayPull() {
		log.debug(".......pull start");
		pull();
		log.debug("pull end.........");
	}

	// 每周一 0点0分0秒 执行
	/*
	 * @Scheduled(cron = "0 0 0 ? * MON ") private void overdue() {
	 * log.debug(".......start"); // TODO log.debug(" end........."); }
	 */
}