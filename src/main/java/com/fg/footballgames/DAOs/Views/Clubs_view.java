package com.fg.footballgames.DAOs.Views;

import com.fg.footballgames.DAOs.IDaoViewModel;

public class Clubs_view implements IDaoViewModel {

    private String id_club;
    private String CLUB_NAME;
    private String CITY;
    private String STADIUM;
    private String YEAR_FOUNDED;

    @Override
    public String[] getAll(){
        return new String[]{id_club, CLUB_NAME, CITY, STADIUM, YEAR_FOUNDED};
    }

    public Clubs_view(){

    }

    public Clubs_view(String id_club, String clubName, String city, String stadium, String year_founded) {
        this.id_club = id_club;
        this.CLUB_NAME = clubName;
        this.CITY = city;
        this.STADIUM = stadium;
        this.YEAR_FOUNDED = year_founded;
    }

    public String getId_club(){return id_club;}

    public String getClubName() {
        return CLUB_NAME;
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
