package com.silence.system.feign;


import org.springframework.stereotype.Component;

/***
 * Created with IntelliJ IDEA.
 * Description: 当HelloService中的Feign调用失败或超时时，会调用该实现类的方法
 *              需要注意的是fallback指定的类一定要添加@Component将其加入到Spring容器
 * User: silence
 * Date: 2019-09-24
 * Time: 下午3:37
 */
@Component
public class TestClientFallback implements SystemFeign {

    @Override
    public String getFeign() {
        System.out.println("false");
        return "false";
    }
}
