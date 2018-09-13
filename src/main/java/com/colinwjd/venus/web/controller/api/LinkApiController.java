package com.colinwjd.venus.web.controller.api;

import com.colinwjd.venus.model.bo.JsonResp;
import com.colinwjd.venus.model.vo.LinkVO;
import com.colinwjd.venus.service.LinkService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 友情链接 API
 *
 * @author Colin Wang
 * @date 2018/9/13
 */
@RestController
@RequestMapping("/api/link")
public class LinkApiController {

    private final LinkService linkService;

    @Autowired
    public LinkApiController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/all")
    public JsonResp<List<LinkVO>> findAll() {
        List<LinkVO> links = LinkVO.buildWith(linkService.findAll());
        return CollectionUtils.isEmpty(links) ? JsonResp.httpStatus(HttpStatus.NO_CONTENT) : JsonResp.success(links);
    }
}
