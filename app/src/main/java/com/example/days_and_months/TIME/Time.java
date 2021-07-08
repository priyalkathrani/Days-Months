package com.example.days_and_months.TIME;

public class Time {
    private String mTimename;
    private int maudioResourceId;

    public Time(String timename, int audioResourceId) {
        mTimename = timename;
        maudioResourceId = audioResourceId;
    }

    public String getTime() {
        return mTimename;
    }

    public int getMaudioResourceId() {
        return maudioResourceId ;
    }
}
