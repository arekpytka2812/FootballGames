package com.fg.footballgames.DAOs.Views;

public class SuspensionsView {
    private String NAME;
    private String SURNAME;
    private String CLUBS;
    private String TYPE;
    private String RECEIVED_MATCH;
    private String RETURN_MATCH;

    public SuspensionsView() {
    }

    public SuspensionsView(String NAME, String SURNAME, String CLUBS, String TYPE, String RECEIVED_MATCH, String RETURN_MATCH) {
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
