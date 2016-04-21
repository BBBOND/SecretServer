package com.geekmadmen.secret.service;

import com.geekmadmen.secret.UImodel.User;

import java.io.Serializable;

public interface UserServiceI {
    Serializable addUser(User user);

    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     *
     * @param id
     * @return
     */
    User getUserListById(int id);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 判断用户是否存在
     * @param username
     * @return
     */
    int userExist(String username);

    /**
     * 判断密码是是否正确
     * @param username
     * @return
     */
    String  getPassword(String username);

}
