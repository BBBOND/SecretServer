package com.geekmadmen.secret.action;

import com.geekmadmen.secret.UImodel.Json;
import com.geekmadmen.secret.UImodel.User;
import com.geekmadmen.secret.UImodel.UserLog;
import com.geekmadmen.secret.service.UserServiceI;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 东 on 2016/4/12.
 */
@Action("userAction")
@Namespace("/")
public class UserLoginAction extends BaseAction implements ModelDriven<User> {
    private static final Logger logger = Logger.getLogger(ManagerAction.class);
    ActionContext context = ActionContext.getContext();
    private User user;
    private UserServiceI userService;

    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }

    public UserServiceI getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserServiceI userService) {
        this.userService = userService;
    }

    //    @Override
    public User getModel() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public void login() {
        Json json = new Json();
        UserLog userLog = new UserLog();
        user.setUserName("s");
        logger.info(user.getUserName());
        user.setUserPassword("s1");
        logger.info("--------------");
        logger.info(user.getUserPassword());
        logger.info("--------------");
        if (userService.userExist(user.getUserName()) == 101) {
            userLog.setStatus(101);
        }
        if (!userService.getPassword(user.getUserName()).equals("s1")) {
            userLog.setStatus(102);
        }
        User user1 = userService.login(user);
        if (user1 != null) {
            userLog.setStatus(100);
            userLog.setId(user1.getUserId());
          /*  json.setMessage("成功");
            json.setSuccess(true);
            json.setStatus(100);
            json.setObject(user1);*/
            context.getSession().put("userName", user1.getUserName());
            context.getSession().put("userId", user1.getUserId());
        } else {
            json.setMessage("登录失败！");
        }
        super.writeJson(userLog);
    }

    public void getUserListById() {
        User user1 = userService.getUserListById(1);
        super.writeJson(user1);
    }

    public void updateUser() {
        user.setEmail("1233");
//        user.
        int count = userService.updateUser(user);
    }
}
