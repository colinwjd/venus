package com.colinwjd.venus.web.controller.admin;

import com.colinwjd.venus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户控制器
 *
 * @author Colin Wang
 * @date 2018/9/2
 */
@Slf4j
@Controller
@RequestMapping("/admin/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
}
