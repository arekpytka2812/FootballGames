package com.fg.footballgames.DAOs.Views;

public class Players_view {
    private String NAME;
    private String SURNAME;
    private String CLUB;
    private String POSITION;

    public Players_view() {
    }

    public Players_view(String NAME, String SURNAME, String CLUB, String POSITION) {
        this.NAME = NAME;
        this.SURNAME = SURNAME;
        this.CLUB = CLUB;
        this.POSITION = POSITION;
    }

    public String getNAME() {
        return NAME;
    }

    public String getSURNAME() {
        return SURNAME;
    }

    public String getCLUB() {
        return CLUB;
    }

    public String getPOSITION() {
        return POSITION;
    }
}
