package com.fg.footballgames.DAOs.Views;

import com.fg.footballgames.DAOs.IDaoViewModel;

public class Coaches_view implements IDaoViewModel {
    private String NAME;
    private String SURNAME;
    private String CLUB;
    private String PERMISSIONS;
    private String ROLE;

    @Override
    public String[] getAll(){
        return new String[]{NAME, SURNAME, CLUB, PERMISSIONS, ROLE};
    }


    public Coaches_view() {
    }

    public Coaches_view(String NAME, String SURNAME, String CLUB, String PERMISSIONS, String ROLE) {
        this.NAME = NAME;
        this.SURNAME = SURNAME;
        this.CLUB = CLUB;
        this.PERMISSIONS = PERMISSIONS;
        this.ROLE = ROLE;
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

    public String getPERMISSIONS() {
        return PERMISSIONS;
    }

    public String getROLE() {
        return ROLE;
    }
}
