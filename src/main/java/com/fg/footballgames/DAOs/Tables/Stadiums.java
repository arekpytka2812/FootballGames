package com.fg.footballgames.DAOs.Tables;

import com.fg.footballgames.DAOs.IDaoModel;

public class Stadiums implements IDaoModel {

    private String id_stadium;
    private String name;
    private String capacity;
    private String city;
    private String address;
    private String pitch_length;
    private String pitch_width;
    private String year_of_built;

    @Override
    public String[] getAll(){
        return new String[]{id_stadium, name, capacity, city, address, pitch_length, pitch_width, year_of_built};
    }

    public Stadiums(){

    }

    public Stadiums(String id_stadium, String name, String capacity, String city, String address, String pitch_length, String pitch_width, String year_of_built) {
        this.id_stadium = id_stadium;
        this.name = name;
        this.capacity = capacity;
        this.city = city;
        this.address = address;
        this.pitch_length = pitch_length;
        this.pitch_width = pitch_width;
        this.year_of_built = year_of_built;
    }

    public String getId_stadium() {
        return id_stadium;
    }

    public void setId_stadium(String id_stadium) {
        this.id_stadium = id_stadium;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPitch_length() {
        return pitch_length;
    }

    public void setPitch_length(String pitch_length) {
        this.pitch_length = pitch_length;
    }

    public String getPitch_width() {
        return pitch_width;
    }

    public void setPitch_width(String pitch_width) {
        this.pitch_width = pitch_width;
    }

    public String getYear_of_built() {
        return year_of_built;
    }

    public void setYear_of_built(String year_of_built) {
        this.year_of_built = year_of_built;
    }
}
