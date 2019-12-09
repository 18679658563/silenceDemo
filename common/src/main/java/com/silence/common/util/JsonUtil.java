package com.silence.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/***
 * Created with IntelliJ IDEA.
 * Description:
 * User: silence
 * Date: 2019-12-06
 * Time: 上午10:58
 */
public class JsonUtil {

    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * 转换成Json
     * @param object
     * @return 返回json字符串
     */
    public static String ObjectToJson(Object object){
        String res = null;
        try {
            res = mapper.writeValueAsString(object);
        } catch (IOException e) {
            System.out.println("Json转换异常");
        }
        return  res;
    }
}
