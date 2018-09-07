package com.colinwjd.venus.model.vo;

import lombok.Data;

/**
 * 类目 视图对象
 *
 * @author Colin Wang
 * @date 2018/9/7
 */
@Data
public class CategoryVO {

    /**
     * 类目名称
     */
    private String name;

    /**
     * 类目说明
     */
    private String desc;

    /**
     * 类目地址
     */
    private String url;
}
