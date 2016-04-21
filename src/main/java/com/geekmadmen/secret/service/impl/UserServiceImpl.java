package com.geekmadmen.secret.service.impl;

import com.geekmadmen.secret.UImodel.User;
import com.geekmadmen.secret.dao.UserDaoI;
import com.geekmadmen.secret.model.TUser;
import com.geekmadmen.secret.service.UserServiceI;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserServiceI {
    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    private UserDaoI userDao;

    public UserDaoI getUserDao() {
        return userDao;
    }

    @Autowired
    public void setUserDao(UserDaoI userDao) {
        this.userDao = userDao;
    }

    public Serializable addUser(User user) {
        return null;
    }

    @Override
    public User login(User user) {
        String hql = "from TUser t where t.userName=:userName and t.userPassword=:userPassword";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userName", user.getUserName());
        map.put("userPassword", user.getUserPassword());
        TUser tUser = userDao.get(hql, map);
        if (tUser != null) {
            User user1 = new User();
            BeanUtils.copyProperties(tUser, user1);
            logger.info(user1.getUserId());
            return user1;
        }
        return null;
    }

    @Override
    public User getUserListById(int id) {
        return null;
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public int userExist(String username) {
        String hql = "from TUser t where t.userName='" + username + "'";
//        TUser tUser=userDao.get(hql);
        TUser tUser = userDao.get(hql);
        if (tUser != null) {
            return 1;
        }
        return 101;
    }

    @Override
    public String getPassword(String username) {
        String hql = "select t.userPassword from TUser t where t.userName='" + username + "'";
        String password = userDao.getPassword(hql);
        if (password != null && !"".equals(password)) {
            return password;
        }
        return null;
    }


}
