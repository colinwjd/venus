package com.colinwjd.venus.web.controller.api;

import com.colinwjd.venus.model.bo.JsonResp;
import com.colinwjd.venus.model.vo.MenuVO;
import com.colinwjd.venus.service.MenuService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 菜单 API
 *
 * @author Colin Wang
 * @date 2018/9/7
 */
@RestController
@RequestMapping("/api/menu")
public class MenuApiController {

    private final MenuService menuService;

    @Autowired
    public MenuApiController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/all")
    public JsonResp<List<MenuVO>> findAll() {
        List<MenuVO> menus = MenuVO.buildWith(menuService.findAll());
        return CollectionUtils.isEmpty(menus) ? JsonResp.httpStatus(HttpStatus.NO_CONTENT) : JsonResp.success(menus);
    }
}
