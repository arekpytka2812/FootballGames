package com.fg.footballgames.DAOs.Views;

public class Referees_view {
    private String NAME;
    private String SURNAME;
    private String permissions;

    public Referees_view() {
    }

    public Referees_view(String NAME, String SURNAME, String permissions) {
        this.NAME = NAME;
        this.SURNAME = SURNAME;
        this.permissions = permissions;
    }

    public String getNAME() {
        return NAME;
    }

    public String getSURNAME() {
        return SURNAME;
    }

    public String getPermissions() {
        return permissions;
    }
}
