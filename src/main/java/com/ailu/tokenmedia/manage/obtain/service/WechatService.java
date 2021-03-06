package com.ailu.tokenmedia.manage.obtain.service;

import com.ailu.tokenmedia.manage.obtain.dao.WechatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author liu zhenming
 * @version V1.0
 * @date 2018/1/17
 */
@Service
public class WechatService {

	@Autowired
	WechatDao wechatDao;

	public void updataByWechatid(Map<String, Object> json) {

		wechatDao.updataByWechatid(json.get("Wechatid").toString(), json.get("BizName").toString(),
				json.get("LogoUrl").toString().replace("-BizLogoCut", ""), json.get("BizDes").toString(),
				"http://open.weixin.qq.com/qr/code?username=" + json.get("Wechatid").toString());
	}

}
