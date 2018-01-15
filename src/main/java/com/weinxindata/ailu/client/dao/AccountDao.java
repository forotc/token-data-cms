package com.weinxindata.ailu.client.dao;

import java.util.List;

import com.weinxindata.ailu.client.dto.AccountDTO;
import com.weinxindata.ailu.client.dto.AccountDetailDTO;

public interface AccountDao {
	List<AccountDTO> getAccounts();

	AccountDetailDTO getDetail(int id);
}
