package com.weinxindata.ailu.file.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weinxindata.ailu.file.dao.FileDao;
import com.weinxindata.ailu.file.dto.FileDTO;

@Service
public class FileService {

	@Autowired
	FileDao fileDao;

	public void saveFile(FileDTO file) {
		fileDao.saveFile(file);
	}
}
