package com.ailu.tokenmedia.manage.sign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ailu.tokenmedia.manage.sign.dao.SignDao;
import com.ailu.tokenmedia.manage.sign.dto.ManagerDTO;

@Service
public class ManageSignService {
	@Autowired
	SignDao signDao;

	public ManagerDTO check(String username, String password) {
		return signDao.check(username, password);
	}
}
