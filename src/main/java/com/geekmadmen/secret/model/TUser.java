package com.geekmadmen.secret.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by 伟阳 on 2016/3/9.
 */
@Entity
@Table(name = "t_user", schema = "secret", catalog = "")
public class TUser {
    private String userId;
    private String userName;
    private String userPassword;
    private String userNickname;
    private String userAvatar;
    private String phone;
    private String email;
    //是否注册成功
    private String register;
    private Timestamp createTime;
    //验证码
    private String acticode;

    @Id
    @Column(name = "userId", nullable = false, length = 32)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "userName", nullable = true, length = 20)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "userPassword", nullable = true, length = 64)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "userNickname", nullable = true, length = 20)
    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    @Basic
    @Column(name = "userAvatar", nullable = true, length = 100)
    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 40)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "register", nullable = true, length = 2)
    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    @Basic
    @Column(name = "createTime", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "acticode", nullable = true, length = 255)
    public String getActicode() {
        return acticode;
    }

    public void setActicode(String acticode) {
        this.acticode = acticode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TUser tUser = (TUser) o;

        if (userId != null ? !userId.equals(tUser.userId) : tUser.userId != null) return false;
        if (userName != null ? !userName.equals(tUser.userName) : tUser.userName != null) return false;
        if (userPassword != null ? !userPassword.equals(tUser.userPassword) : tUser.userPassword != null) return false;
        if (userNickname != null ? !userNickname.equals(tUser.userNickname) : tUser.userNickname != null) return false;
        if (userAvatar != null ? !userAvatar.equals(tUser.userAvatar) : tUser.userAvatar != null) return false;
        if (phone != null ? !phone.equals(tUser.phone) : tUser.phone != null) return false;
        if (email != null ? !email.equals(tUser.email) : tUser.email != null) return false;
        if (register != null ? !register.equals(tUser.register) : tUser.register != null) return false;
        if (createTime != null ? !createTime.equals(tUser.createTime) : tUser.createTime != null) return false;
        return acticode != null ? acticode.equals(tUser.acticode) : tUser.acticode == null;

    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userNickname != null ? userNickname.hashCode() : 0);
        result = 31 * result + (userAvatar != null ? userAvatar.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (register != null ? register.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (acticode != null ? acticode.hashCode() : 0);
        return result;
    }
}
