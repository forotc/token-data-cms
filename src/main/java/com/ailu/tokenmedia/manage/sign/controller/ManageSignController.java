package com.ailu.tokenmedia.manage.sign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ailu.tokenmedia.common.Base;
import com.ailu.tokenmedia.common.R;
import com.ailu.tokenmedia.manage.sign.dto.ManagerDTO;
import com.ailu.tokenmedia.manage.sign.service.ManageSignService;
import com.ailu.tokenmedia.utils.SecretUtil;

@Controller
@RequestMapping("manage")
public class ManageSignController extends Base {

	@Autowired
	ManageSignService signService;

	@RequestMapping("")
	public String showLogin() {
		return "manage/login";
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
