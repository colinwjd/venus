package com.colinwjd.venus.model.vo;

import com.colinwjd.venus.model.entity.Menu;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 菜单 视图对象
 *
 * @author Colin Wang
 * @date 2018/9/7
 */
@Data
@Builder
public class MenuVO {

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单地址
     */
    private String url;

    /**
     * 菜单顺序编号
     */
    private Integer number;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 菜单打开方式
     */
    private String target;

    public static MenuVO buildWith(Menu menu) {
        return MenuVO.builder()
                .name(menu.getName())
                .url(menu.getUrl())
                .number(menu.getNumber())
                .icon(menu.getIcon())
                .target(menu.getTarget())
                .build();
    }

    public static List<MenuVO> buildWith(Collection<Menu> menus) {
        if (menus == null) return null;
        List<MenuVO> result = new ArrayList<>(menus.size());
        menus.forEach(menu -> result.add(buildWith(menu)));
        return result;
    }
}
