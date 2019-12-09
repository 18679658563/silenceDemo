package com.silence.common.util;

import java.util.UUID;

/***
 * Created with IntelliJ IDEA.
 * Description:
 * User: silence
 * Date: 2019-12-06
 * Time: 上午9:09
 */
public class UUIDUtil {

    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

}
