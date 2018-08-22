package com.colinwjd.venus.repository;

import com.colinwjd.venus.model.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 菜单数据访问接口
 *
 * @author Colin Wang
 * @date 2018/8/22
 */
public interface MenuRepository extends JpaRepository<Menu, Long> {

    /**
     * 通过名称查询菜单
     *
     * @param name 菜单名称
     * @return 菜单
     */
    Menu findByName(String name);

    /**
     * 通过地址查询菜单
     *
     * @param url 菜单地址
     * @return 菜单
     */
    Menu findByUrl(String url);

    /**
     * 通过菜单序号查询菜单
     *
     * @param number 菜单序号
     * @return 菜单
     */
    Menu findByNumber(Integer number);
}
