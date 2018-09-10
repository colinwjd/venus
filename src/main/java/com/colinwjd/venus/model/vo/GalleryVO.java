package com.colinwjd.venus.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 图库 视图对象
 *
 * @author Colin Wang
 * @date 2018/9/7
 */
@Data
public class GalleryVO {

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
}
