package com.ailu.tokenmedia.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author liu zhenming
 * @version V1.0
 * @Description: TODO
 * @date 2018/1/17
 * */
@Configuration
public class ObtainUtil {


    @Value("${account.formal.userid}")
    public String accountUserid;

    @Value("${account.formal.key}")
    public String accountKey;

    @Value("${diagnosis.add}")
    public String diagnosisAdd;

    @Value("${diagnosis.add.parameter}")
    public String diagnosisAddParameter;

    @Value("${diagnosis.getResult}")
    public String diagnosisResult;

    @Value("${diagnosis.getResult.parameter}")
    public String diagnosisResultParameter;

    @Value("${article.gethistory}")
    public String articleHistory;

    @Value("${article.gethistory.parameter}")
    public String articleHistoryParameter;

    @Value("${myheaders.Content-Type}")
    public String myHeadersContent;

    @Value("${myheaders.Host}")
    public String myHeadersHost;


    /**
     * 使用密钥和Http-Body中的内容进行UTF-8编码生成字节流，
     * 然后对字节流进行MD5加密生成字节流，将字节流转换成字符串，
     * 并将’-’字符替换成空字符，
     * 最后截取从字符串14位开始截取4个字符转小写后作为检验码。
     *
     * @param body body就是Http Request Body 中的内容
     * @return 4位的校验码
     */
    public String genCheckSum(String body) {
        String key = body + accountKey;
        try {
            String strRead = MD5Util.getMD5(key.getBytes("utf-8"));
            String count = strRead;
            count = count.replace("-", "");
            return count.substring(14, 18);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 初始化访问Headers
     *
     * @param checksum 验证码
     * @return
     */
    public Map iniHeaders(String checksum) {
        Map<String, Object> headers = new Hashtable<>();
        headers.put("Content-Type", myHeadersContent);
        headers.put("Host", myHeadersHost);
        headers.put("Userid", accountUserid);
        headers.put("CheckSum", checksum);
        return headers;
    }


    public String getAccountUserid() {
        return accountUserid;
    }

    public String getAccountKey() {
        return accountKey;
    }

    public String getDiagnosisAdd() {
        return diagnosisAdd;
    }

    public String getDiagnosisAddParameter() {
        return diagnosisAddParameter;
    }

    public String getDiagnosisResult() {
        return diagnosisResult;
    }

    public String getDiagnosisResultParameter() {
        return diagnosisResultParameter;
    }

    public String getArticleHistory() {
        return articleHistory;
    }

    public String getArticleHistoryParameter() {
        return articleHistoryParameter;
    }

    public String getMyHeadersContent() {
        return myHeadersContent;
    }

    public String getMyHeadersHost() {
        return myHeadersHost;
    }
}