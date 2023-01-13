package com.fg.footballgames.DAOs.Views;

import com.fg.footballgames.DAOs.IDaoViewModel;

public class Goals_difference implements IDaoViewModel {
    private String CLUB;
    private String GOALS_SCORED;
    private String GOALS_CONCEDED;

    @Override
    public String[] getAll() {
        return new String[]{CLUB, GOALS_SCORED, GOALS_CONCEDED};
    }

    public Goals_difference() {
    }

    public Goals_difference(String CLUB, String GOALS_SCORED, String GOALS_CONCEDED) {
        this.CLUB = CLUB;
        this.GOALS_SCORED = GOALS_SCORED;
        this.GOALS_CONCEDED = GOALS_CONCEDED;
    }

    public String getCLUB() {
        return CLUB;
    }

    public String getGOALS_SCORED() {
        return GOALS_SCORED;
    }

    public String getGOALS_CONCEDED() {
        return GOALS_CONCEDED;
    }
}
