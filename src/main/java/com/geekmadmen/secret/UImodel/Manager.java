package com.geekmadmen.secret.UImodel;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by 东 on 2016/3/12.
 */
public class Manager implements Serializable {

    private String managerId;
    private String managerName;
    private String managerPassword;
    private String userAvatar;
    private String phone;
    private String email;
    private Timestamp createTime;
    private String managerRank;

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName.trim();
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword.trim();
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getManagerRank() {
        return managerRank;
    }

    public void setManagerRank(String managerRank) {
        this.managerRank = managerRank;
    }
}
