package com.colinwjd.venus.service.impl;

import com.colinwjd.venus.model.entity.Link;
import com.colinwjd.venus.repository.LinkRepository;
import com.colinwjd.venus.service.LinkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 友情链接服务实现
 *
 * @author Colin Wang
 * @date 2018/9/1
 */
@Slf4j
@Service
public class LinkServiceImpl implements LinkService {

    private final LinkRepository linkRepository;

    @Autowired
    public LinkServiceImpl(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public Link saveByLink(Link link) {
        return linkRepository.save(link);
    }

    @Override
    public Link removeById(Long id) {
        Optional<Link> link = linkRepository.findById(id);
        if (link.isPresent()) {
            linkRepository.deleteById(id);
            log.debug("Link deleted: " + link.get().getName());
        }
        return link.orElse(null);
    }

    @Override
    public List<Link> findAll() {
        return linkRepository.findAll();
    }

    @Override
    public Link findById(Long id) {
        return linkRepository.findById(id).orElse(null);
    }

    @Override
    public Link findByUrl(String url) {
        return linkRepository.findByUrl(url);
    }

    @Override
    public Link findByName(String name) {
        return linkRepository.findByName(name);
    }
}
