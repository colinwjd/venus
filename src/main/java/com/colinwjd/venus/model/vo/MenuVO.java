package com.colinwjd.venus.model.vo;

import lombok.Data;

/**
 * 菜单 视图对象
 *
 * @author Colin Wang
 * @date 2018/9/7
 */
@Data
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
}
