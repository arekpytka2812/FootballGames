package com.fg.footballgames.DAOs.Views;

import com.fg.footballgames.DAOs.IDaoViewModel;

public class Suspensions_view implements IDaoViewModel {
    private String NAME;
    private String SURNAME;
    private String CLUBS;
    private String TYPE;
    private String RECEIVED_MATCH;
    private String RETURN_MATCH;

    @Override
    public String[] getAll() {
        return new String[]{NAME, SURNAME, CLUBS, TYPE, RECEIVED_MATCH, RETURN_MATCH};
    }

    public Suspensions_view() {
    }

    public Suspensions_view(String NAME, String SURNAME, String CLUBS, String TYPE, String RECEIVED_MATCH, String RETURN_MATCH) {
        this.NAME = NAME;
        this.SURNAME = SURNAME;
        this.CLUBS = CLUBS;
        this.TYPE = TYPE;
        this.RECEIVED_MATCH = RECEIVED_MATCH;
        this.RETURN_MATCH = RETURN_MATCH;
    }

    public String getNAME() {
        return NAME;
    }

    public String getSURNAME() {
        return SURNAME;
    }

    public String getCLUBS() {
        return CLUBS;
    }

    public String getTYPE() {
        return TYPE;
    }

    public String getRECEIVED_MATCH() {
        return RECEIVED_MATCH;
    }

    public String getRETURN_MATCH() {
        return RETURN_MATCH;
    }
}
