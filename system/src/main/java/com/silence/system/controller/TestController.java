package com.silence.system.controller;

import com.silence.system.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * Created with IntelliJ IDEA.
 * Description:
 * User: silence
 * Date: 2019-09-18
 * Time: 下午3:45
 */
@RestController
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/test")
    public String getString(){
        return "2";
    }

    @GetMapping("/testFeign")
    public String getTest(){
        return testService.getTest();
    }

}
