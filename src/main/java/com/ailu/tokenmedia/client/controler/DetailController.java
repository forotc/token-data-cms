package com.ailu.tokenmedia.client.controler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ailu.tokenmedia.client.dto.AccountDTO;
import com.ailu.tokenmedia.client.dto.AccountDetailDTO;
import com.ailu.tokenmedia.client.service.AccountService;
import com.ailu.tokenmedia.common.Base;
import com.ailu.tokenmedia.common.R;

@Controller
public class DetailController extends Base {
	@Autowired
	AccountService accountService;

	@RequestMapping("top")
	public String top() {
		return "client/top_detail";
	}

	@RequestMapping("top/en")
	public String topEn() {
		return "client_en/top_detail";
	}

	@RequestMapping("detail/{id}")
	public String detail(@PathVariable("id") int id, Model model) {
		AccountDetailDTO accountDetail = accountService.getDetail(id);
		model.addAttribute("detail", accountDetail);
		return "client/wx_official_detail";
	}

	@RequestMapping("detail/en/{id}")
	public String detailEn(@PathVariable("id") int id, Model model) {
		AccountDetailDTO accountDetail = accountService.getDetail(id);
		model.addAttribute("detail", accountDetail);
		return "client_en/wx_official_detail";
	}

	@RequestMapping("list/{page}")
	@ResponseBody
	public R list(@PathVariable("page") int page) {
		List<AccountDTO> list = accountService.getAccounts((page - 1) * 10, 10);
		int count = accountService.getCount();
		Map<String, Object> map = new HashMap<>();
		map.put("currPage", page);
		map.put("count", count);
		map.put("pageCount", page(count, 10));
		R r = new R();
		r.putAll(map);
		r.put("data", list);
		return r;
	}
}
