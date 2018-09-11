package com.colinwjd.venus.model.vo;

import com.colinwjd.venus.model.entity.Link;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 友情链接 视图对象
 *
 * @author Colin Wang
 * @date 2018/9/7
 */
@Data
@Builder
public class LinkVO {

    /**
     * 友情链接名称
     */
    private String name;

    /**
     * 友情链接地址
     */
    private String url;

    /**
     * 友情链接说明
     */
    private String desc;

    public static LinkVO buildWith(Link link) {
        return link == null ? null : LinkVO.builder()
                .name(link.getName())
                .url(link.getUrl())
                .desc(link.getDesc())
                .build();
    }

    public static List<LinkVO> buildWith(Collection<Link> links) {
        if (links == null) return null;
        List<LinkVO> result = new ArrayList<>(links.size());
        links.forEach(link -> result.add(buildWith(link)));
        return result;
    }
}