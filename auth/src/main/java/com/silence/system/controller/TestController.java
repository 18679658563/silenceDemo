package com.silence.system.controller;

import com.silence.common.util.DateUtil;
import com.silence.system.entity.Test;
import com.silence.system.service.TestService;
import com.silence.common.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.silence.common.util.JedisUtil;

import java.util.Date;

/***
 * Created with IntelliJ IDEA.
 * Description:
 * User: silence
 * Date: 2019-09-18
 * Time: 下午3:45
 */
@RestController
public class TestController extends BaseController<TestService, Test> {

    @Autowired
    TestService testService;

    @Autowired
    private JedisUtil jedisUtil;

    @GetMapping("/test1")
    public Boolean test(){
        boolean flag = jedisUtil.set("test","test");
        System.out.println(DateUtil.formatYD(new Date()));
        return true;
    }

    @GetMapping("/test")
    public String getString(){
        return "2";
    }

    @GetMapping("/testFeign")
    public String getTest(){
        return testService.getTest();
    }

}
