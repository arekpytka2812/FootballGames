package com.fg.footballgames.DAOs.Views;

import com.fg.footballgames.DAOs.IDaoViewModel;

public class Stats_view implements IDaoViewModel {
    private String NAME;
    private String SURNAME;
    private String GOALS;
    private String ASSISTS;
    private String YELLOW_CARDS;
    private String RED_CARDS;

    @Override
    public String[] getAll() {
        return new String[]{NAME, SURNAME, GOALS, ASSISTS, YELLOW_CARDS, RED_CARDS};
    }

    public Stats_view() {
    }

    public Stats_view(String NAME, String SURNAME, String GOALS, String ASSISTS, String YELLOW_CARDS, String RED_CARDS) {
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

    public String getSURNAME() {
        return SURNAME;
    }

    public String getGOALS() {
        return GOALS;
    }

    public String getASSISTS() {
        return ASSISTS;
    }

    public String getYELLOW_CARDS() {
        return YELLOW_CARDS;
    }

    public String getRED_CARDS() {
        return RED_CARDS;
    }
}
