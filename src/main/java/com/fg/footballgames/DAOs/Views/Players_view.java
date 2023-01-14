package com.fg.footballgames.DAOs.Views;

import com.fg.footballgames.DAOs.IDaoViewModel;

public class Players_view implements IDaoViewModel {
    private String NAME;
    private String SURNAME;
    private String CLUB;
    private String POSITION;

    @Override
    public String[] getAll() {
        return new String[]{NAME, SURNAME, CLUB, POSITION};
    }

    public Players_view() {
    }

    public Players_view(String NAME, String SURNAME, String CLUB, String POSITION) {
        this.NAME = NAME;
        this.SURNAME = SURNAME;
        this.CLUB = CLUB;
        this.POSITION = POSITION;
    }

    public String getPlayerName() {
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
