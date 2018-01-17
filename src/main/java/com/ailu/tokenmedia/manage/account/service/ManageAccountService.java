package com.ailu.tokenmedia.manage.account.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ailu.tokenmedia.common.R;
import com.ailu.tokenmedia.manage.account.dao.ManageAccountDao;
import com.ailu.tokenmedia.manage.account.dto.AccountListDTO;
import com.ailu.tokenmedia.manage.obtain.service.ObtainService;

@Service
public class ManageAccountService {

	@Autowired
	ManageAccountDao accountDao;
	@Autowired
	ObtainService obtainService;

	public List<AccountListDTO> getList(String keyword, int start, int length) {
		return accountDao.getList(keyword, start, length);
	}

	public int getCount(String keyword) {
		return accountDao.getCount(keyword);
	}

	public void save(String account, int type) {
		accountDao.save(account, type);
		List<String> list = new ArrayList<>();
		list.add(account);
		obtainService.saveWechatInfo(list);
	}

	public R readExcle(InputStream input, String suffix) throws IOException {
		Workbook wb = null;
		if ("xls".equals(suffix)) {
			wb = new HSSFWorkbook(input);
		} else if ("xlsx".equals(suffix)) {
			wb = new XSSFWorkbook(input);
		}

		Sheet sheet = wb.getSheetAt(0);
		int rowNum = sheet.getLastRowNum();
		List<String> list = new ArrayList<String>();

		for (int i = 1; i <= rowNum; i++) {
			Row row = sheet.getRow(i);
			if (row != null) {
				if ("".equals(row.getCell(0).toString().trim()))
					return R.error("第" + row + "行，第1列");
				if ("".equals(row.getCell(1).toString().trim()))
					return R.error("第" + row + "行，第2列");
				else {
					String account = row.getCell(0).toString().trim();
					int type = 0;
					switch (row.getCell(1).toString().trim()) {
					case "A":
						type = 1;
						break;
					case "B":
						type = 2;
						break;
					case "C":
						type = 3;
						break;
					}
					accountDao.save(account, type);
					list.add(account);
				}
				input.close();
			}
		}
		obtainService.saveWechatInfo(list);
		return R.ok("导入成功");
	}
}