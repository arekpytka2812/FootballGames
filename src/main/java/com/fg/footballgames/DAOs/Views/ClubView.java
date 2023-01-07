package com.fg.footballgames.DAOs.Views;

public class ClubView {
    private String NAME;
    private String CITY;
    private String STADIUM;
    private String YEAR_FOUNDED;
    public ClubView(){

    }
    public ClubView(String name, String city, String stadium, String year_founded) {
        this.NAME = name;
        this.CITY = city;
        this.STADIUM = stadium;
        this.YEAR_FOUNDED = year_founded;
    }


    public String getName() {
        return NAME;
    }

    public String getCity() {
        return CITY;
    }

    public String getStadium() {
        return STADIUM;
    }

    public String getYear_founded() {
        return YEAR_FOUNDED;
    }
}
