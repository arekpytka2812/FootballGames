package com.fg.footballgames.DAOs;

public class Stadium {

    private String id_stadium;
    private String name;
    private String capacity;
    private String city;
    private String address;
    private String pitch_length;
    private String pitch_width;
    private String year_of_built;

    public Stadium(){

    }

    public String getId_stadium() {
        return id_stadium;
    }

    public String getName() {
        return name;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getPitch_length() {
        return pitch_length;
    }

    public String getPitch_width() {
        return pitch_width;
    }

    public String getYear_of_built() {
        return year_of_built;
    }
}
