package com.fg.footballgames.DAOs.Views;

import com.fg.footballgames.DAOs.IDaoViewModel;

public class Suspensions_count implements IDaoViewModel {

    private String PLAYER_NAME;
    private String SURNAME;
    private String NUMBER_OF_SUSPENSIONS;

    @Override
    public String[] getAll(){
        return new String[]{PLAYER_NAME, SURNAME, NUMBER_OF_SUSPENSIONS};
    }

    public Suspensions_count() {
    }

    public Suspensions_count(String PLAYER_NAME, String SURNAME, String NUMBER_OF_SUSPENSIONS) {
        this.PLAYER_NAME = PLAYER_NAME;
        this.SURNAME = SURNAME;
        this.NUMBER_OF_SUSPENSIONS = NUMBER_OF_SUSPENSIONS;
    }

    public String getPLAYER_NAME() {
        return PLAYER_NAME;
    }

    public String getSURNAME() {
        return SURNAME;
    }

    public String getNUMBER_OF_SUSPENSIONS() {
        return NUMBER_OF_SUSPENSIONS;
    }
}
