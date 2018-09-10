package com.colinwjd.venus.model.vo;

import lombok.Data;

import java.util.List;

/**
 * 文章归档 视图对象
 *
 * @author Colin Wang
 * @date 2018/9/8
 */
@Data
public class ArchiveVO {

    /**
     * 年份
     */
    private String year;

    /**
     * 月份
     */
    private String month;

    /**
     * 文章数
     */
    private Integer count;

    /**
     * 文章列表
     */
    private List<PostVO> posts;
}
