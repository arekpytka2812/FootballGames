package com.fg.footballgames.DAOs.Tables;

public class Nationality implements com.fg.footballgames.DAOs.IDaoTableModel {

        private String id_country;
        private String country;
        private String federation;



    @Override
    public String[] getAll(){
        return new String[]{id_country, country, federation};
    }

    @Override
    public String getID(){
        return  id_country;
    }

    public Nationality() {
    }

    public Nationality(String id_country) {
        this.id_country = id_country;
    }

    public Nationality(String id_country, String country, String federation) {
        this.id_country = id_country;
        this.country = country;
        this.federation = federation;
    }

    public String getId_country() {
        return id_country;
    }

    public void setId_country(String id_country) {
        this.id_country = id_country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFederation() {
        return federation;
    }

    public void setFederation(String federation) {
        this.federation = federation;
    }
}
