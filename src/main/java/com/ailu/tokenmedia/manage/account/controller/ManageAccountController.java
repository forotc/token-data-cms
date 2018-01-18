package com.ailu.tokenmedia.manage.account.controller;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ailu.tokenmedia.common.R;
import com.ailu.tokenmedia.manage.account.dto.AccountListDTO;
import com.ailu.tokenmedia.manage.account.service.ManageAccountService;

/**
 * 公众号管理
 * 
 * @author Michael
 *
 */
@Controller
@RequestMapping("manage/account")
public class ManageAccountController {
	@Autowired
	ManageAccountService accountService;

	/**
	 * 公众号列表
	 * 
	 * @param keyword
	 * @param iDisplayStart
	 * @param iDisplayLength
	 * @return
	 */
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

	/**
	 * 单个公众号的添加和修改
	 * 
	 * @param account
	 * @param type
	 * @return
	 */
	@RequestMapping("save")
	@ResponseBody
	public R save(String account, int type) {
		accountService.save(account, type);
		return R.ok();
	}

	@RequestMapping("del/{id}")
	@ResponseBody
	public R del(@PathVariable("id") int id) {
		accountService.del(id);
		return R.ok();
	}

	/**
	 * 公众号批量导入
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("import")
	@ResponseBody
	public R importFile(@RequestParam("file") MultipartFile file) throws Exception {

		String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
		InputStream input = file.getInputStream();
		return accountService.readExcle(input, suffix);
	}
}
