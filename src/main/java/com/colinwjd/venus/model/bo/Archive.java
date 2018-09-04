package com.colinwjd.venus.model.bo;

import com.colinwjd.venus.model.entity.Post;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 文章归档
 *
 * @author Colin Wang
 * @date 2018/8/20
 */
@Data
public class Archive implements Serializable {

    private static final long serialVersionUID = 816401520247295720L;

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
    private List<Post> posts;
}
