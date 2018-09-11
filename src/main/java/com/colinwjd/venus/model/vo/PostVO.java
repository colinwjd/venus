package com.colinwjd.venus.model.vo;

import com.colinwjd.venus.model.entity.Post;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 文章 视图对象
 *
 * @author Colin Wang
 * @date 2018/9/6
 */
@Data
@Builder
public class PostVO {

    /**
     * 文章ID
     */
    private Long id;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 最后修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifyTime;

    /**
     * 作者
     */
    private UserVO user;

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
    private List<CategoryVO> categories;

    /**
     * 文章标签
     */
    private List<TagVO> tags;

    public static PostVO buildWith(Post post) {
        return post == null ? null : PostVO.builder()
                .id(post.getId())
                .createTime(post.getCreateTime())
                .modifyTime(post.getModifyTime())
                .user(UserVO.buildWith(post.getUser()))
                .title(post.getTitle())
                .summary(post.getSummary())
                .contentMd(post.getContentMd())
                .content(post.getContent())
                .url(post.getUrl())
                .thumbnail(post.getThumbnail())
                .visitCount(post.getVisitCount())
                .disableComment(post.getDisableComment())
                .categories(CategoryVO.buildWith(post.getCategories()))
                .tags(TagVO.buildWith(post.getTags()))
                .build();
    }

    public static List<PostVO> buildWith(Collection<Post> posts) {
        if (posts == null) return null;
        List<PostVO> result = new ArrayList<>(posts.size());
        posts.forEach(post -> result.add(buildWith(post)));
        return result;
    }
}