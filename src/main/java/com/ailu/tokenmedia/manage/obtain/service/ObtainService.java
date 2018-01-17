package com.ailu.tokenmedia.manage.obtain.service;

import com.ailu.tokenmedia.utils.HttpclientUtils;
import com.ailu.tokenmedia.utils.ObtainUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/**
 * @author liu zhenming
 * @version V1.0
 * @date 2018/1/17
 */
@Service
public class ObtainService {

    @Autowired
    ObtainUtil obtainUtil;

    @Autowired
    Executor taskExecutor;

    @Autowired
    WechatService wechatService;

    @Autowired
    WechatInfoService wechatInfoService;

    private ObjectMapper objectMapper;

    /**
     * 通过微信公众号id列表  更新Wechat信息 和 添加WechatInfo
     *
     * @param wechatidList 微信公众号id列表
     */
    public void saveWechatInfo(List<String> wechatidList) {
        for (String wechatid : wechatidList) {
            ascynWechatId(wechatid);
        }
    }

    /**
     * 通过微信公共号id获取访问诊断结果接口所需要的key，并直接获取诊断结果
     *
     * @param wechatid 微信公众号id
     */
    public void getWechatInfoKey(String wechatid) {

        //添加传送的内容参数
        String body = obtainUtil.getDiagnosisAddParameter().replace("{0}", wechatid);
        //获得每次的验证码
        String checksum = obtainUtil.genCheckSum(body);
        //访问接口所需headers
        Map headers = obtainUtil.iniHeaders(checksum);
        //访问接口，获得数据
        try {
            //获得访问诊断接口所需key
            objectMapper = new ObjectMapper();
            Map<String, Object> json = objectMapper.readValue(HttpclientUtils.rawpost(obtainUtil.getDiagnosisAdd(), headers, body), Map.class);
            if (json != null) {
                //如果返回1，就代表成功，开始访问结果接口
                if (json.get("ResultCode").toString().equals("1")) {
                    //通过key获取结果
                    getWechatInfoResult(json.get("RecordKey").toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取诊断结果
     *
     * @param recordKey 获取诊断结果所需key
     */
    public void getWechatInfoResult(String recordKey) {
        //添加传送的内容参数
        String body = obtainUtil.getDiagnosisResultParameter().replace("{0}", recordKey);
        //获得每次的验证码
        String checksum = obtainUtil.genCheckSum(body);
        //访问接口所需headers
        Map headers = obtainUtil.iniHeaders(checksum);
        objectMapper = new ObjectMapper();
        //访问接口，获得数据
        try {
            Map<String, Object> json = objectMapper.readValue(HttpclientUtils.rawpost(obtainUtil.getDiagnosisResult(), headers, body), Map.class);
            if (json != null) {
                //如果返回1，就代表成功，开始存储数据
                if (json.get("ResultCode").toString().equals("1")) {
                    //更新微信表内容
                    wechatService.updataByWechatid(json);
                    //保存WechatInfo内容
                    wechatInfoService.save(json);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 使用线程池调用接口
     *
     * @param id 微信公众号id
     */
    private void ascynWechatId(String id) {
        taskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                // 执行相关任务方法
                getWechatInfoKey(id);
            }
        });
    }


}
