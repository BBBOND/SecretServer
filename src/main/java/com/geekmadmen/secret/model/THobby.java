package com.geekmadmen.secret.model;

import javax.persistence.*;

/**
 * Created by 伟阳 on 2016/3/9.
 */
@Entity
@Table(name = "t_hobby", schema = "secret", catalog = "")
public class THobby {
    private String hobbyId;
    private String hobby;

    @Id
    @Column(name = "hobbyId", nullable = false, length = 32)
    public String getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(String hobbyId) {
        this.hobbyId = hobbyId;
    }

    @Basic
    @Column(name = "hobby", nullable = true, length = 20)
    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        THobby tHobby = (THobby) o;

        if (hobbyId != null ? !hobbyId.equals(tHobby.hobbyId) : tHobby.hobbyId != null) return false;
        if (hobby != null ? !hobby.equals(tHobby.hobby) : tHobby.hobby != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hobbyId != null ? hobbyId.hashCode() : 0;
        result = 31 * result + (hobby != null ? hobby.hashCode() : 0);
        return result;
    }
}
