package com.silence.system.service;

import com.silence.system.entity.Test;
import com.silence.system.feign.SystemFeign;
import com.silence.system.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.silence.common.service.BaseService;

/***
 * Created with IntelliJ IDEA.
 * Description:
 * User: silence
 * Date: 2019-09-24
 * Time: 上午8:57
 */
@Service
public class TestService extends BaseService<TestMapper, Test> {

    @Autowired
    private SystemFeign systemFeign;

    public String getTest(){
        systemFeign.getFeign();
        return "true";
    }

}
