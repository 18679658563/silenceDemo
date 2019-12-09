package com.silence.common.util;

import javax.servlet.http.HttpServletRequest;

/***
 * Created with IntelliJ IDEA.
 * Description: 获取客户端真实ip
 * User: silence
 * Date: 2019-12-06
 * Time: 上午10:05
 */
public class CLientUtil {

    public static String getClientIp(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if (ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip))
            ip = request.getHeader("Proxy-Client-IP");
        if (ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip))
            ip = request.getHeader("RIPED-Proxy-Client-IP");
        if (ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip))
            ip = request.getRemoteAddr();
        return ip;
    }
}
