package com.silence.system.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/***
 * Created with IntelliJ IDEA.
 * Description:
 * User: silence
 * Date: 2019-09-24
 * Time: 上午8:56
 */
@FeignClient("system2")
public interface SystemFeign {

    @GetMapping("/feign")
    String getFeign();


}
