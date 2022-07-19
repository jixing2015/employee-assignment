package com.sw.basis.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP地址相关工具类
 * @author jixing2000
 */
public class IpUtil {

    private static final Log logger = LogFactory.getLog(IpUtil.class);

    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress;
        try {
            String unknownStr = "unknown";
            ipAddress = request.getHeader("x-forwarded-for");
            if (ipAddress == null || ipAddress.length() == 0 || unknownStr.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || unknownStr.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || unknownStr.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                String localIpStr =  "127.0.0.1";
                if (localIpStr.equals(ipAddress)) {
                    // 根据网卡取本机配置的IP
                    InetAddress inet = null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {
                        logger.error(e.getMessage(), e);
                    }
                    ipAddress = inet.getHostAddress();
                }
            }
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            String commaStr = ",";
            if (StringUtils.isNotBlank(ipAddress) && ipAddress.contains(commaStr)) {
                String[] ips = ipAddress.split(commaStr);
                ipAddress = ips[0].trim();
            }
        } catch (Exception e) {
            ipAddress = "";
        }

        return ipAddress;
    }
}
