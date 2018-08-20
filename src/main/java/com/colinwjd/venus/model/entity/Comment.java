package com.colinwjd.venus.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 文章评论
 *
 * @author Colin Wang
 * @date 2018/8/18
 */
@Data
@Entity
@Table(name = "venus_comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = 655780595235443972L;

    /**
     * 评论ID
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
     * 评论用户
     */
    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private User user;

    /**
     * 评论文章
     */
    @ManyToOne(targetEntity = Post.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    @JsonIgnore
    private Post post;

    /**
     * 评论内容
     */
    @NotBlank(message = "comment content can not be empty.")
    @Lob
    private String content;

    /**
     * 评论用户user-agent信息
     */
    private String ua;

    /**
     * 是否作者本人评论 0:否 1:是
     */
    @Column(name = "is_author")
    private Integer isAuthor;

    /**
     * 评论状态 0:正常 1:待审核 2:回收站
     */
    private Integer status = 1;

    /**
     * 父级评论
     */
    private Long parent = 0L;

    /**
     * 子评论列表
     */
    @Transient
    private List<Comment> childs;

}
