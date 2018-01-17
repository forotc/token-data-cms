package com.ailu.tokenmedia.manage.sign.dao;

import org.apache.ibatis.annotations.Param;

import com.ailu.tokenmedia.manage.sign.dto.ManagerDTO;

public interface SignDao {
	ManagerDTO check(@Param("username") String username, @Param("password") String password);
}
