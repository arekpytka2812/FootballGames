package com.fg.footballgames.DAOs.Views;

public class StatsView {
    private String NAME;
    private String SURNAME;
    private String GOALS;
    private String ASSISTS;
    private String YELLOW_CARDS;
    private String RED_CARDS;

    public StatsView() {
    }

    public StatsView(String NAME, String SURNAME, String GOALS, String ASSISTS, String YELLOW_CARDS, String RED_CARDS) {
        this.NAME = NAME;
        this.SURNAME = SURNAME;
        this.GOALS = GOALS;
        this.ASSISTS = ASSISTS;
        this.YELLOW_CARDS = YELLOW_CARDS;
        this.RED_CARDS = RED_CARDS;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getSURNAME() {
        return SURNAME;
    }

    public void setSURNAME(String SURNAME) {
        this.SURNAME = SURNAME;
    }

    public String getGOALS() {
        return GOALS;
    }

    public void setGOALS(String GOALS) {
        this.GOALS = GOALS;
    }

    public String getASSISTS() {
        return ASSISTS;
    }

    public void setASSISTS(String ASSISTS) {
        this.ASSISTS = ASSISTS;
    }

    public String getYELLOW_CARDS() {
        return YELLOW_CARDS;
    }

    public void setYELLOW_CARDS(String YELLOW_CARDS) {
        this.YELLOW_CARDS = YELLOW_CARDS;
    }

    public String getRED_CARDS() {
        return RED_CARDS;
    }

    public void setRED_CARDS(String RED_CARDS) {
        this.RED_CARDS = RED_CARDS;
    }
}
