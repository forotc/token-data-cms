package com.ailu.tokenmedia.client.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ailu.tokenmedia.client.dto.AccountDTO;
import com.ailu.tokenmedia.client.service.AccountService;

@Controller
public class HomeController {
	@Autowired
	AccountService accountService;

	@RequestMapping("")
	public String home(Model model) {
		List<AccountDTO> list = accountService.getAccounts(0, 30);
		model.addAttribute("accounts", list);
		return "client/index";
	}

	@RequestMapping("home/en")
	public String homeEn(Model model){
		List<AccountDTO> list = accountService.getAccounts(0, 30);
		model.addAttribute("accounts", list);
		return "client_en/index";
	}

}
