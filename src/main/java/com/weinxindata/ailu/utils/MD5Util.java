package com.weinxindata.ailu.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

	/**
	 * 得到strSrc的文件MD5信息
	 */
	public static String getMD5(String strSrc) {
		MessageDigest md = null;
		byte[] bt = strSrc.getBytes();
		String strDes = null;

		try {
			md = MessageDigest.getInstance("MD5");
			md.update(bt);
			strDes = bytes2Hex(md.digest()); // to HexString
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return strDes;
	}

	/**
	 * 二行制转hex字符串
	 */
	public static String bytes2Hex(byte[] bts) {
		String des = "";
		String tmp = null;
		for (int i = 0; i < bts.length; i++) {
			tmp = (Integer.toHexString(bts[i] & 0xFF));
			if (tmp.length() == 1) {
				des += "0";
			}
			des += tmp;
		}
		return des;
	}

	/**
	 * 对byte进行md5加密
	 *
	 * @param str
	 * @return
	 */
	public static String getMD5(byte[] str) {
		try {
			// 生成一个MD5加密计算摘要
			MessageDigest md = MessageDigest.getInstance("MD5");
			// 计算md5函数
			md.update(str);
			// digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
			// BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
			return new BigInteger(1, md.digest()).toString(16);
		} catch (Exception e) {
			return "null";
		}
	}

}
