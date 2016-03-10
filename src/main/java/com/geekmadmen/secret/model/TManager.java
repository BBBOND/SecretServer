package com.geekmadmen.secret.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by 伟阳 on 2016/3/10.
 */
@Entity
@Table(name = "t_manager", schema = "secret", catalog = "")
public class TManager {
    private String managerId;
    private String managerName;
    private String managerPassword;
    private String userAvatar;
    private String phone;
    private String email;
    private Timestamp createTime;
    private String managerRank;

    @Id
    @Column(name = "managerId", nullable = false, length = 32)
    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    @Basic
    @Column(name = "managerName", nullable = true, length = 20)
    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    @Basic
    @Column(name = "managerPassword", nullable = true, length = 64)
    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
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
    @Column(name = "createTime", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "managerRank", nullable = true, length = 2)
    public String getManagerRank() {
        return managerRank;
    }

    public void setManagerRank(String managerRank) {
        this.managerRank = managerRank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TManager tManager = (TManager) o;

        if (managerId != null ? !managerId.equals(tManager.managerId) : tManager.managerId != null) return false;
        if (managerName != null ? !managerName.equals(tManager.managerName) : tManager.managerName != null) return false;
        if (managerPassword != null ? !managerPassword.equals(tManager.managerPassword) : tManager.managerPassword != null) return false;
        if (userAvatar != null ? !userAvatar.equals(tManager.userAvatar) : tManager.userAvatar != null) return false;
        if (phone != null ? !phone.equals(tManager.phone) : tManager.phone != null) return false;
        if (email != null ? !email.equals(tManager.email) : tManager.email != null) return false;
        if (createTime != null ? !createTime.equals(tManager.createTime) : tManager.createTime != null) return false;
        if (managerRank != null ? !managerRank.equals(tManager.managerRank) : tManager.managerRank != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = managerId != null ? managerId.hashCode() : 0;
        result = 31 * result + (managerName != null ? managerName.hashCode() : 0);
        result = 31 * result + (managerPassword != null ? managerPassword.hashCode() : 0);
        result = 31 * result + (userAvatar != null ? userAvatar.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (managerRank != null ? managerRank.hashCode() : 0);
        return result;
    }
}
