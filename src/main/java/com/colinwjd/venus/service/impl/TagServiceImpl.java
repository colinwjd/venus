package com.colinwjd.venus.service.impl;

import com.colinwjd.venus.model.entity.Tag;
import com.colinwjd.venus.repository.TagRepository;
import com.colinwjd.venus.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 标签服务实现
 *
 * @author Colin Wang
 * @date 2018/9/1
 */
@Slf4j
@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Tag saveByTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag removeById(Long id) {
        Optional<Tag> tag = tagRepository.findById(id);
        if (tag.isPresent()) {
            tagRepository.deleteById(id);
            log.debug("Tag deleted: " + tag.get().getName());
        }
        return tag.orElse(null);
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public Tag findById(Long id) {
        return tagRepository.findById(id).orElse(null);
    }

    @Override
    public Tag findByUrl(String url) {
        return tagRepository.findByUrl(url);
    }

    @Override
    public Tag findByName(String name) {
        return tagRepository.findByName(name);
    }
}
