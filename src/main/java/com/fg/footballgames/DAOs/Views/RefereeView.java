package com.fg.footballgames.DAOs.Views;

public class RefereeView {
    private String NAME;
    private String SURNAME;
    private String permissions;

    public RefereeView() {
    }

    public RefereeView(String NAME, String SURNAME, String permissions) {
        this.NAME = NAME;
        this.SURNAME = SURNAME;
        this.permissions = permissions;
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

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
}
