package com.fg.footballgames.DAOs.Views;

public class StadiumView {
    private String NAME;
    private String CAPACITY;
    private String CITY;
    private String ADDRESS;
    private String PITCH_LENGTH;
    private String PITCH_WIDTH;
    private String YEAR_OF_BUILT;

    public StadiumView() {
    }

    public StadiumView(String NAME, String CAPACITY, String CITY, String ADDRESS, String PITCH_LENGTH, String PITCH_WIDTH, String YEAR_OF_BUILT) {
        this.NAME = NAME;
        this.CAPACITY = CAPACITY;
        this.CITY = CITY;
        this.ADDRESS = ADDRESS;
        this.PITCH_LENGTH = PITCH_LENGTH;
        this.PITCH_WIDTH = PITCH_WIDTH;
        this.YEAR_OF_BUILT = YEAR_OF_BUILT;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getCAPACITY() {
        return CAPACITY;
    }

    public void setCAPACITY(String CAPACITY) {
        this.CAPACITY = CAPACITY;
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getPITCH_LENGTH() {
        return PITCH_LENGTH;
    }

    public void setPITCH_LENGTH(String PITCH_LENGTH) {
        this.PITCH_LENGTH = PITCH_LENGTH;
    }

    public String getPITCH_WIDTH() {
        return PITCH_WIDTH;
    }

    public void setPITCH_WIDTH(String PITCH_WIDTH) {
        this.PITCH_WIDTH = PITCH_WIDTH;
    }

    public String getYEAR_OF_BUILT() {
        return YEAR_OF_BUILT;
    }

    public void setYEAR_OF_BUILT(String YEAR_OF_BUILT) {
        this.YEAR_OF_BUILT = YEAR_OF_BUILT;
    }
}
