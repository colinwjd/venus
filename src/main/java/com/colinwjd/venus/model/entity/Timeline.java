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
 * 时间轴
 *
 * @author Colin Wang
 * @date 2018/8/20
 */
@Data
@Entity
@Table(name = "venus_timeline")
public class Timeline implements Serializable {

    private static final long serialVersionUID = -5722423216191926834L;

    /**
     * 事件ID
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
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 事件标题
     */
    private String title;

    /**
     * 事件内容
     */
    private String content;

    /**
     * 事件发生时间
     */
    @Column(name = "event_time")
    private Date eventTime;
}