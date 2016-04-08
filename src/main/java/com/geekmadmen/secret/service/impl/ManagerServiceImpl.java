package com.geekmadmen.secret.service.impl;

import com.geekmadmen.secret.UImodel.*;
import com.geekmadmen.secret.dao.ManagerDaoI;
import com.geekmadmen.secret.dao.MoodDaoI;
import com.geekmadmen.secret.dao.UserDaoI;
import com.geekmadmen.secret.model.TManager;
import com.geekmadmen.secret.model.TUser;
import com.geekmadmen.secret.service.ManagerServiceI;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 东 on 2016/3/12.
 */
@Service("managerService")
public class ManagerServiceImpl implements ManagerServiceI {
    private static final Logger logger = Logger.getLogger(ManagerServiceImpl.class);

    public void test() {
        logger.info("---------------------------> ManagerService do test");
    }

    private ManagerDaoI managerDao;
    private UserDaoI userDao;
    private MoodDaoI moodDao;

    public MoodDaoI getMoodDao() {
        return moodDao;
    }

    @Autowired
    public void setMoodDao(MoodDaoI moodDao) {
        this.moodDao = moodDao;
    }

    public static Logger getLogger() {
        return logger;
    }


    public UserDaoI getUserDao() {
        return userDao;
    }

    @Autowired
    public void setUserDao(UserDaoI userDao) {
        this.userDao = userDao;
    }

    public ManagerDaoI getManagerDao() {
        return managerDao;
    }

    @Autowired
    public void setManagerDao(ManagerDaoI managerDao) {
        this.managerDao = managerDao;
    }

 /*   public String logout() {
        ServletActionContext.getContext().getSession().clear();
        return SUCCESS;
    }*/

    public Manager login(Manager manager) {
        String hql = "from TManager tm where tm.managerName=:managerName and tm.managerPassword=:managerPassword";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("managerName", manager.getManagerName());
        map.put("managerPassword", manager.getManagerPassword());
        TManager tManager = managerDao.get(hql, map);
        if (tManager != null) {
            Manager manager1 = new Manager();
            BeanUtils.copyProperties(tManager, manager1);
            return manager;
        } else
            return null;
    }

    /*    @Override
        public List<User> listAllUser() {
            return null;
        }

        @Override
        public User listUserById(int userId) {
            return null;
        }

        @Override
        public List<Manager> listAllManager() {
            return null;
        }

        @Override
        public Manager listManagerById(int managerId) {
            return null;
        }*/
    public List<User> listAllUser() {
    /*    String hql = "from TUser t";
//        List<TUser> tUser = managerDao.getAllUser(hql);
        List<TUser> tUser = userDao.find(hql);
        List<User> users = new ArrayList<User>();
        if (tUser != null && tUser.size() > 0) {
            for (TUser tu : tUser) {
                User user = new User();
                BeanUtils.copyProperties(tu, user);
                users.add(user);
            }
        }*/
        return null;
    }

    public User listUserById(int userId) {
        User user = new User();
        String hql = "from TUser t where t.userId=" + userId;
        TUser tUser = userDao.get(hql);
        if (tUser != null) {
            BeanUtils.copyProperties(tUser, user);
        }
        return user;
    }

    public List<Manager> listAllManager() {
        String hql = "from TManager t";
        List<Manager> managers = new ArrayList<Manager>();
        List<TManager> tManager = managerDao.find(hql);
        if (tManager != null && tManager.size() > 0) {
            for (TManager tm : tManager) {
                Manager manager = new Manager();
                BeanUtils.copyProperties(tm, manager);
                managers.add(manager);
            }
        }
//        logger.info(managers);
        return managers;
    }

    public Manager listManagerById(int managerId) {
        Manager manager = new Manager();
//        String hql="from TManager t where t.managerId=:id";
        String hql = "from TManager t where t.managerId=" + managerId;
        TManager tManager = managerDao.get(hql);
        if (tManager != null) {
            BeanUtils.copyProperties(tManager, manager);
        }
        return manager;
    }

    public int countOfOneDayEveryMonth() {
        return 0;
    }

    public int countOneAera() {
        return 0;
    }

    @Override
    public DataGrid datagrid(User user) {
        DataGrid dataGrid = new DataGrid();
        String hql = "from TUser t";
        String countHql = "select count(*) " + hql;
        List<TUser> tUserList = userDao.find(hql, user.getPage(), user.getRows());
        logger.info(user.getPage());
        logger.info("-----------------");
        logger.info(user.getRows());
        List<User> userList = new ArrayList<User>();
        if (tUserList != null && tUserList.size() > 0) {
            for (TUser tUser : tUserList) {
                User users = new User();
                BeanUtils.copyProperties(tUser, users);
                userList.add(users);
            }
        }
        dataGrid.setTotal(userDao.count(countHql));
        dataGrid.setRows(userList);
        return dataGrid;
    }

    public Long userCount() {
        String hql = "select count(*) from TUser t";
        Long count = userDao.count(hql);
        return count;
    }

    public List userCountByMood() {
        String sql = "SELECT moodValue, COUNT(DISTINCT(id)) AS count\n" +
                "FROM t_mood \n" +
                "GROUP BY moodValue;";
        try {
            List list = moodDao.findInSql(sql);
            if (list != null && list.size() > 0) {
                return list;
            }
        } catch (BeansException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List moodCountByLocal() {
        String sql = "SELECT `local`,COUNT(moodValue)AS count FROM t_mood GROUP BY `local`;";
        try {
            List list = moodDao.findInSql(sql);
            if (list != null && list.size() > 0) {
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
