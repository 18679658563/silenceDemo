package com.silence.system.controller;

import com.silence.common.controller.BaseController;
import com.silence.system.entity.User;
import com.silence.system.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * Created with IntelliJ IDEA.
 * Description:
 * User: silence
 * Date: 2019-12-06
 * Time: 下午3:48
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController<UserService, User> {
}
