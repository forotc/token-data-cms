package com.weinxindata.ailu.center.controller;

import com.weinxindata.ailu.utils.MD5Util;
import org.springframework.beans.factory.annotation.Value;

import java.io.UnsupportedEncodingException;

/**
 * @Version 1.0
 * @Since JDK1.8
 * @Author liuzhenming
 * @Company 河南艾鹿
 * @Date 2018/1/14 0009 9:50
 */
public class BaseController {

    @Value("${account.formal.userid}")
    public static String getAccount_userid;

    @Value("${account.formal.key}")
    public static String getAccount_key;

    /**
     *
     * 使用密钥和Http-Body中的内容进行UTF-8编码生成字节流，
     * 然后对字节流进行MD5加密生成字节流，将字节流转换成字符串，
     * 并将’-’字符替换成空字符，
     * 最后截取从字符串14位开始截取4个字符转小写后作为检验码。
     *
     * @param body   body就是Http Request Body 中的内容
     * @return 4位的校验码
     */
    public String genCheckSum(String body) {
        String key = body + BaseController.getAccount_key;
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


}
