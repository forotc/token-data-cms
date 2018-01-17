package com.ailu.tokenmedia.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ailu.tokenmedia.client.dao.AccountDao;
import com.ailu.tokenmedia.client.dto.AccountDTO;
import com.ailu.tokenmedia.client.dto.AccountDetailDTO;

@Service
public class AccountService {
	@Autowired
	AccountDao accountDao;

	public List<AccountDTO> getAccounts(int start, int length) {
		return accountDao.getAccounts(start, length);
	}

	public int getCount() {
		return accountDao.getCount();
	}

	public AccountDetailDTO getDetail(int id) {
		return accountDao.getDetail(id);
	}
}
