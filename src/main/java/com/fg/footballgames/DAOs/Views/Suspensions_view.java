package com.fg.footballgames.DAOs.Views;

import com.fg.footballgames.DAOs.IDaoViewModel;

public class Suspensions_view implements IDaoViewModel {
    private String PLAYER_NAME;
    private String SURNAME;
    private String CLUBS;
    private String SUS_TYPE;
    private String RECEIVED_MATCH;
    private String RETURN_MATCH;

    @Override
    public String[] getAll() {
        return new String[]{PLAYER_NAME, SURNAME, CLUBS, SUS_TYPE, RECEIVED_MATCH, RETURN_MATCH};
    }

    public Suspensions_view() {
    }

    public Suspensions_view(String PLAYER_NAME, String SURNAME, String CLUBS, String SUS_TYPE, String RECEIVED_MATCH, String RETURN_MATCH) {
        this.PLAYER_NAME = PLAYER_NAME;
        this.SURNAME = SURNAME;
        this.CLUBS = CLUBS;
        this.SUS_TYPE = SUS_TYPE;
        this.RECEIVED_MATCH = RECEIVED_MATCH;
        this.RETURN_MATCH = RETURN_MATCH;
    }

    public String getPLAYER_NAME() {
        return PLAYER_NAME;
    }

    public String getSURNAME() {
        return SURNAME;
    }

    public String getCLUBS() {
        return CLUBS;
    }

    public String getSUS_TYPE() {
        return SUS_TYPE;
    }

    public String getRECEIVED_MATCH() {
        return RECEIVED_MATCH;
    }

    public String getRETURN_MATCH() {
        return RETURN_MATCH;
    }
}
