package com.colinwjd.venus.web.controller.api;

import com.colinwjd.venus.common.GlobalProperty;
import com.colinwjd.venus.common.enums.OptionEnum;
import com.colinwjd.venus.common.enums.PostStatusEnum;
import com.colinwjd.venus.common.enums.PostTypeEnum;
import com.colinwjd.venus.model.bo.JsonResp;
import com.colinwjd.venus.model.entity.Post;
import com.colinwjd.venus.model.vo.ArchiveVO;
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
        Integer size = GlobalProperty.DEFAULT_INDEX_POST_NUM;
        if (StringUtils.isNotBlank(GlobalProperty.OPTIONS.get(OptionEnum.INDEX_POST_NUM.getValue()))) {
            size = Integer.parseInt(GlobalProperty.OPTIONS.get(OptionEnum.INDEX_POST_NUM.getValue()));
        }
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by(Sort.Direction.DESC, "createTime"));
        Page<Post> posts = postService.findByTypeAndStatus(PostTypeEnum.POST.getValue(), PostStatusEnum.PUBLISHED.getValue(), pageable);
        List<PostVO> result = PostVO.buildWith(posts);
        return CollectionUtils.isEmpty(result) ? JsonResp.httpStatus(HttpStatus.NO_CONTENT) : JsonResp.success(result);
    }

    @GetMapping("/popular")
    public JsonResp<List<PostVO>> popularPost() {
        List<PostVO> posts = PostVO.buildWith(postService.popularPost());
        return CollectionUtils.isEmpty(posts) ? JsonResp.httpStatus(HttpStatus.NO_CONTENT) : JsonResp.success(posts);
    }

    @GetMapping("/{id}")
    public JsonResp<PostVO> findById(@PathVariable Long id) {
        PostVO post = PostVO.buildWith(postService.findByIdAndType(id, PostTypeEnum.POST.getValue()));
        return post == null ? JsonResp.httpStatus(HttpStatus.NOT_FOUND) : JsonResp.success(post);
    }

    @GetMapping("/latest/{n}")
    public JsonResp<List<PostVO>> findLatestN(@PathVariable Integer n) {
        List<PostVO> posts = PostVO.buildWith(postService.findLatestN(n));
        return CollectionUtils.isEmpty(posts) ? JsonResp.httpStatus(HttpStatus.NO_CONTENT) : JsonResp.success(posts);
    }

    @GetMapping("/archive/year")
    public JsonResp<List<ArchiveVO>> archiveByYear() {
        List<ArchiveVO> archives = ArchiveVO.buildWith(postService.archiveByYear());
        return CollectionUtils.isEmpty(archives) ? JsonResp.httpStatus(HttpStatus.NO_CONTENT) : JsonResp.success(archives);
    }

    @GetMapping("/archive/year/month")
    public JsonResp<List<ArchiveVO>> archiveByYearAndMonth() {
        List<ArchiveVO> archives = ArchiveVO.buildWith(postService.archiveByYearAndMonth());
        return CollectionUtils.isEmpty(archives) ? JsonResp.httpStatus(HttpStatus.NO_CONTENT) : JsonResp.success(archives);
    }
}
