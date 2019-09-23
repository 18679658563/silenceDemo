package com.silence.system2.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/***
 * Created with IntelliJ IDEA.
 * Description:
 * User: silence
 * Date: 2019-09-23
 * Time: 上午9:11
 */
@FeignClient("system")
public interface SystemFeign {


    @GetMapping("/test")
    String getString();

}
