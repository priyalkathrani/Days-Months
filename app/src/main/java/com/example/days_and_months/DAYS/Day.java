package com.example.days_and_months.DAYS;

public class Day {
    private String mDayname;
    private int maudioResourceId;

    public Day(String dayname, int audioResourceId) {
        mDayname = dayname;
        maudioResourceId = audioResourceId;
    }

    public String getDaysName() {
        return mDayname;
    }

    public int getMaudioResourceId() {
        return maudioResourceId ;
    }
}
