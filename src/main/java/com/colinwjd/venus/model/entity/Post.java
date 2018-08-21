package com.colinwjd.venus.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 文章 or 页面
 *
 * @author Colin Wang
 * @date 2018/8/18
 */
@Data
@Entity
@Table(name = "venus_post")
public class Post implements Serializable {

    private static final long serialVersionUID = -8431474702714505942L;

    /**
     * 文章ID
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(updatable = false)
    private Date createTime;

    /**
     * 最后修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;

    /**
     * 作者 多对一
     */
    @JoinColumn(name = "user_id")
    @ManyToOne(optional = false)
    private User user;

    /**
     * 标题
     */
    private String title;

    /**
     * 文章类型 post or page
     */
    private String type = "post";

    /**
     * 摘要
     */
    private String summary;

    /**
     * 文章类型内容 markdown格式
     */
    @Lob
    private String contentMd;

    /**
     * 页面类型内容 html格式
     */
    @Lob
    private String contentHtml;

    /**
     * 地址
     */
    @Column(unique = true)
    private String url;

    /**
     * 状态 0:已发布 1:草稿箱 2:回收站
     */
    private Integer status = 0;

    /**
     * 缩略图
     */
    private String thumbnail;

    /**
     * 访问量
     */
    private Long visitCount = 0L;

    /**
     * 是否禁用评论
     */
    private Integer disableComment = 0;

    /**
     * 文章分类
     */
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "venus_post_category",
            joinColumns = @JoinColumn(name = "post_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "cate_id", nullable = false)
    )
    private List<Category> categories = new ArrayList<>(3);

    /**
     * 文章标签
     */
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "venus_post_tag",
            joinColumns = @JoinColumn(name = "post_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "tag_id", nullable = false)
    )
    private List<Tag> tags = new ArrayList<>(5);

    /**
     * 文章评论
     */
    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Comment> comments = new ArrayList<>();
}
