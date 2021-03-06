package com.colinwjd.venus.model.vo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.colinwjd.venus.model.entity.Comment;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

/**
 * 评论 视图对象
 *
 * @author Colin Wang
 * @date 2018/9/7
 */
@Data
@Builder
public class CommentVO implements Serializable {

    private static final long serialVersionUID = 6756409668707645779L;

    /**
     * 评论ID
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
     * 评论用户
     */
    private UserVO user;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论用户user-agent信息
     */
    private String ua;

    /**
     * 是否作者本人评论 0:否 1:是
     */
    private Integer isAuthor;

    /**
     * 子评论列表
     */
    private List<CommentVO> children;

    public static CommentVO buildWith(Comment comment) {
        return comment == null ? null : CommentVO.builder()
            .id(comment.getId())
            .createTime(comment.getCreateTime())
            .modifyTime(comment.getModifyTime())
            .user(UserVO.buildWith(comment.getUser()))
            .content(comment.getContent())
            .ua(comment.getUa())
            .isAuthor(comment.getIsAuthor())
            .children(buildWith(comment.getChildren()))
            .build();
    }

    public static List<CommentVO> buildWith(Iterable<Comment> comments) {
        if (comments == null) {
            return null;
        }
        List<CommentVO> result = new ArrayList<>();
        comments.forEach(comment -> result.add(buildWith(comment)));
        return result;
    }
}
