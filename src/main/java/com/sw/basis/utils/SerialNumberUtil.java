package com.sw.basis.utils;

import com.sw.basis.utils.exception.MyException;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 自动生成编号工具类
 *
 * @Author jixing2000
 **/
@Slf4j
public class SerialNumberUtil {

    /**
     * 生成订单号
     *
     * @param strList 需要连接的字符串集合，如：项目编号+PQ
     * @param count 项目已发起的需求的总数
     * @param countDigit 编号最后的数字的位数，如：001
     * @return 订单号
     **/
    public static String createOrderId(List<String> strList, Long count, Integer countDigit){
        StringBuffer buffer = new StringBuffer();
        //参数1校验
        if(strList == null || strList.size() == 0){
            throw new MyException("连接字符串集合为空，请修改！");
        }
        for(String str : strList){
            buffer.append(str);
        }
        //参数2校验
        if(count == null){
            count = 0L;
        }
        else if(count < 0){
            throw new MyException("已发起需求数量不能小于0");
        }
        Long tempNum = count;
        //已发起需求数量的实际位数
        Integer tempCount = 0 ;
        if(tempNum == 0){
            tempCount = 1;
        }
        else {
            while(tempNum > 0){
                tempNum=tempNum / 10;
                tempCount++;
            }
        }
        //需要补零的位数
        int zeroNum = countDigit - tempCount;
        if(zeroNum < 0){
            throw new MyException("count的位数不能大于countDigit(编号最后的数字位数不能小于已发起需求数量的位数)！");
        }
        for(int i =0 ; i < zeroNum ; i++){
            buffer.append("0");
        }
        buffer.append(count);
        log.info("订单号：{}",buffer);
        return buffer.toString();
    }

}
