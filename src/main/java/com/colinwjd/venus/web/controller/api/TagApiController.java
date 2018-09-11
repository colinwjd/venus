package com.colinwjd.venus.web.controller.api;

import com.colinwjd.venus.model.bo.JsonResp;
import com.colinwjd.venus.model.vo.TagVO;
import com.colinwjd.venus.service.TagService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 标签 API
 *
 * @author Colin Wang
 * @date 2018/9/6
 */
@RestController
@RequestMapping("/api/tag")
public class TagApiController {

    private final TagService tagService;

    @Autowired
    public TagApiController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/all")
    public JsonResp<List<TagVO>> findAll() {
        List<TagVO> tags = TagVO.buildWith(tagService.findAll());
        return CollectionUtils.isEmpty(tags) ? JsonResp.httpStatus(HttpStatus.NO_CONTENT) : JsonResp.success(tags);
    }

    @GetMapping("/{url}")
    public JsonResp<TagVO> findByUrl(@PathVariable String url) {
        TagVO tag = TagVO.buildWith(tagService.findByUrl(url));
        return tag == null ? JsonResp.httpStatus(HttpStatus.NOT_FOUND) : JsonResp.success(tag);
    }
}
