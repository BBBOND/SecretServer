package com.geekmadmen.secret.service.impl;

import com.geekmadmen.secret.UImodel.Manager;
import com.geekmadmen.secret.UImodel.User;
import com.geekmadmen.secret.dao.ManagerDaoI;
import com.geekmadmen.secret.model.TManager;
import com.geekmadmen.secret.service.ManagerServiceI;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 东 on 2016/3/12.
 */
@Service("managerService")
public class ManagerServiceImpl implements ManagerServiceI {
    private static final Logger logger=Logger.getLogger(ManagerServiceImpl.class);
    public void  test(){
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

    public String logout() {
        return null;
    }

    public TManager login(Manager manager) {
//        logger.info("-------------------");
//        logger.info(manager.getManagerName());
//        logger.info(manager.getManagerPassword());
        TManager tManager = new TManager();
        BeanUtils.copyProperties(manager,tManager,"userId","userNickname","");
        String hql="from TManager tm where tm.managerName=:managerName and tm.managerPassword=:managerPassword";
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("managerName",manager.getManagerName());
        map.put("managerPassword",manager.getManagerPassword());
        TManager tmg=  managerDao.get(hql,map);
        logger.info(tmg);
        if (tmg!=null){
//            Manager mg=new Manager();
//            BeanUtils.copyProperties(tmg,mg);
            return  tmg;
        }
        else
            return  null;
    }

    public List<User> listAllUser() {
        return null;
    }

    public List<User> listUserById(int userId) {
        return null;
    }

    public List<Manager> listAllManager() {
        return null;
    }

    public List<Manager> listManagerById(int managerId) {
        return null;
    }

    public int countOfOneDayEveryMonth() {
        return 0;
    }

    public int countOneAera() {
        return 0;
    }
}
