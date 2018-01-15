package com.weinxindata.ailu.sign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weinxindata.ailu.sign.dao.SignDao;
import com.weinxindata.ailu.sign.dto.ManagerDTO;

@Service
public class SignService {
	@Autowired
	SignDao signDao;

	public ManagerDTO check(String username, String password) {
		return signDao.check(username, password);
	}
}
