package com.colinwjd.venus.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 文章类目
 *
 * @author Colin Wang
 * @date 2018/8/18
 */
@Data
@Entity
@Table(name = "venus_category")
public class Category implements Serializable {

    private static final long serialVersionUID = -5731247580954789881L;

    /**
     * 类目ID
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
     * 类目名称
     */
    @NotBlank(message = "category name can not be empty.")
    private String name;

    /**
     * 类目说明
     */
    private String desc;

    /**
     * 类目地址
     */
    @NotBlank(message = "category url can not be empty.")
    private String url;

    /**
     * 文章列表
     */
    @ManyToMany(mappedBy = "categories")
    private List<Post> posts = new ArrayList<>();
}
