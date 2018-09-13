package com.colinwjd.venus.web.controller.api;

import com.colinwjd.venus.common.GlobalProperty;
import com.colinwjd.venus.common.enums.OptionEnum;
import com.colinwjd.venus.common.enums.PostStatusEnum;
import com.colinwjd.venus.common.enums.PostTypeEnum;
import com.colinwjd.venus.model.bo.JsonResp;
import com.colinwjd.venus.model.entity.Post;
import com.colinwjd.venus.model.vo.PostVO;
import com.colinwjd.venus.service.PostService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 文章 API
 *
 * @author Colin Wang
 * @date 2018/9/6
 */
@RestController
@RequestMapping("/api/post")
public class PostApiController {

    private final PostService postService;

    @Autowired
    public PostApiController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/page/{page}")
    public JsonResp<List<PostVO>> findByPage(@PathVariable Integer page) {
        Integer size = 10;
        if (StringUtils.isBlank(GlobalProperty.OPTIONS.get(OptionEnum.INDEX_POST_NUM.getValue()))) {
            size = Integer.parseInt(GlobalProperty.OPTIONS.get(OptionEnum.INDEX_POST_NUM.getValue()));
        }
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by(Sort.Direction.DESC, "createTime"));
        Page<Post> posts = postService.findByTypeAndStatus(PostTypeEnum.POST.getValue(), PostStatusEnum.PUBLISHED.getValue(), pageable);
        List<PostVO> result = PostVO.buildWith(posts);
        return CollectionUtils.isEmpty(result) ? JsonResp.httpStatus(HttpStatus.NO_CONTENT) : JsonResp.success(result);
    }
}
