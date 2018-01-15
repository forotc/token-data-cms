package com.weinxindata.ailu.file.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.weinxindata.ailu.common.R;
import com.weinxindata.ailu.file.dto.FileDTO;
import com.weinxindata.ailu.file.service.FileService;
import com.weinxindata.ailu.utils.DateUtil;

@Controller
public class FileController {
	@Autowired
	FileService fileService;

	/**
	 * 文件上传
	 * 
	 * @param file
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("file/upload")
	@ResponseBody
	public R uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
		if (!file.isEmpty()) {
			String originalName = file.getOriginalFilename();
			String fileName = DateUtil.format(new Date(), DateUtil.DATE_TIME_ALL_PATTERN)
					+ originalName.substring(originalName.lastIndexOf("."));
			String path = request.getSession().getServletContext().getRealPath("/");
			File dir = new File(path + "upload");
			if (!dir.exists())
				dir.mkdirs();
			String filePath = request.getSession().getServletContext().getRealPath("upload/") + "/" + fileName;
			try {
				file.transferTo(new File(filePath));
				// file.transferTo(new File(path + fileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
			return saveFile(originalName, fileName);
		}
		return R.error(200, "请上传有效的文件");
	}

	public R saveFile(String name, String fileName) {
		FileDTO file = new FileDTO();
		file.setPath("upload/" + fileName);
		file.setName(name);
		fileService.saveFile(file);
		return R.ok().put("file", file);
	}

}
