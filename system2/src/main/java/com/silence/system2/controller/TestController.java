package com.silence.system2.controller;

import com.silence.system2.feign.SystemFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * Created with IntelliJ IDEA.
 * Description:
 * User: silence
 * Date: 2019-09-23
 * Time: 上午9:14
 */
@RestController
public class TestController {


    @Autowired
    SystemFeign systemFeign;

    @GetMapping("/test2")
    public String getString(){
        return systemFeign.getString();
    }
}
