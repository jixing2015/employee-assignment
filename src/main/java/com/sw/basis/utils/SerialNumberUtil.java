package com.sw.basis.utils;

import com.sw.basis.utils.constant.RedisConstant;
import com.sw.basis.utils.exception.MyException;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 自动生成编号工具类
 *
 * @Author jixing2000
 **/
@Slf4j
public class SerialNumberUtil {

    public static RedisTemplateUtils redisUtils = SpringUtil.getBean("redisTemplateUtils");

    /**
     * 生成订单号 公共方法
     *
     * @param strList 需要连接的字符串集合，如：项目编号+PQ
     * @param count 项目已发起的需求的总数
     * @param countDigit 编号最后的数字的位数，如：001
     * @return 订单号
     **/
    public static String createNumber(List<String> strList, Long count, Integer countDigit){
        StringBuffer buffer = new StringBuffer();
        //参数1校验
        if(strList == null || strList.size() == 0){
            log.error("连接字符串集合为空，请修改！");
            throw new MyException("创建订单号失败！");
        }
        for(String str : strList){
            buffer.append(str);
        }
        //参数2校验
        if(count == null){
            count = 0L;
        }
        else if(count < 0){
            log.error("已发起需求数量不能小于0");
            throw new MyException("创建订单号失败！");
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
            log.error("count的位数不能大于countDigit(编号最后的数字位数不能小于已发起需求数量的位数)！");
            throw new MyException("创建订单号失败！");
        }
        for(int i =0 ; i < zeroNum ; i++){
            buffer.append("0");
        }
        buffer.append(count);
        log.info("订单号：{}",buffer);
        return buffer.toString();
    }

    /**
     * 创建订单号
     * 生成规则：PQ+yymmdd+四位流水号
     *
     * @return 订单号
     **/
    public static String createOrderId() {
        List<String> strList = new ArrayList<>();
        strList.add("PQ");
        //当前日期YYMMDD
        String today = DateUtils.getDateStryyyyMMdd();
        strList.add(today);
        long count = redisUtils.hincr(RedisConstant.ORDER_ID_SEQ,today,RedisConstant.APPLY_ID_BY);
        Integer countDigit = 4;
        String orderId = createNumber(strList,count,countDigit);
        return orderId;
    }

    /**
     * 创建岗位编号
     * 生成规则：审计：AU+4位流水号 造价：MC+4位流水号 税务：TA+4位流水号 咨询：CS+4位流水号
     *
     * @return java.lang.String
     **/
    public static String createRoleCode(){
        //当前人板块
        String plageCode = "";
        String plageRedis = "";
        if(LocalUserUtil.getCurrentUser() != null){
            plageRedis = LocalUserUtil.getCurrentUser().getPlageCode();
            //审计
            if("1".equals(LocalUserUtil.getCurrentUser().getPlageCode())){
                plageCode="AU";
            }
            //造价
            else if("2".equals(LocalUserUtil.getCurrentUser().getPlageCode())){
                plageCode="MC";
            }
            //税务
            else if("3".equals(LocalUserUtil.getCurrentUser().getPlageCode())){
                plageCode="TA";
            }
            //咨询
            else if("4".equals(LocalUserUtil.getCurrentUser().getPlageCode())){
                plageCode="CS";
            }
            else{
                plageRedis = "test";
                plageCode="TEST";
            }
        }
        else{
            plageRedis = "test";
            plageCode="TEST";
        }

        List<String> strList = new ArrayList<>();
        strList.add(plageCode);
        long count = redisUtils.hincr(RedisConstant.ORDER_ID_SEQ,plageRedis,RedisConstant.APPLY_ID_BY);
        Integer countDigit = 4;
        String roleCode = createNumber(strList,count,countDigit);
        return roleCode;
    }
}
