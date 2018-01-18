package com.ailu.tokenmedia.manage.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ailu.tokenmedia.manage.account.service.ManageAccountService;
import com.ailu.tokenmedia.manage.obtain.service.ObtainService;

@Component
public class PullDataSchedule {
	@Autowired
	ManageAccountService manageAccountService;
	@Autowired
	ObtainService obtainService;

	private void pull4Null() {
		List<String> list = manageAccountService.getNull();
		obtainService.saveWechatInfo(list);
	}

	private void pull4Week() {
		List<String> list1 = manageAccountService.getList4Timer(1);
		if (list1 != null && list1.size() != 0)
			obtainService.saveWechatInfo(list1);

		List<String> list2 = manageAccountService.getList4Timer(2);
		if (list2 != null && list2.size() != 0)
			obtainService.saveWechatInfo(list2);

		List<String> list3 = manageAccountService.getList4Timer(3);
		if (list3 != null && list3.size() != 0)
			obtainService.saveWechatInfo(list3);
	}

	/**
	 * 每天零点执行
	 */
	@Scheduled(cron = "0 0 0 * * ? ")
	private void dayPull() {
		pull4Null();
	}

	/**
	 * 每周一 0点0分0秒 执行
	 */
	@Scheduled(cron = "0 0 0 ? * MON ")
	private void overdue() {
		pull4Week();
	}

}