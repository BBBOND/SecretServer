package com.geekmadmen.secret.UImodel;

/**
 * Created by 东 on 2016/4/6.
 */
public class MoodValue {
    private int moodValue;
    private int count;

    public MoodValue(int moodValue, int count) {
        this.moodValue = moodValue;
        this.count = count;
    }

    public int getMoodValue() {
        return moodValue;
    }

    public void setMoodValue(int moodValue) {
        this.moodValue = moodValue;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "MoodValue{" +
                "moodValue=" + moodValue +
                ", count=" + count +
                '}';
    }
}
