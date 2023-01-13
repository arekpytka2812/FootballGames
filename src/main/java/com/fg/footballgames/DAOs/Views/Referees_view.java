package com.fg.footballgames.DAOs.Views;

import com.fg.footballgames.DAOs.IDaoViewModel;

public class Referees_view implements IDaoViewModel {
    private String NAME;
    private String SURNAME;
    private String permissions;

    @Override
    public String[] getAll() {
        return new String[]{NAME, SURNAME, permissions};
    }

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
