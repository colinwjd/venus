package com.colinwjd.venus.service.impl;

import com.colinwjd.venus.model.entity.Comment;
import com.colinwjd.venus.model.entity.Post;
import com.colinwjd.venus.model.entity.User;
import com.colinwjd.venus.repository.CommentRepository;
import com.colinwjd.venus.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 评论服务实现
 *
 * @author Colin Wang
 * @date 2018/9/1
 */
@Slf4j
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment saveByComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment removeCommentById(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        if (comment.isPresent()) {
            commentRepository.deleteById(id);
            log.debug("comment deleted: " + id);
        }
        return comment.orElse(null);
    }

    @Override
    public List<Comment> findByStatus(Integer status) {
        return commentRepository.findByStatus(status);
    }

    @Override
    public Page<Comment> findByStatus(Integer status, Pageable pageable) {
        return commentRepository.findByStatus(status, pageable);
    }

    @Override
    public Comment updateStatus(Comment comment, Integer status) {
        comment.setStatus(status);
        return commentRepository.save(comment);
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Comment> findByPost(Post post) {
        return commentRepository.findByPost(post);
    }

    @Override
    public Page<Comment> findByPost(Post post, Pageable pageable) {
        return commentRepository.findByPost(post, pageable);
    }

    @Override
    public List<Comment> findByPostAndStatus(Post post, Integer status) {
        return commentRepository.findByPostAndStatus(post, status);
    }

    @Override
    public Page<Comment> findByPostAndStatus(Post post, Integer status, Pageable pageable) {
        return commentRepository.findByPostAndStatus(post, status, pageable);
    }

    @Override
    public List<Comment> findByPostAndStatusNot(Post post, Integer status) {
        return commentRepository.findByPostAndStatusNot(post, status);
    }

    @Override
    public Page<Comment> findByPostAndStatusNot(Post post, Integer status, Pageable pageable) {
        return commentRepository.findByPostAndStatusNot(post, status, pageable);
    }

    @Override
    public List<Comment> findByUser(User user) {
        return commentRepository.findByUser(user);
    }

    @Override
    public Page<Comment> findByUser(User user, Pageable pageable) {
        return commentRepository.findByUser(user, pageable);
    }

    @Override
    public List<Comment> findByUserAndStatus(User user, Integer status) {
        return commentRepository.findByUserAndStatus(user, status);
    }

    @Override
    public Page<Comment> findByUserAndStatus(User user, Integer status, Pageable pageable) {
        return commentRepository.findByUserAndStatus(user, status, pageable);
    }

    @Override
    public List<Comment> findLatestN(int n) {
        return commentRepository.findLatestN(n);
    }

    @Override
    public Integer countByStatus(Integer status) {
        return commentRepository.countByStatus(status);
    }

    @Override
    public List<Comment> search(String keyword) {
        return commentRepository.findByContentLike(keyword);
    }

    @Override
    public Page<Comment> search(String keyword, Pageable pageable) {
        return commentRepository.findByContentLike(keyword, pageable);
    }
}
