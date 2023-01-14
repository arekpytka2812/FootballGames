package com.fg.footballgames.DAOs.Views;

import com.fg.footballgames.DAOs.IDaoViewModel;

public class Stadiums_view implements IDaoViewModel {
    private String NAME;
    private String CAPACITY;
    private String CITY;
    private String ADDRESS;
    private String PITCH_LENGTH;
    private String PITCH_WIDTH;
    private String YEAR_OF_BUILT;

    @Override
    public String[] getAll() {
        return new String[]{NAME, CAPACITY, CITY, ADDRESS, PITCH_LENGTH, PITCH_WIDTH, YEAR_OF_BUILT};
    }

    public Stadiums_view() {
    }

    public Stadiums_view(String NAME, String CAPACITY, String CITY, String ADDRESS, String PITCH_LENGTH, String PITCH_WIDTH, String YEAR_OF_BUILT) {
        this.NAME = NAME;
        this.CAPACITY = CAPACITY;
        this.CITY = CITY;
        this.ADDRESS = ADDRESS;
        this.PITCH_LENGTH = PITCH_LENGTH;
        this.PITCH_WIDTH = PITCH_WIDTH;
        this.YEAR_OF_BUILT = YEAR_OF_BUILT;
    }

    public String getStadiumName() {
        return NAME;
    }

    public String getCAPACITY() {
        return CAPACITY;
    }

    public String getCITY() {
        return CITY;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public String getPITCH_LENGTH() {
        return PITCH_LENGTH;
    }

    public String getPITCH_WIDTH() {
        return PITCH_WIDTH;
    }

    public String getYEAR_OF_BUILT() {
        return YEAR_OF_BUILT;
    }
}
