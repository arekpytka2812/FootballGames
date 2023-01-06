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

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getSURNAME() {
        return SURNAME;
    }

    public void setSURNAME(String SURNAME) {
        this.SURNAME = SURNAME;
    }

    public String getCLUBS() {
        return CLUBS;
    }

    public void setCLUBS(String CLUBS) {
        this.CLUBS = CLUBS;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getRECEIVED_MATCH() {
        return RECEIVED_MATCH;
    }

    public void setRECEIVED_MATCH(String RECEIVED_MATCH) {
        this.RECEIVED_MATCH = RECEIVED_MATCH;
    }

    public String getRETURN_MATCH() {
        return RETURN_MATCH;
    }

    public void setRETURN_MATCH(String RETURN_MATCH) {
        this.RETURN_MATCH = RETURN_MATCH;
    }
}
