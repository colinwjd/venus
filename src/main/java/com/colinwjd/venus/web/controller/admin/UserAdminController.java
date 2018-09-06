package com.colinwjd.venus.web.controller.admin;

import com.colinwjd.venus.model.bo.JsonResp;
import com.colinwjd.venus.model.entity.User;
import com.colinwjd.venus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户管理控制器
 *
 * @author Colin Wang
 * @date 2018/9/2
 */
@Slf4j
@Controller
@RequestMapping("/admin/user")
public class UserAdminController {

    private final UserService userService;

    @Autowired
    public UserAdminController(UserService userService) {
        this.userService = userService;
    }

    @Secured({"ROOT", "ADMIN"})
    @PostMapping("update")
    @ResponseBody
    public JsonResp<User> update(User user) {
        try {
            User newUser = userService.saveByUser(user);
            return JsonResp.success(newUser);
        } catch (Exception e) {
            // TODO fail
            return JsonResp.success();
        }
    }
}
