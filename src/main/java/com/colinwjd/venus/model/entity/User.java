package com.colinwjd.venus.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息，可以是 博主 or 访客
 *
 * @author Colin Wang
 * @date 2018/8/17
 */
@Data
@Entity
@Table(name = "venus_user")
public class User implements Serializable {

    private static final long serialVersionUID = -1322691637504325950L;

    /**
     * 用户ID
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 创建时间
     */
    @JsonIgnore
    private Date create_time;

    /**
     * 最后修改时间
     */
    @JsonIgnore
    private Date modify_time;

    /**
     * 用户名称
     */
    @NotBlank(message = "user name should not be empty.")
    private String name;

    /**
     * 用户昵称
     */
    private String nick;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;

    /**
     * 邮箱
     */
    @Email(message = "E-mail address is illegal.")
    private String email;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 简介
     */
    private String desc;

    /**
     * 最后访问时间
     */
    @JsonIgnore
    private Date visit_time;
}
