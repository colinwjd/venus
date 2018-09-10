package com.colinwjd.venus.model.vo;

import com.colinwjd.venus.model.entity.Tag;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 标签 视图对象
 *
 * @author Colin Wang
 * @date 2018/9/7
 */
@Data
@Builder
public class TagVO {

    /**
     * 标签名称
     */
    private String name;

    /**
     * 标签地址
     */
    private String url;

    public static TagVO buildWith(Tag tag) {
        return TagVO.builder()
                .name(tag.getName())
                .url(tag.getUrl())
                .build();
    }

    public static List<TagVO> buildWith(List<Tag> tags) {
        if (tags == null) return null;
        List<TagVO> result = new ArrayList<>(tags.size());
        tags.forEach(tag -> result.add(buildWith(tag)));
        return result;
    }
}
