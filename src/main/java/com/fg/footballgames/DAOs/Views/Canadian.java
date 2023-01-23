package com.fg.footballgames.DAOs.Views;

import com.fg.footballgames.DAOs.IDaoViewModel;

public class Canadian implements IDaoViewModel {
    private String PLAYER_NAME;
    private String SURNAME;
    private String CONTRIBUTION;

    @Override
    public String[] getAll(){
        return new String[]{PLAYER_NAME, SURNAME, CONTRIBUTION};
    }

    public Canadian() {
    }

    public Canadian(String PLAYER_NAME, String SURNAME, String CONTRIBUTION) {
        this.PLAYER_NAME = PLAYER_NAME;
        this.SURNAME = SURNAME;
        this.CONTRIBUTION = CONTRIBUTION;
    }

    public String getPLAYER_NAME() {
        return PLAYER_NAME;
    }

    public String getSURNAME() {
        return SURNAME;
    }

    public String getCONTRIBUTION() {
        return CONTRIBUTION;
    }
}
