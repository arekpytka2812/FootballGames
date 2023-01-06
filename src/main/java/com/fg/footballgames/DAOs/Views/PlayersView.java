package com.fg.footballgames.DAOs.Views;

public class PlayersView {
    private String NAME;
    private String SURNAME;
    private String CLUB;
    private String POSITION;

    public PlayersView() {
    }

    public PlayersView(String NAME, String SURNAME, String CLUB, String POSITION) {
        this.NAME = NAME;
        this.SURNAME = SURNAME;
        this.CLUB = CLUB;
        this.POSITION = POSITION;
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

    public String getCLUB() {
        return CLUB;
    }

    public void setCLUB(String CLUB) {
        this.CLUB = CLUB;
    }

    public String getPOSITION() {
        return POSITION;
    }

    public void setPOSITION(String POSITION) {
        this.POSITION = POSITION;
    }
}
