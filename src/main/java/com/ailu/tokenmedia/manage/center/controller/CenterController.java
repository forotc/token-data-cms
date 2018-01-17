package com.ailu.tokenmedia.manage.center.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("manage")
public class CenterController {

	/**
	 * 后台管理中心
	 * 
	 * @return
	 */
	@RequestMapping("center")
	public String center() {
		return "manage/center";
	}

	@RequestMapping("index")
	public String index() {
		return "manage/index";
	}

	@RequestMapping("account")
	public String account() {
		return "manage/account/list";
	}

	@RequestMapping("account/add")
	public String accountAdd() {
		return "manage/account/add";
	}
}
