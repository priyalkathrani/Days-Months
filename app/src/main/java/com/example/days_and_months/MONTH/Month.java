package com.example.days_and_months.MONTH;

public class Month {

    private String mMonthname, mMonthday;
    private int maudioResourceId;

    public Month(String monthname, String monthday, int audioResourceId) {
        mMonthname = monthname;
        mMonthday = monthday;
        maudioResourceId = audioResourceId;
    }

    public String getMontName() {
        return mMonthname;
    }

    public String getMontDays() {
        return mMonthday;
    }

    public int getMaudioResourceId() {
        return maudioResourceId ;
    }

}
