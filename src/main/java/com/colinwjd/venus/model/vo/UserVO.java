package com.colinwjd.venus.model.vo;

import com.colinwjd.venus.model.entity.User;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户 视图对象
 *
 * @author Colin Wang
 * @date 2018/9/7
 */
@Data
@Builder
public class UserVO implements Serializable {

    private static final long serialVersionUID = 1136656334814542016L;
    
    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 用户昵称
     */
    private String nick;

    /**
     * 邮箱
     */
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

    public static UserVO buildWith(User user) {
        return user == null ? null : UserVO.builder()
                .id(user.getId())
                .name(user.getName())
                .nick(user.getNick())
                .email(user.getEmail())
                .avatar(user.getAvatar())
                .desc(user.getDesc())
                .url(user.getUrl())
                .github(user.getGithub())
                .build();
    }

    public static List<UserVO> buildWith(Iterable<User> users) {
        if (users == null) {
            return null;
        }
        List<UserVO> result = new ArrayList<>();
        users.forEach(user -> result.add(buildWith(user)));
        return result;
    }
}
