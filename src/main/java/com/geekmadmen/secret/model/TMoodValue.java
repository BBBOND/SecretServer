package com.geekmadmen.secret.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by 伟阳 on 2016/3/9.
 */
@Entity
@Table(name = "t_mood_value", schema = "secret", catalog = "")
public class TMoodValue {
    private String id;
    private String userId;
    private Timestamp time;
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
    @Column(name = "time", nullable = false)
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
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

        TMoodValue that = (TMoodValue) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (moodValue != null ? !moodValue.equals(that.moodValue) : that.moodValue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (moodValue != null ? moodValue.hashCode() : 0);
        return result;
    }
}
