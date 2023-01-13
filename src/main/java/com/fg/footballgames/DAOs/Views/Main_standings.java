package com.fg.footballgames.DAOs.Views;

import com.fg.footballgames.DAOs.IDaoViewModel;

public class Main_standings implements IDaoViewModel {
    private String CLUB;
    private String POINTS;
    private String GOAL_DIFFERENCE;

    @Override
    public String[] getAll() {
        return new String[]{CLUB, POINTS, GOAL_DIFFERENCE};
    }

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
