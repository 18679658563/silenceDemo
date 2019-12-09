package com.silence.system.service;

import com.silence.common.service.BaseService;
import com.silence.system.entity.Menu;
import com.silence.system.mapper.MenuMapper;
import com.silence.system.mapper.RoleMapper;
import com.silence.system.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * Created with IntelliJ IDEA.
 * Description:
 * User: silence
 * Date: 2019-12-09
 * Time: 上午11:17
 */
@Service
public class MenuService extends BaseService<MenuMapper, Menu> {

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    UserMapper userMapper;

}
