package com.weinxindata.ailu.sign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weinxindata.ailu.common.Base;
import com.weinxindata.ailu.common.R;
import com.weinxindata.ailu.sign.dto.ManagerDTO;
import com.weinxindata.ailu.sign.service.SignService;
import com.weinxindata.ailu.utils.SecretUtil;

@Controller
@RequestMapping("manage")
public class SignController extends Base {

	@Autowired
	SignService signService;

	@RequestMapping("")
	public String showLogin() {
		return "login";
	}

	@RequestMapping("sign/login")
	@ResponseBody
	public R login(String username, String password) {
		ManagerDTO manager = signService.check(username, SecretUtil.encrypt(password));
		if (manager == null)
			return R.error(1, "用户名或密码错误！");
		addSession("manager", manager);
		return R.ok();
	}
}
