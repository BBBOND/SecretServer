package com.geekmadmen.secret.dao.impl;

import com.geekmadmen.secret.dao.ManagerDaoI;
import com.geekmadmen.secret.model.TManager;
import org.springframework.stereotype.Repository;

/**
 * Created by 东 on 2016/3/12.
 */
@Repository("managerDao")
public class ManagerDaoImpl extends BaseDaoImpl<TManager> implements ManagerDaoI  {
//    private SessionFactory sessionFactory;
//
//    @Autowired
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    private Session getCurrentSession() {
//        return sessionFactory.getCurrentSession();
//    }
//    @Override
//    public List<TUser> getAllUser(String hql) {
//        Query query = getCurrentSession().createQuery(hql);
//        List<TUser> list = query.list();
//        if (list != null && list.size() > 0) {
//            return list;
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public List<TUser> getAllUser(String hql, Map<String, Object> params) {
//        Query query = getCurrentSession().createQuery(hql);
//        if (params != null && !params.isEmpty()) {
//            for (Object o : params.keySet()) {
//                query.setParameter((String) o, params.get(o));
//            }
//        }
//        List<TUser> list = query.list();
//        if (list != null && list.size() > 0) {
//            return list;
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public TUser getUser(String hql) {
//        Query query = getCurrentSession().createQuery(hql);
//        List<TUser> list = query.list();
//        if (list != null && list.size() > 0) {
//            return list.get(0);
//        }
//        return null;
//    }
//
//    @Override
//    public TUser getUser(String hql, Map<String, Object> params) {
//        Query query = getCurrentSession().createQuery(hql);
//        if (params != null && !params.isEmpty()) {
//            for (Object o : params.keySet()) {
//                query.setParameter((String) o, params.get(o));
//            }
//        }
//        List<TUser> list = query.list();
//        if (list != null && list.size() > 0) {
//            return list.get(0);
//        }
//        return null;
//    }
}
