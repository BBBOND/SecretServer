package com.geekmadmen.secret.UImodel;

/**
 * Created by 东 on 2016/3/19.
 */
public class Json {
    private  boolean success=false;
    private  String message="";
    private Object object=null;
    private int status=0;
    public boolean isSuccess() {
        return success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
