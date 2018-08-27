package com.colinwjd.venus.service.impl;

import com.colinwjd.venus.model.entity.User;
import com.colinwjd.venus.repository.UserRepository;
import com.colinwjd.venus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现
 *
 * @author Colin Wang
 * @date 2018/8/27
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveByUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User loginByName(String name, String password) {
        return userRepository.findByNameAndPassword(name, password);
    }

    @Override
    public User loginByEmail(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}
