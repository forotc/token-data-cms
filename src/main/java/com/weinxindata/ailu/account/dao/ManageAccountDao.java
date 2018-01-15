package com.weinxindata.ailu.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.weinxindata.ailu.dto.AccountListDTO;

public interface ManageAccountDao {

	List<AccountListDTO> getList(@Param("keyword") String keyword, @Param("start") int start,
			@Param("length") int length);

	int getCount(@Param("keyword") String keyword);

	void save(@Param("account") String account, @Param("type") int type);
}
