package com.weinxindata.ailu.client.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weinxindata.ailu.client.dto.AccountDTO;
import com.weinxindata.ailu.client.service.AccountService;

@Controller
public class HomeController {
	@Autowired
	AccountService accountService;

	@RequestMapping("")
	public String home(Model model) {
		List<AccountDTO> list = accountService.getAccounts();
		model.addAttribute("accounts", list);
		return "client/index";
	}

}
