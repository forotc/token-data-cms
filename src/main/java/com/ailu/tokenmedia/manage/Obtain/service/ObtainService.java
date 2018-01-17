package com.ailu.tokenmedia.manage.Obtain.service;

import com.ailu.tokenmedia.utils.HttpclientUtils;
import com.ailu.tokenmedia.utils.ObtainUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.Executor;

/**
 * @author liu zhenming
 * @version V1.0
 * @Description: TODO
 * @date 2018/1/17
 */
@Service
public class ObtainService {

    @Autowired
    ObtainUtil obtainUtil;

    @Autowired
    Executor taskExecutor;

    ObjectMapper objectMapper;

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
            Map<String, Object> jsonStrng = objectMapper.readValue(HttpclientUtils.rawpost(obtainUtil.getDiagnosisAdd(), headers, body), Map.class);
            if (jsonStrng != null) {
                //如果返回1，就代表成功，开始访问结果接口
                if (jsonStrng.get("ResultCode").toString().equals("1")) {
                    //通过key获取结果
                    getWechatInfoResult(jsonStrng.get("RecordKey").toString(),wechatid);
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
     * @param wechatid  微信公众号id
     */
    public void getWechatInfoResult(String recordKey, String wechatid) {
        //添加传送的内容参数
        String body = obtainUtil.getDiagnosisResultParameter().replace("{0}", recordKey);
        //获得每次的验证码
        String checksum = obtainUtil.genCheckSum(body);
        //访问接口所需headers
        Map headers = obtainUtil.iniHeaders(checksum);
        objectMapper = new ObjectMapper();
        //访问接口，获得数据
        try {
            Map<String, Object> jsonStrng = objectMapper.readValue(HttpclientUtils.rawpost(obtainUtil.getDiagnosisResult(), headers, body), Map.class);
            if (jsonStrng != null) {
                //如果返回1，就代表成功，开始存储数据
                if (jsonStrng.get("ResultCode").toString().equals("1")) {
                    //更新微信表内容

                    //保存WechatInfo内容

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
