package com.colinwjd.venus.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 文章标签
 *
 * @author Colin Wang
 * @date 2018/8/18
 */
@Data
@Entity
@Table(name = "venus_tag")
public class Tag implements Serializable {

    private static final long serialVersionUID = 4480291511971652398L;

    /**
     * 标签ID
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 创建时间
     */
    @Column(updatable = false)
    private LocalDateTime createTime;

    /**
     * 最后修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 标签名称
     */
    private String name;

    /**
     * 标签地址
     */
    private String url;

    /**
     * 文章列表
     */
    @ManyToMany(mappedBy = "tags")
    private List<Post> posts = new ArrayList<>();
}
