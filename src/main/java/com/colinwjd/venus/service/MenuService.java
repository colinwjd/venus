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

    /**
     * 保存菜单
     *
     * @param menu 菜单
     * @return 菜单
     */
    Menu saveByMenu(Menu menu);

    /**
     * 通过ID删除菜单
     *
     * @param id 菜单ID
     * @return 被删除的菜单
     */
    Menu removeById(Long id);

    /**
     * 查询所有菜单
     *
     * @return 菜单列表
     */
    List<Menu> findAll();

    /**
     * 通过ID查询菜单
     *
     * @param id 菜单ID
     * @return 菜单
     */
    Menu findById(Long id);

    /**
     * 通过地址查询菜单
     *
     * @param url 菜单地址
     * @return 菜单
     */
    Menu findByUrl(String url);

    /**
     * 通过名称查询菜单
     *
     * @param name 菜单名称
     * @return 菜单
     */
    Menu findByName(String name);
}
