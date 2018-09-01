package com.colinwjd.venus.service;

import com.colinwjd.venus.model.entity.Link;

import java.util.List;

/**
 * 友情链接服务
 *
 * @author Colin Wang
 * @date 2018/9/1
 */
public interface LinkService {

    Link saveByLink(Link link);

    Link removeById(Long id);

    List<Link> findAll();

    Link findById(Long id);

    Link findByUrl(String url);

    Link findByName(String name);
}
