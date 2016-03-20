package com.geekmadmen.secret.service.impl;

import com.geekmadmen.secret.UImodel.Manager;
import com.geekmadmen.secret.UImodel.User;
import com.geekmadmen.secret.dao.ManagerDaoI;
import com.geekmadmen.secret.model.TManager;
import com.geekmadmen.secret.model.TUser;
import com.geekmadmen.secret.service.ManagerServiceI;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
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

    ManagerDaoI managerDao = null;

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
       /* logger.info("----------------------");
        logger.info(manager.getManagerName());
        logger.info("----------------------");
        logger.info(manager.getManagerPassword());*/

        String hql = "from TManager tm where tm.managerName=:managerName and tm.managerPassword=:managerPassword";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("managerName", manager.getManagerName());
        map.put("managerPassword", manager.getManagerPassword());
        TManager tManager = managerDao.get(hql, map);
        /*logger.info("----------------------");
        logger.info(tManager);*/
        if (tManager != null) {
            Manager manager1 = new Manager();
            BeanUtils.copyProperties(tManager, manager1);
            return manager1;
        } else
            return null;
    }

    public List<User> listAllUser() {
        String hql = "from TUser t";
        List<TUser> tUser = managerDao.getAllUser(hql);
        List<User> users = new ArrayList<User>();
        if (tUser!=null&&tUser.size()>0){
            for (TUser tu:tUser){
                User user=new User();
                BeanUtils.copyProperties(tu,user);
                users.add(user);
            }
        }
        return users;
    }

    public User listUserById(int userId) {
        User user=new User();
        String hql="from TUser t where t.userId="+userId;
        TUser tUser=managerDao.getUser(hql);
        if (tUser!=null){
            BeanUtils.copyProperties(tUser,user);
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
}
