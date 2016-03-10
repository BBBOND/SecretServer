package com.geekmadmen.secret.service;

import com.geekmadmen.secret.UImodel.User;

import java.io.Serializable;

public interface UserServiceI {
    Serializable addUser(User user);

    User login(User user);


}
