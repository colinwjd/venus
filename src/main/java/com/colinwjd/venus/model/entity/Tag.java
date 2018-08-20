package com.colinwjd.venus.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
    @Column(name = "create_time", updatable = false)
    private Date createTime;

    /**
     * 最后修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

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
    @JsonIgnore
    private List<Post> posts = new ArrayList<>();
}
