package com.colinwjd.venus.model.vo;

import lombok.Data;

/**
 * 友情链接 视图对象
 *
 * @author Colin Wang
 * @date 2018/9/7
 */
@Data
public class LinkVO {

    /**
     * 友情链接名称
     */
    private String name;

    /**
     * 友情链接地址
     */
    private String url;

    /**
     * 友情链接说明
     */
    private String desc;
}
