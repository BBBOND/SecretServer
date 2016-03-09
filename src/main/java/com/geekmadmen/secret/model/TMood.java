package com.geekmadmen.secret.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by 伟阳 on 2016/3/9.
 */
@Entity
@Table(name = "t_mood", schema = "secret", catalog = "")
public class TMood {
    private String id;
    private String userId;
    private String moodText;
    private String local;
    private Timestamp time;
    private String weather;
    private String tag;
    private Integer moodValue;

    @Id
    @Column(name = "id", nullable = false, length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userId", nullable = true, length = 32)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "moodText", nullable = true, length = 255)
    public String getMoodText() {
        return moodText;
    }

    public void setMoodText(String moodText) {
        this.moodText = moodText;
    }

    @Basic
    @Column(name = "local", nullable = true, length = 100)
    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Basic
    @Column(name = "time", nullable = false)
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "weather", nullable = true, length = 20)
    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Basic
    @Column(name = "tag", nullable = true, length = 2)
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Basic
    @Column(name = "moodValue", nullable = true)
    public Integer getMoodValue() {
        return moodValue;
    }

    public void setMoodValue(Integer moodValue) {
        this.moodValue = moodValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TMood tMood = (TMood) o;

        if (id != null ? !id.equals(tMood.id) : tMood.id != null) return false;
        if (userId != null ? !userId.equals(tMood.userId) : tMood.userId != null) return false;
        if (moodText != null ? !moodText.equals(tMood.moodText) : tMood.moodText != null) return false;
        if (local != null ? !local.equals(tMood.local) : tMood.local != null) return false;
        if (time != null ? !time.equals(tMood.time) : tMood.time != null) return false;
        if (weather != null ? !weather.equals(tMood.weather) : tMood.weather != null) return false;
        if (tag != null ? !tag.equals(tMood.tag) : tMood.tag != null) return false;
        if (moodValue != null ? !moodValue.equals(tMood.moodValue) : tMood.moodValue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (moodText != null ? moodText.hashCode() : 0);
        result = 31 * result + (local != null ? local.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (weather != null ? weather.hashCode() : 0);
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        result = 31 * result + (moodValue != null ? moodValue.hashCode() : 0);
        return result;
    }
}
