package com.geekmadmen.secret.UImodel;

/**
 * Created by 东 on 2016/4/20.
 */
public class UserLog {
    private String id;
    private int status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserLog{" +
                "id='" + id + '\'' +
                ", status=" + status +
                '}';
    }
}
