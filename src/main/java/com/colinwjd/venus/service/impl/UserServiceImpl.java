package com.colinwjd.venus.service.impl;

import com.colinwjd.venus.model.entity.User;
import com.colinwjd.venus.repository.UserRepository;
import com.colinwjd.venus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现
 *
 * @author Colin Wang
 * @date 2018/8/27
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public User saveByUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User signUp(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public boolean updatePassword(User user, String oldPassword, String newPassword) {
        if (encoder.matches(oldPassword, user.getPassword())) {
            user.setPassword(newPassword);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public User loginByName(String name, String password) {
        User user = userRepository.findByName(name);
        return user != null && encoder.matches(password, user.getPassword()) ? user : null;
    }

    @Override
    public User loginByEmail(String email, String password) {
        User user = userRepository.findByEmail(email);
        return user != null && encoder.matches(password, user.getPassword()) ? user : null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);
        if (user == null) {
            log.warn("User name not found.");
            throw new UsernameNotFoundException("User name not found.");
        }
        return user;
    }
}
