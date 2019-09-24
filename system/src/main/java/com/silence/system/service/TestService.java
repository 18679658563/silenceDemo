package com.silence.system.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.silence.system.feign.SystemFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * Created with IntelliJ IDEA.
 * Description:
 * User: silence
 * Date: 2019-09-24
 * Time: 上午8:57
 */
@Service
public class TestService {

    @Autowired
    private SystemFeign systemFeign;

    @HystrixCommand(fallbackMethod = "fallback")
    public String getTest(){
        systemFeign.getFeign();
        return "true";
    }

    public String fallback(){
        return "false";
    }

}
