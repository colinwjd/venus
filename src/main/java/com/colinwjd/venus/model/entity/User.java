package com.colinwjd.venus.model.entity;

import com.colinwjd.venus.common.enums.RoleEnum;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 用户信息
 *
 * @author Colin Wang
 * @date 2018/8/17
 */
@Data
@Entity
@Table(name = "venus_user")
public class User implements UserDetails {

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
    @Column(updatable = false)
    private LocalDateTime createTime;

    /**
     * 最后修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 用户名称
     */
    @NotBlank(message = "user name can not be empty.")
    private String name;

    /**
     * 用户昵称
     */
    private String nick;

    /**
     * 密码
     */
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
     * 用户主页
     */
    private String url;

    /**
     * GitHub地址
     */
    private String github;

    /**
     * 最后登录时间
     */
    private LocalDateTime visitTime;

    /**
     * 角色
     */
    @Enumerated(value = EnumType.STRING)
    private RoleEnum role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<>(1);
        auths.add(new SimpleGrantedAuthority(this.role.name()));
        return auths;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
