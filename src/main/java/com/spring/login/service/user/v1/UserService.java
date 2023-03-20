package com.spring.login.service.user.v1;

import com.spring.login.model.User;

public interface UserService {
    User findByEmail(String username);
    User createUser(User user);

    boolean checkEmail(String email);
}
