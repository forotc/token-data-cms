package com.weinxindata.ailu.account.controller;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.weinxindata.ailu.account.service.ManageAccountService;
import com.weinxindata.ailu.common.R;
import com.weinxindata.ailu.dto.AccountListDTO;

@Controller
@RequestMapping("manage/account")
public class ManagerAccountController {
	@Autowired
	ManageAccountService accountService;

	@RequestMapping("getList")
	@ResponseBody
	public Map<String, Object> getList(String keyword, int iDisplayStart, int iDisplayLength) {
		List<AccountListDTO> list = accountService.getList(keyword, iDisplayStart, iDisplayLength);
		int size = accountService.getCount(keyword);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("iTotalRecords", size);
		map.put("iTotalDisplayRecords", size);
		map.put("aaData", list);
		return map;
	}

	@RequestMapping("save")
	@ResponseBody
	public R save(String account, int type) {
		accountService.save(account, type);
		return R.ok();
	}

	@RequestMapping("import")
	@ResponseBody
	public R importFile(@RequestParam("file") MultipartFile file) throws Exception {

		String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
		InputStream input = file.getInputStream();
		return accountService.readExcle(input, suffix);
	}
}
