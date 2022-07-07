package com.sw.basis.utils.encrypt;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密
 * @author jixing2000
 **/
public class EncryptUtil {
	private static final String KEY_SHA = "SHA";
    private static final String KEY_MD5 = "MD5";
    private static final char[] HEX_CODE = "0123456789ABCDEF".toCharArray();
    /**
     * MAC算法可选以下多种算法 
     *
     * HmacMD5  
     * HmacSHA1  
     * HmacSHA256  
     * HmacSHA384  
     * HmacSHA512
     */
    private static final String KEY_MAC = "HmacSHA1";

    /**编码格式；默认使用uft-8*/
    public static final String CHARSET = "utf-8";
  
    /**
     * MD5加密
     * @param data 被加密的字符串
     * @return byte[] 加密后的byte
     **/
    public static String encryptMD5(String data) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance(KEY_MD5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] byteArr = null;
        try {
            if(md5 != null){
                md5.update(data.getBytes(CHARSET));
                byteArr = md5.digest();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return byteArr != null ? hex(byteArr) : "";
    }

    /**
     * byte[]转小写的十六进制字符串
     * @param arr byte[]
     *
     * @return java.lang.String
     **/
    private static String hex(byte[] arr) {
        StringBuffer sb = new StringBuffer();
        for (byte b : arr) {
            sb.append(Integer.toHexString((b & 0xFF) | 0x100), 1, 3);
        }
        return sb.toString();
    }

    /**
     * HMAC加密
     * @param data 被加密的字符串
     * @param key 密钥
     * @return 加密后的字符串
     */
    public static String encryptHMAC(String data, String key) {  
        SecretKey secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), KEY_MAC);  
        Mac mac;
		try {
			mac = Mac.getInstance(secretKey.getAlgorithm());
			mac.init(secretKey);  
		} catch (Exception e) {
			throw new RuntimeException("encrypt error", e);
		}  
		byte[] result = mac.doFinal(data.getBytes(StandardCharsets.UTF_8)); 
		return printHexBinary(result);
    }  

    /**
     * byte[]转换成大写的十六进制字符串
     * @param data byte[]
     *
     * @return java.lang.String
     **/
    public static String printHexBinary(byte[] data) {
        StringBuilder r = new StringBuilder(data.length * 2);
        for (byte b : data) {
            r.append(HEX_CODE[(b >> 4) & 0xF]);
            r.append(HEX_CODE[(b & 0xF)]);
        }
        return r.toString();
    }
}
