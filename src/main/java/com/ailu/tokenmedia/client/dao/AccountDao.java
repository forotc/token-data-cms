package com.ailu.tokenmedia.client.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ailu.tokenmedia.client.dto.AccountDTO;
import com.ailu.tokenmedia.client.dto.AccountDetailDTO;

public interface AccountDao {
	List<AccountDTO> getAccounts(@Param("start") int start, @Param("length") int length);

	int getCount();

	AccountDetailDTO getDetail(int id);
}
