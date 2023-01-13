package com.fg.footballgames.DAOs.Tables;

import com.fg.footballgames.DAOs.IDaoTableModel;

public class Clubs implements IDaoTableModel {

    private String id_club;
    private String name;
    private String city;
    private String stadium;
    private String year_founded;

    @Override
    public String[] getAll(){
        return new String[]{id_club, name, city, stadium, year_founded};
    }

    @Override
    public String getID(){
        return id_club;
    }

    public Clubs(){

    }

    public Clubs(String id_club){
        this.id_club = id_club;
    }

    public Clubs(String id_club, String name, String city, String stadium, String year_founded) {
        this.id_club = id_club;
        this.name = name;
        this.city = city;
        this.stadium = stadium;
        this.year_founded = year_founded;
    }

    public String getId_club() {
        return id_club;
    }
    public void setId_club(String id_club) {
        this.id_club = id_club;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getStadium() {
        return stadium;
    }
    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getYear_founded() {
        return year_founded;
    }
    public void setYear_founded(String year_founded) {
        this.year_founded = year_founded;
    }
}
