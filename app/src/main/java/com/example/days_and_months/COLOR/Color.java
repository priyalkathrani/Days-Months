package com.example.days_and_months.COLOR;

public class Color {
    private String mColorname;
    private int maudioResourceId;

    public Color(String colorname, int audioResourceId) {
        mColorname = colorname;
        maudioResourceId = audioResourceId;
    }

    public String getColorsName() {
        return mColorname;
    }

    public int getMaudioResourceId() {
        return maudioResourceId ;
    }
}
