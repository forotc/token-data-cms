package com.weinxindata.ailu.center.controller;

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
		return "center";
	}

	@RequestMapping("index")
	public String index() {
		return "index";
	}

	@RequestMapping("account")
	public String account() {
		return "account/list";
	}

	@RequestMapping("account/add")
	public String accountAdd() {
		return "account/add";
	}
}
