package com.colinwjd.venus.model.vo;

import com.colinwjd.venus.model.entity.Gallery;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 图库 视图对象
 *
 * @author Colin Wang
 * @date 2018/9/7
 */
@Data
@Builder
public class GalleryVO implements Serializable {

    private static final long serialVersionUID = -3025228135679711134L;

    /**
     * 图片ID
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
     * 图片名称
     */
    private String name;

    /**
     * 图片描述
     */
    private String desc;

    /**
     * 拍摄时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime filmingTime;

    /**
     * 拍摄地点
     */
    private String filmingLocation;

    /**
     * 图片地址
     */
    private String url;

    /**
     * 缩略图地址
     */
    private String thumbnailUrl;

    public static GalleryVO buildWith(Gallery gallery) {
        return gallery == null ? null : GalleryVO.builder()
                .id(gallery.getId())
                .createTime(gallery.getCreateTime())
                .modifyTime(gallery.getModifyTime())
                .name(gallery.getName())
                .desc(gallery.getDesc())
                .filmingTime(gallery.getFilmingTime())
                .filmingLocation(gallery.getFilmingLocation())
                .url(gallery.getUrl())
                .thumbnailUrl(gallery.getThumbnailUrl())
                .build();
    }

    public static List<GalleryVO> buildWith(Iterable<Gallery> galleries) {
        if (galleries == null) {
            return null;
        }
        List<GalleryVO> result = new ArrayList<>();
        galleries.forEach(gallery -> result.add(buildWith(gallery)));
        return result;
    }
}
