package com.example.days_and_months.SEASON;

public class Season {
    private String mSeasonname;
    private int maudioResourceId;

    public Season(String seasonname, int audioResourceId) {
        mSeasonname = seasonname;
        maudioResourceId = audioResourceId;
    }

    public String getSeasonName() {
        return mSeasonname;
    }

    public int getMaudioResourceId() {
        return maudioResourceId ;
    }
}
