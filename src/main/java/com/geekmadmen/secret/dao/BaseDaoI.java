package com.geekmadmen.secret.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDaoI<T> {

    /**
     * 保存
     *
     * @param t
     * @return
     */
    Serializable save(T t);

    /**
     * 删除
     *
     * @param t
     * @return
     */
    void delete(T t);

    /**
     * 更新
     *
     * @param t
     * @return
     */
    T update(T t);

    /**
     * 保存或更新
     *
     * @param t
     * @return
     */
    T saveOrUpdate(T t);

    /**
     * 通过id获取单条信息
     *
     * @param cla
     * @param id
     * @return
     */
    T get(Class<T> cla, Serializable id);

    /**
     * 通过hql语句获取单条信息
     *
     * @param hql
     * @return
     */
    T get(String hql);

    /**
     * 通过hql获取单条信息（带参数）
     *
     * @param hql
     * @param params
     * @return
     */
    T get(String hql, Map<String, Object> params);

    /**
     * 通过hql获取多条信息
     *
     * @param hql
     * @return
     */
    List<T> find(String hql);

    /**
     * 通过hql获取多条信息（带参数）
     *
     * @param hql
     * @param params
     * @return
     */
    List<T> find(String hql, Map<String, Object> params);

    /**
     * 通过hql获取多条信息（带分页）
     *
     * @param hql
     * @param page
     * @param rows
     * @return
     */
    List<T> find(String hql, int page, int rows);

    /**
     * 通过hql获取多条信息（带分页，带参数）
     *
     * @param hql
     * @param params
     * @param page
     * @param rows
     * @return
     */
    List<T> find(String hql, Map<String, Object> params, int page, int rows);

    /**
     * 通过hql统计数量
     *
     * @param hql
     * @return
     */
    Long count(String hql);

    /**
     * 通过hql统计数量（带参数）
     *
     * @param hql
     * @param params
     * @return
     */
    Long count(String hql, Map<String, Object> params);

    /**
     * 执行通用hql语句
     *
     * @param hql
     * @return
     */
    int executeHql(String hql);

    /**
     * 强制刷新
     */
    void flush();


}
