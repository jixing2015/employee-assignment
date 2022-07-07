package com.sw.basis.utils;

import java.util.Random;

/**
 * @Description
 * @Author jixing2000
 * @Date 2022/3/22 0022 17:22:58
 **/
public class MyRandomUtil {

    /**
     * 随机生成指定长度的字母、数字的字符串
     * @param length 长度
     * @return 随机字符
     **/
    public static String getRandomStr(int length) {
        String val = "";
        Random random = new Random();
        //参数length，表示生成几位随机数
        for(int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if("char".equalsIgnoreCase(charOrNum)){
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            }else if("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }
}
