package com.geekmadmen.secret.action;

import com.geekmadmen.secret.UImodel.Manager;
import com.geekmadmen.secret.service.ManagerServiceI;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


/**
 * Created by 东 on 2016/3/12.
 */
@SuppressWarnings("serial")
@Controller("managerAction")
@Scope("prototype")
@Namespace("/")
public class ManagerAction extends ActionSupport implements ModelDriven<Manager> {
    private static final Logger logger=Logger.getLogger(ManagerAction.class);


    public void test(){
        logger.info("----->ManagerAction do test");
    }
    private Manager manager;

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    private ManagerServiceI managerService;
    private int managerid;
    private int userid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getManagerid() {
        return managerid;
    }

    public void setManagerid(int managerid) {
        this.managerid = managerid;
    }

    public ManagerServiceI getManagerService() {
        return managerService;
    }

    @Autowired
    public void setManagerService(ManagerServiceI managerService) {
        this.managerService = managerService;
    }

    public Manager getModel() {
        if (manager==null)
            manager=new Manager();
        return manager;
    }

    /**
     * 管理员登录
     * @return
     * @throws Exception
     */
    public String login() throws Exception{

        logger.info("-------------------------------------");
        logger.info(manager.getManagerName());
        logger.info("-------------------------------------");
        logger.info(managerService.login(manager).getManagerName());
        logger.info("-------------------------------------");

        if (managerService.login(manager)!=null){

            logger.info("----------------------------------");
            logger.info(managerService.login(manager).getManagerPassword());

            ActionContext.getContext().getSession().put("managerName",manager.getManagerName());
            ActionContext.getContext().getSession().put("managerPassword",manager.getManagerPassword());
            return SUCCESS;
        }
        else
            return ERROR;
    }



}
