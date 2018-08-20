package com.colinwjd.venus.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 相册
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
    @Column(name = "create_time", updatable = false)
    private Date createTime;

    /**
     * 最后修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

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
    @Column(name = "filming_time")
    private Date filmingTime;

    /**
     * 拍摄地点
     */
    @Column(name = "filming_location")
    private String filmingLocation;

    /**
     * 图片地址
     */
    private String url;

    /**
     * 缩略图地址
     */
    @Column(name = "thumbnail_url")
    private String thumbnailUrl;
}
