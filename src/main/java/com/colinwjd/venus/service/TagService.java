package com.colinwjd.venus.service;

import com.colinwjd.venus.model.entity.Tag;

import java.util.List;

/**
 * 标签服务
 *
 * @author Colin Wang
 * @date 2018/9/1
 */
public interface TagService {

    Tag saveByTag(Tag tag);

    Tag removeById(Long id);

    List<Tag> findAll();

    Tag findById(Long id);

    Tag findByUrl(String url);

    Tag findByName(String name);
}
