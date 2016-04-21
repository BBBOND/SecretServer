package com.geekmadmen.secret.dao.impl;

import com.geekmadmen.secret.dao.UserDaoI;
import com.geekmadmen.secret.model.TUser;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by 东 on 2016/3/23.
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<TUser> implements UserDaoI {
    @Override
    public String getPassword(String hql) {
        Query query=getCurrentSession().createQuery(hql);
        String password=query.getQueryString();
        return password;
    }
}
