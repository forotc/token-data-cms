package com.ailu.tokenmedia.manage.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ailu.tokenmedia.manage.account.dto.AccountDetailDTO;
import com.ailu.tokenmedia.manage.account.dto.AccountListDTO;

public interface ManageAccountDao {

	List<AccountListDTO> getList(@Param("keyword") String keyword, @Param("start") int start,
			@Param("length") int length);

	int getCount(@Param("keyword") String keyword);

	void save(@Param("account") String account, @Param("type") int type);

	AccountDetailDTO getDetail(int id);

	void del(int id);

	List<String> getNull();

	List<String> getList4Timer(@Param("type") int type);
}
