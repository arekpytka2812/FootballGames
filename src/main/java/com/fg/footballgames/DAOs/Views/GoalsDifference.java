package com.fg.footballgames.DAOs.Views;

public class GoalsDifference{
    private String CLUB;
    private String GOALS_SCORED;
    private String GOALS_CONCEDED;

    public GoalsDifference() {
    }

    public GoalsDifference(String CLUB, String GOALS_SCORED, String GOALS_CONCEDED) {
        this.CLUB = CLUB;
        this.GOALS_SCORED = GOALS_SCORED;
        this.GOALS_CONCEDED = GOALS_CONCEDED;
    }

    public String getCLUB() {
        return CLUB;
    }

    public void setCLUB(String CLUB) {
        this.CLUB = CLUB;
    }

    public String getGOALS_SCORED() {
        return GOALS_SCORED;
    }

    public void setGOALS_SCORED(String GOALS_SCORED) {
        this.GOALS_SCORED = GOALS_SCORED;
    }

    public String getGOALS_CONCEDED() {
        return GOALS_CONCEDED;
    }

    public void setGOALS_CONCEDED(String GOALS_CONCEDED) {
        this.GOALS_CONCEDED = GOALS_CONCEDED;
    }
}
