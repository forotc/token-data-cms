package com.weinxindata.ailu.sign.dao;

import org.apache.ibatis.annotations.Param;

import com.weinxindata.ailu.sign.dto.ManagerDTO;

public interface SignDao {
	ManagerDTO check(@Param("username") String username, @Param("password") String password);
}
