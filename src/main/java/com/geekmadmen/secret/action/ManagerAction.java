package com.geekmadmen.secret.action;

import com.geekmadmen.secret.UImodel.Json;
import com.geekmadmen.secret.UImodel.Manager;
import com.geekmadmen.secret.UImodel.User;
import com.geekmadmen.secret.service.ManagerServiceI;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * Created by 东 on 2016/3/12.
 */
//@ParentPackage("basePackage")
@Action("managerAction")
//@Scope("prototype")
@Namespace("/")
public class ManagerAction extends BaseAction implements ModelDriven<Manager> {
    ActionContext context = ActionContext.getContext();
    private static final Logger logger = Logger.getLogger(ManagerAction.class);


    public void test() {
        logger.info("----->ManagerAction do test");
    }

    private Manager manager;
//    private User user=new User();


    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    private ManagerServiceI managerService;

    public ManagerServiceI getManagerService() {
        return managerService;
    }

    @Autowired
    public void setManagerService(ManagerServiceI managerService) {
        this.managerService = managerService;
    }

    public Manager getModel() {
        if (manager == null)
            manager = new Manager();
        return manager;
    }

    /**
     * 管理员登录
     *
     * @return
     * @throws Exception
     */
    public void login() throws Exception {
        Json json = new Json();
        try {
           /* logger.info("------------------------");
            logger.info(manager.getManagerName());
            logger.info("------------------------");
            logger.info(manager.getManagerPassword());*/
            Manager mg = managerService.login(manager);
            if (mg != null) {
               /* logger.info("------------------------");
                logger.info(mg.getManagerName());*/
                json.setSuccess(true);
                json.setMessage("登录成功！");
                context.getSession().put("managername", manager.getManagerName());
                context.getSession().put("managerpassword", manager.getManagerPassword());
                logger.info(context.getSession().get("managername").toString());
            } else {
                json.setMessage("登录失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.setMessage("登录失败，服务器出现问题！");
        } finally {
            super.writeJson(json);
        }
    }

    public String logout() {
        if (context.getSession() != null)
            context.getSession().clear();
        return null;
    }

    public List<Manager> selectAllManager() {
        Json json = new Json();
        Manager mg = new Manager();
        try {
            List<Manager> manager = managerService.listAllManager();
            if (manager != null && manager.size() > 0) {
                json.setSuccess(true);
                json.setMessage("成功");
                return manager;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            super.writeJson(json);
        }
        return null;

    }

    public Manager selectManagerById() {
        Json json = new Json();
        try {
            Manager manager = managerService.listManagerById(1);
            if (manager != null) {
                json.setSuccess(true);
                json.setMessage("成功！");
                logger.info(manager.getManagerName());
                logger.info("----------------------");
                logger.info(manager.getManagerPassword());
                return manager;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            super.writeJson(json);
        }
        return null;
    }
    public List<User> selectAllUser(){
        Json json=new Json();
        User user=new User();
        try {
            List<User> userList=managerService.listAllUser();
            if (userList!=null&&userList.size()>0){
                json.setSuccess(true);
                json.setMessage("成功！");
               /* for (int i=0;i<userList.size();i++){
                    user=userList.get(i);
                    logger.info("----------------------");
                    logger.info(user);
                    logger.info("----------------------");
                }*/
                super.writeJson(userList);
                return userList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return null;
    }
    public User selectUserById(){
        Json json=new Json();
        try {
            User user=managerService.listUserById(1);
            if (user!=null){
                logger.info("----------------------");
                logger.info(user.getUserName());
                logger.info("----------------------");
                logger.info(user.getUserPassword());
                json.setMessage("成功！");
                return user;
            }else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            super.writeJson(json);
        }
        return null;
    }

}
