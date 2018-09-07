package com.colinwjd.venus.web.controller.api;

import com.colinwjd.venus.common.enums.PostTypeEnum;
import com.colinwjd.venus.model.bo.JsonResp;
import com.colinwjd.venus.model.entity.Post;
import com.colinwjd.venus.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 页面 API
 *
 * @author Colin Wang
 * @date 2018/9/6
 */
@RestController
@RequestMapping("/api/page")
public class PageApiController {

    private final PostService postService;

    @Autowired
    public PageApiController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{id}")
    public JsonResp<Post> findPageById(Long id) {
        Post post = postService.findByIdAndType(id, PostTypeEnum.PAGE.getValue());
        return post == null ? JsonResp.httpStatus(HttpStatus.NOT_FOUND) : JsonResp.success(post);
    }
}
