package com.geekmadmen.secret.UImodel;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable {

    private String userId;
    private String userName;
    private String userPassword;
    private String userNickname;
    private String userAvatar;
    private String phone;
    private String email;
    private String register;
    private Timestamp createTime;

    private  int page;
    private  int rows;
    private int moodMin;
    private int moodMax;

    public int getMoodMin() {
        return moodMin;
    }

    public void setMoodMin(int moodMin) {
        this.moodMin = moodMin;
    }

    public int getMoodMax() {
        return moodMax;
    }

    public void setMoodMax(int moodMax) {
        this.moodMax = moodMax;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
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

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
