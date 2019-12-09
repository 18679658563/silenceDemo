package com.silence.system.controller;

import com.silence.common.controller.BaseController;
import com.silence.system.entity.Role;
import com.silence.system.service.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * Created with IntelliJ IDEA.
 * Description:
 * User: silence
 * Date: 2019-12-09
 * Time: 上午11:22
 */
@RequestMapping("/role")
@RestController
public class RoleController extends BaseController<RoleService, Role> {
}
