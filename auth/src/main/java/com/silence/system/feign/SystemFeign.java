package com.silence.system.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/***
 * Created with IntelliJ IDEA.
 * Description: 在FeignClient注解中添加fallback，指定Hystrix熔断异常回调类
 * User: silence
 * Date: 2019-09-24
 * Time: 上午8:56
 */
@FeignClient(name = "system2", fallback = TestClientFallback.class)
public interface SystemFeign {

    @GetMapping("/feign")
    String getFeign();


}
