package com.colinwjd.venus.service;

import com.colinwjd.venus.model.entity.Menu;

import java.util.List;

/**
 * 菜单服务
 *
 * @author Colin Wang
 * @date 2018/9/1
 */
public interface MenuService {

    Menu saveByMenu(Menu menu);

    Menu removeById(Long id);

    List<Menu> findAll();

    Menu findById(Long id);

    Menu findByUrl(String url);

    Menu findByName(String name);
}
