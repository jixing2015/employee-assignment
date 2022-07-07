package com.sw.basis.utils.encrypt;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Base64工具类
 * @author jixing2000
 **/
public class Base64Util {

	/**编码格式；默认使用uft-8*/
	public static final String CHARSET = "UTF-8";

	/**
	 * 加密字符串
	 * @param data 需要加密的字符串
	 *
	 * @return 加密后的字符串
	 **/
	public static String encode(String data) {
		byte[] textByte = new byte[0];
		try {
			textByte = data.getBytes(CHARSET);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String encodedText = Base64.getEncoder().encodeToString(textByte);
		return encodedText;
	}

	/**
	 * 加密byte为String
	 * @param b 需要加密的内容
	 *
	 * @return java.lang.String
	 **/
	public static String encodeByteToStr(byte[] b) {
		if (b != null) {
			return Base64.getEncoder().encodeToString(b);
		}
		
		return null;
	}

	/**
	 * 解密字符串为byte
	 * @param data 需要解密的内容
	 *
	 * @return byte[]
	 **/
	public static byte[] decodeStrToByte(String data) {
		if (data != null) {
			return Base64.getDecoder().decode(data);
		}
		return null;
	}

	/**
	 * 解密byte
	 * @param bytes
	 *
	 * @return byte[]
	 **/
	public static byte[] decode(byte[] bytes) {
		if (bytes != null) {
			return Base64.getDecoder().decode(bytes);
		}
		return null;
	}

	/**
	 * 解密字符串
	 * @param encodedText 加密后的字符串
	 *
	 * @return 解密后的字符串
	 **/
	public static String decode(String encodedText) {
		String text = null;
		try {
			text = new String(Base64.getDecoder().decode(encodedText), CHARSET);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return text;
	}
}
