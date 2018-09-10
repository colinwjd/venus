package com.colinwjd.venus.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 图库
 *
 * @author Colin Wang
 * @date 2018/8/20
 */
@Data
@Entity
@Table(name = "venus_gallery")
public class Gallery implements Serializable {

    private static final long serialVersionUID = 6532041336810406921L;

    /**
     * 图片ID
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 创建时间
     */
    @Column(updatable = false)
    private LocalDateTime createTime;

    /**
     * 最后修改时间
     */
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
