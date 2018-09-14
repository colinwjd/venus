package com.colinwjd.venus.web.controller.api;

import com.colinwjd.venus.model.bo.JsonResp;
import com.colinwjd.venus.model.vo.CategoryVO;
import com.colinwjd.venus.service.CategoryService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 类目 API
 *
 * @author Colin Wang
 * @date 2018/9/14
 */
@RestController
@RequestMapping("/api/category")
public class CategoryApiController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryApiController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public JsonResp<List<CategoryVO>> findAll() {
        List<CategoryVO> categories = CategoryVO.buildWith(categoryService.findAll());
        return CollectionUtils.isEmpty(categories) ? JsonResp.httpStatus(HttpStatus.NO_CONTENT) : JsonResp.success(categories);
    }

    @GetMapping("/{url}")
    public JsonResp<CategoryVO> findByUrl(@PathVariable String url) {
        CategoryVO category = CategoryVO.buildWith(categoryService.findByUrl(url));
        return category == null ? JsonResp.httpStatus(HttpStatus.NOT_FOUND) : JsonResp.success(category);
    }
}
