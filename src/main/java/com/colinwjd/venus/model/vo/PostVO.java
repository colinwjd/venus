package com.colinwjd.venus.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 文章 视图对象
 *
 * @author Colin Wang
 * @date 2018/9/6
 */
@Data
public class PostVO {

    /**
     * 文章ID
     */
    private Long id;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 最后修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;

    /**
     * 作者名称
     */
    private String user;

    /**
     * 标题
     */
    private String title;

    /**
     * 文章摘要
     */
    private String summary;

    /**
     * 内容 markdown格式
     */
    private String contentMd;

    /**
     * 内容 html格式
     */
    private String content;

    /**
     * 地址
     */
    private String url;

    /**
     * 缩略图
     */
    private String thumbnail;

    /**
     * 访问量
     */
    private Long visitCount;

    /**
     * 是否禁用评论
     */
    private Integer disableComment;

    /**
     * 文章类目
     */
    private List<String> categories;

    /**
     * 文章标签
     */
    private List<String> tags;
}
