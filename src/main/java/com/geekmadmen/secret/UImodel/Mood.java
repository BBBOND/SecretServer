package com.geekmadmen.secret.UImodel;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by 东 on 2016/4/6.
 */
public class Mood  implements Serializable{
    private String id;
    private String userId;
    private String moodText;
    private String local;
    private Timestamp time;
    private String weather;
    private String tag;
    private Integer moodValue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMoodText() {
        return moodText;
    }

    public void setMoodText(String moodText) {
        this.moodText = moodText;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getMoodValue() {
        return moodValue;
    }

    public void setMoodValue(Integer moodValue) {
        this.moodValue = moodValue;
    }

    @Override
    public String toString() {
        return "Mood{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", moodText='" + moodText + '\'' +
                ", local='" + local + '\'' +
                ", time=" + time +
                ", weather='" + weather + '\'' +
                ", tag='" + tag + '\'' +
                ", moodValue=" + moodValue +
                '}';
    }
}
