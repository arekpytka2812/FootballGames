package com.fg.footballgames.DAOs.Views;

import com.fg.footballgames.DAOs.IDaoViewModel;

public class Referees_view implements IDaoViewModel {
    private String REFEREE_NAME;
    private String SURNAME;
    private String PERMISSIONS;

    @Override
    public String[] getAll() {
        return new String[]{REFEREE_NAME, SURNAME, PERMISSIONS};
    }

    public Referees_view() {
    }

    public Referees_view(String REFEREE_NAME, String SURNAME, String PERMISSIONS) {
        this.REFEREE_NAME = REFEREE_NAME;
        this.SURNAME = SURNAME;
        this.PERMISSIONS = PERMISSIONS;
    }

    public String getREFEREE_NAME() {
        return REFEREE_NAME;
    }

    public String getSURNAME() {
        return SURNAME;
    }

    public String getPERMISSIONS() {
        return PERMISSIONS;
    }
}
