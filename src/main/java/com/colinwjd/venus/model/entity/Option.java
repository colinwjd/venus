package com.colinwjd.venus.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 配置项
 *
 * @author Colin Wang
 * @date 2018/8/20
 */
@Data
@Entity
@Table(name = "venus_option")
public class Option implements Serializable {

    private static final long serialVersionUID = 8505672333439812945L;

    /**
     * 配置项ID
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
     * 配置项名称
     */
    @Column(unique = true)
    @NotBlank(message = "option name can not be empty.")
    private String name;

    /**
     * 配置项值
     */
    private String value;
}
