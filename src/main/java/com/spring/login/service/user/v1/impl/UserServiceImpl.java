package com.spring.login.service.user.v1.impl;

import com.spring.login.model.User;
import com.spring.login.repository.UserRepository;
import com.spring.login.service.user.v1.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final BCryptPasswordEncoder passwordEncode;

    @Override
    public User findByEmail(String username) {
        return repository.findByEmail(username);
    }

    @Override
    public User createUser(User user) {
        user.setPassword(passwordEncode.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        return repository.save(user);
    }

    @Override
    public boolean checkEmail(String email) {
        return repository.existsByEmail(email);
    }
}
