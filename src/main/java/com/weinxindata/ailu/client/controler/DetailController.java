package com.weinxindata.ailu.client.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weinxindata.ailu.client.dto.AccountDTO;
import com.weinxindata.ailu.client.dto.AccountDetailDTO;
import com.weinxindata.ailu.client.service.AccountService;

@Controller
public class DetailController {
	@Autowired
	AccountService accountService;

	@RequestMapping("showDetails")
	public String showDetails(Model model) {
		List<AccountDTO> list = accountService.getAccounts();
		model.addAttribute("accountList", list);
		return "client/top_detail";
	}

	@RequestMapping("detail/{id}")
	public String detail(@PathVariable("id") int id, Model model) {
		AccountDetailDTO accountDetail = accountService.getDetail(id);
		model.addAttribute("detail", accountDetail);
		return "client/wx_official_detail";
	}
}
