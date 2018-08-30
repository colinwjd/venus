package com.colinwjd.venus.service.impl;

import com.colinwjd.venus.commons.enums.PostStatusEnum;
import com.colinwjd.venus.commons.enums.PostTypeEnum;
import com.colinwjd.venus.model.entity.Category;
import com.colinwjd.venus.model.entity.Post;
import com.colinwjd.venus.model.entity.Tag;
import com.colinwjd.venus.model.vo.Archive;
import com.colinwjd.venus.repository.PostRepository;
import com.colinwjd.venus.service.PostService;
import com.hankcs.hanlp.HanLP;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * 文章服务实现
 *
 * @author Colin Wang
 * @date 2018/8/30
 */
@Slf4j
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post saveByPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post removeById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            postRepository.deleteById(id);
            log.debug("deleted post: " + post.get().getTitle());
        }
        return post.orElse(null);
    }

    @Override
    public Post updateStatus(Post post, Integer status) {
        post.setStatus(status);
        return postRepository.save(post);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Post updateVisitCount(Post post) {
        post.setVisitCount(post.getVisitCount() + 1);
        return postRepository.save(post);
    }

    @Override
    public void updateSummaryWordCount(Integer wordCount) {
        List<Post> posts = postRepository.findByType(PostTypeEnum.POST.getValue());
        if (posts != null && !posts.isEmpty()) {
            posts.forEach(post -> {
                post.setSummary(HanLP.getSummary(post.getContentMd(), wordCount));
                postRepository.save(post);
            });
        }
    }

    @Override
    public List<Post> findByType(String type) {
        return postRepository.findByType(type);
    }

    @Override
    public Page<Post> findByType(String type, Pageable pageable) {
        return postRepository.findByType(type, pageable);
    }

    @Override
    public List<Post> findByTypeAndStatus(String type, Integer status) {
        return postRepository.findByTypeAndStatus(type, status);
    }

    @Override
    public Page<Post> findByTypeAndStatus(String type, Integer status, Pageable pageable) {
        return postRepository.findByTypeAndStatus(type, status, pageable);
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public Post findByUrl(String url) {
        return postRepository.findByUrl(url);
    }

    @Override
    public List<Post> findLatestN(int n) {
        return postRepository.findLatestN(n);
    }

    @Override
    public List<Archive> archiveByYearAndMonth() {
        List<Object[]> objects = postRepository.countGroupByYearAndMonth();
        List<Archive> archives = new ArrayList<>(objects.size());
        objects.forEach(array -> {
            Archive archive = new Archive();
            archive.setYear(array[0].toString());
            archive.setMonth(array[1].toString());
            archive.setCount(Integer.parseInt(array[2].toString()));
            archive.setPosts(postRepository.findByYearAndMonth(array[0].toString(), array[1].toString()));
            archives.add(archive);
        });
        return archives;
    }

    @Override
    public List<Archive> archiveByYear() {
        List<Object[]> objects = postRepository.countGroupByYear();
        List<Archive> archives = new ArrayList<>(objects.size());
        objects.forEach(array -> {
            Archive archive = new Archive();
            archive.setYear(array[0].toString());
            archive.setCount(Integer.parseInt(array[1].toString()));
            archive.setPosts(postRepository.findByYear(array[0].toString()));
            archives.add(archive);
        });
        return archives;
    }

    @Override
    public List<Post> findByYearAndMonth(String year, String month) {
        return postRepository.findByYearAndMonth(year, month);
    }

    @Override
    public Page<Post> findByYearAndMonth(String year, String month, Pageable pageable) {
        return postRepository.findByYearAndMonth(year, month, pageable);
    }

    @Override
    public List<Post> findByYear(String year) {
        return postRepository.findByYear(year);
    }

    @Override
    public Page<Post> findByYear(String year, Pageable pageable) {
        return postRepository.findByYear(year, pageable);
    }

    @Override
    public Page<Post> findByCategory(Category category, Pageable pageable) {
        return postRepository.findByCategoriesAndStatus(category, PostStatusEnum.PUBLISHED.getValue(), pageable);
    }

    @Override
    public Page<Post> findByTag(Tag tag, Pageable pageable) {
        return postRepository.findByTagsAndStatus(tag, PostStatusEnum.PUBLISHED.getValue(), pageable);
    }

    @Override
    public List<Post> popularPost() {
        return postRepository.findByTypeOrderByVisitCountDesc(PostTypeEnum.POST.getValue());
    }

    @Override
    public List<Post> relatedPosts(Post post) {
        List<String> keywords = this.keywords(post, 3);
        Set<Post> posts = new HashSet<>();
        keywords.forEach(keyword -> {
            posts.addAll(this.search(keyword));
        });
        return new ArrayList<>(posts);
    }

    @Override
    public Long totalVisitCount() {
        return postRepository.getTotalVisitCount();
    }

    @Override
    public Integer countByStatus(Integer status) {
        return postRepository.countByTypeAndStatus(PostTypeEnum.POST.getValue(), status);
    }

    @Override
    public List<String> keywords(Post post, Integer num) {
        return HanLP.extractKeyword(post.getContentMd(), num);
    }

    @Override
    public List<Post> search(String keyword) {
        return postRepository.findByTitleLikeOrContentLike(keyword);
    }

    @Override
    public Page<Post> search(String keyword, Pageable pageable) {
        return postRepository.findByTitleLikeOrContentLike(keyword, pageable);
    }
}
