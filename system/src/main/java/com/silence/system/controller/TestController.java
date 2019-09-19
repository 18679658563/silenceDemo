package com.silence.system.controller;

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


    @GetMapping("/test")
    public String getString(){
        return "2";
    }

}
