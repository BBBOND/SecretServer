package com.geekmadmen.secret.dao;

import com.geekmadmen.secret.model.TUser;

/**
 * Created by 东 on 2016/3/23.
 */
public interface UserDaoI extends BaseDaoI<TUser> {
    String getPassword(String hql);
}
