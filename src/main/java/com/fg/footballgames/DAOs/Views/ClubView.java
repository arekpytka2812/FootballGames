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
    public void setName(String name) {
        this.NAME = name;
    }

    public String getCity() {
        return CITY;
    }
    public void setCity(String city) {
        this.CITY = city;
    }

    public String getStadium() {
        return STADIUM;
    }
    public void setStadium(String stadium) {
        this.STADIUM = stadium;
    }

    public String getYear_founded() {
        return YEAR_FOUNDED;
    }
    public void setYear_founded(String year_founded) {
        this.YEAR_FOUNDED = year_founded;
    }
}
