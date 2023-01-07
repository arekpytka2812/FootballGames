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

    public String getSURNAME() {
        return SURNAME;
    }

    public String getPermissions() {
        return permissions;
    }
}
