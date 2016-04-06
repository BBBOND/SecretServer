package com.geekmadmen.secret.action;

import com.geekmadmen.secret.UImodel.User;
import com.geekmadmen.secret.service.ManagerServiceI;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by 东 on 2016/4/5.
 */
@Action("managerUserAction")
@Namespace("/")
public class ManagerUserAction extends BaseAction implements ModelDriven<User> {
    private static final Logger logger = Logger.getLogger(ManagerAction.class);
    private User user;

    private ManagerServiceI managerService;

    public ManagerServiceI getManagerService() {
        return managerService;
    }

    @Autowired
    public void setManagerService(ManagerServiceI managerService) {
        this.managerService = managerService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public User getModel() {
        if (user == null) {
            user = new User();
        }
        return user;
    }
    public void datagrid() {
        super.writeJson(managerService.datagrid(user));
        logger.info(user.getPage());
        logger.info("-----------------");
        logger.info(user.getRows());
    }
    public void userCount(){
//        long count=managerService.userCount();
        Long count=new Long(managerService.userCount());
        super.writeJson(count);
    }
    public void userCountByMood(){
        logger.info("--------------------");
        List list=managerService.userCountByMood();
//        logger.info(list.get(0).getClass().getClasses());
        super.writeJson(list);
    }
}
