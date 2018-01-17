package com.ailu.tokenmedia.manage.wechatInfo.service;

import com.ailu.tokenmedia.manage.wechatInfo.dao.WechatInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @author liu zhenming
 * @version V1.0
 * @date 2018/1/17
 */
@Service
public class WechatInfoService {

    @Autowired
    WechatInfoDao wechatInfoDao;

    public void save(Map<String, Object> json) {
        wechatInfoDao.save(json.get("Wechatid").toString(),
                Integer.parseInt(json.get("Fans").toString()),
                Integer.parseInt(json.get("FirstAvgRead").toString()),
                Integer.parseInt(json.get("SecondAvgRead").toString()),
                Integer.parseInt(json.get("ThirdMoreAvgRead").toString()),
                Integer.parseInt(json.get("ArticleCount").toString()),
                new Date()
        );
    }


}
