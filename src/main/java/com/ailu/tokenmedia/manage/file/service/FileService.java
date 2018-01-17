package com.ailu.tokenmedia.manage.file.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ailu.tokenmedia.manage.file.dao.FileDao;
import com.ailu.tokenmedia.manage.file.dto.FileDTO;

@Service
public class FileService {

	@Autowired
	FileDao fileDao;

	public void saveFile(FileDTO file) {
		fileDao.saveFile(file);
	}
}
