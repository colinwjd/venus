package com.colinwjd.venus.model.vo;

import lombok.Data;

/**
 * 标签 视图对象
 *
 * @author Colin Wang
 * @date 2018/9/7
 */
@Data
public class TagVO {

    /**
     * 标签名称
     */
    private String name;

    /**
     * 标签地址
     */
    private String url;
}
