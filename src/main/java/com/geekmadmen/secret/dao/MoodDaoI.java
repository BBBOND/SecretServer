package com.geekmadmen.secret.dao;

import com.geekmadmen.secret.model.TMood;

import java.util.List;

/**
 * Created by 东 on 2016/4/6.
 */
public interface MoodDaoI extends BaseDaoI<TMood> {

    /**
     * 通过原生sql获取多条线信息
     * @param sql
     * @return
     */
    List findInSql(String sql);

  /*  *//**
     * 通过sql获取多条信息
     * @param sql
     * @return
     *//*
    List moodCountByLocal(String sql);*/
}
