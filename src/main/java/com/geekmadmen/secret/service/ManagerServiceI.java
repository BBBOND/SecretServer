package com.geekmadmen.secret.service;

import com.geekmadmen.secret.UImodel.Manager;
import com.geekmadmen.secret.UImodel.User;

import java.util.List;

/**
 * Created by 东 on 2016/3/12.
 */
public interface ManagerServiceI {

    /**
     * 退出系统
     * @return
     */
    // String logout();

    /**
     * 管理員登錄
     *
     * @param manager
     */
    Manager login(Manager manager);

    /**
     * 查看所有用戶信息
     *
     * @return
     */
    List<User> listAllUser();

    /**
     * 查看用戶信息
     *
     * @param userId
     * @return
     */
    User listUserById(int userId);

    /**
     * 查看所有管理员的信息
     *
     * @return
     */
    List<Manager> listAllManager();

    /**
     * 查看管理员的信息
     *
     * @param managerId
     * @return
     */
    Manager listManagerById(int managerId);

    /**
     * 查看本月每天心情值数
     *
     * @return
     */
    int countOfOneDayEveryMonth();

    /**
     * 查看地区心情值数
     *
     * @return
     */
    int countOneAera();

    /**
     * @return
     */
    Object datagrid(User user);

    /**
     * 所有用户总人数
     * @return
     */
    Long userCount();

    /**
     * 用户心情统计
     * @return
     */
    List  userCountByMood();

    /**
     * 通过地区获取心情值
     * @return
     */
    List moodCountByLocal();
}
