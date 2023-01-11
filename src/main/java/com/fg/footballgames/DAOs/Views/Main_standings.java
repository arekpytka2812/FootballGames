package com.fg.footballgames.DAOs.Views;

public class Main_standings {
    private String CLUB;
    private String POINTS;
    private String GOAL_DIFFERENCE;

    public Main_standings() {
    }

    public Main_standings(String CLUB, String POINTS, String GOAL_DIFFERENCE) {
        this.CLUB = CLUB;
        this.POINTS = POINTS;
        this.GOAL_DIFFERENCE = GOAL_DIFFERENCE;
    }

    public String getCLUB() {
        return CLUB;
    }

    public String getPOINTS() {
        return POINTS;
    }

    public String getGOAL_DIFFERENCE() {
        return GOAL_DIFFERENCE;
    }
}
