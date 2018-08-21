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
 * 菜单
 *
 * @author Colin Wang
 * @date 2018/8/20
 */
@Data
@Entity
@Table(name = "venus_menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = -4542068032925474292L;

    /**
     * 菜单ID
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 创建时间
     */
    @Column(updatable = false)
    private Date createTime;

    /**
     * 最后修改时间
     */
    private Date modifyTime;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单地址
     */
    private String url;

    /**
     * 菜单顺序编号
     */
    private Integer number;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 菜单打开方式
     */
    private String target;
}
