package com.colinwjd.venus.web.controller.api;

import com.colinwjd.venus.model.bo.JsonResp;
import com.colinwjd.venus.model.entity.User;
import com.colinwjd.venus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户 API
 *
 * @author Colin Wang
 * @date 2018/9/6
 */
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private final UserService userService;

    @Autowired
    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{name}")
    public JsonResp<User> user(@PathVariable String name) {
        User user = userService.findByName(name);
        return user == null ? JsonResp.httpStatus(HttpStatus.NOT_FOUND) : JsonResp.success(user);
    }
}
