package com.geekmadmen.secret.dao.impl;

import com.geekmadmen.secret.dao.BaseDaoI;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by 伟阳 on 2016/3/10.
 */
@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDaoI<T> {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public Serializable save(T t) {
        return sessionFactory.getCurrentSession().save(t);
    }

    public void delete(T t) {
        getCurrentSession().delete(t);
    }

    public T update(T t) {
        getCurrentSession().update(t);
        return t;
    }

    public T saveOrUpdate(T t) {
        getCurrentSession().saveOrUpdate(t);
        return t;
    }

    public T get(Class<T> cla, Serializable id) {
        return (T) getCurrentSession().get(cla, id);
    }

    public T get(String hql) {
        Query query = getCurrentSession().createQuery(hql);
        List<T> list = query.list();
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public T get(String hql, Map<String, Object> params) {
        Query query = getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (Object o : params.keySet()) {
                query.setParameter((String) o, params.get(o));
            }
        }
        List<T> list = query.list();
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public List<T> find(String hql) {
        Query query = getCurrentSession().createQuery(hql);
        List<T> list = query.list();
        if (list != null && list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }

    public List<T> find(String hql, Map<String, Object> params) {
        Query query = getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (Object o : params.keySet()) {
                query.setParameter((String) o, params.get(o));
            }
        }
        List<T> list = query.list();
        if (list != null && list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }

    public List<T> find(String hql, int page, int rows) {
        Query query = getCurrentSession().createQuery(hql);
        List<T> list = query.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
        if (list != null && list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }

    public List<T> find(String hql, Map<String, Object> params, int page, int rows) {
        Query query = getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (Object o : params.keySet()) {
                query.setParameter((String) o, params.get(o));
            }
        }
        List<T> list = query.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
        if (list != null && list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }

    public Long count(String hql) {
        Query query = getCurrentSession().createQuery(hql);
        return (Long) query.uniqueResult();
    }

    public Long count(String hql, Map<String, Object> params) {
        Query query = getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (Object o : params.keySet()) {
                query.setParameter((String) o, params.get(o));
            }
        }
        return (Long) query.uniqueResult();
    }

    public int executeHql(String hql) {
        Query query = getCurrentSession().createQuery(hql);
        return query.executeUpdate();
    }

    public void flush() {
        getCurrentSession().flush();
    }
}
