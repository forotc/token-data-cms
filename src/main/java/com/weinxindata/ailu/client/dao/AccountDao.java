package com.weinxindata.ailu.client.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.weinxindata.ailu.client.dto.AccountDTO;
import com.weinxindata.ailu.client.dto.AccountDetailDTO;

public interface AccountDao {
	List<AccountDTO> getAccounts(@Param("start") int start, @Param("length") int length);

	int getCount();

	AccountDetailDTO getDetail(int id);
}
