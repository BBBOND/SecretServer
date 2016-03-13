package com.geekmadmen.secret.service.impl;

import com.geekmadmen.secret.UImodel.User;
import com.geekmadmen.secret.service.UserServiceI;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service(value = "userService")
public class UserServiceImpl implements UserServiceI {

    public Serializable addUser(User user) {
        return null;
    }

    public User login(User user) {
        return null;
    }
}
