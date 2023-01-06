package com.fg.footballgames.DAOs.Views;

public class MainStandingsView {
    private String CLUB;
    private String POINTS;
    private String GOAL_DIFFERENCE;

    public MainStandingsView() {
    }

    public MainStandingsView(String CLUB, String POINTS, String GOAL_DIFFERENCE) {
        this.CLUB = CLUB;
        this.POINTS = POINTS;
        this.GOAL_DIFFERENCE = GOAL_DIFFERENCE;
    }

    public String getCLUB() {
        return CLUB;
    }

    public void setCLUB(String CLUB) {
        this.CLUB = CLUB;
    }

    public String getPOINTS() {
        return POINTS;
    }

    public void setPOINTS(String POINTS) {
        this.POINTS = POINTS;
    }

    public String getGOAL_DIFFERENCE() {
        return GOAL_DIFFERENCE;
    }

    public void setGOAL_DIFFERENCE(String GOAL_DIFFERENCE) {
        this.GOAL_DIFFERENCE = GOAL_DIFFERENCE;
    }
}
