package com.colinwjd.venus.web.controller.api;

import com.colinwjd.venus.model.bo.JsonResp;
import com.colinwjd.venus.model.vo.GalleryVO;
import com.colinwjd.venus.service.GalleryService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 图库 API
 *
 * @author Colin Wang
 * @date 2018/9/13
 */
@RestController
@RequestMapping("/api/gallery")
public class GalleryApiController {

    private final GalleryService galleryService;

    @Autowired
    public GalleryApiController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @GetMapping("/all")
    public JsonResp<List<GalleryVO>> findAll() {
        List<GalleryVO> galleries = GalleryVO.buildWith(galleryService.findAll());
        return CollectionUtils.isEmpty(galleries) ? JsonResp.httpStatus(HttpStatus.NO_CONTENT) : JsonResp.success(galleries);
    }

    @GetMapping("/{id}")
    public JsonResp<GalleryVO> findById(@PathVariable Long id) {
        GalleryVO gallery = GalleryVO.buildWith(galleryService.findById(id));
        return gallery == null ? JsonResp.httpStatus(HttpStatus.NOT_FOUND) : JsonResp.success(gallery);
    }
}
