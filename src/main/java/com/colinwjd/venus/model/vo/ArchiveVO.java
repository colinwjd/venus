package com.colinwjd.venus.model.vo;

import com.colinwjd.venus.model.bo.Archive;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 文章归档 视图对象
 *
 * @author Colin Wang
 * @date 2018/9/8
 */
@Data
@Builder
public class ArchiveVO implements Serializable {

    private static final long serialVersionUID = -283190910263249079L;

    /**
     * 年份
     */
    private String year;

    /**
     * 月份
     */
    private String month;

    /**
     * 文章数
     */
    private Integer count;

    /**
     * 文章列表
     */
    private List<PostVO> posts;

    public static ArchiveVO buildWith(Archive archive) {
        return archive == null ? null : ArchiveVO.builder()
                .year(archive.getYear())
                .month(archive.getMonth())
                .count(archive.getCount())
                .posts(PostVO.buildWith(archive.getPosts()))
                .build();
    }

    public static List<ArchiveVO> buildWith(Iterable<Archive> archives) {
        if (archives == null) {
            return null;
        }
        List<ArchiveVO> result = new ArrayList<>();
        archives.forEach(archive -> result.add(buildWith(archive)));
        return result;
    }
}
