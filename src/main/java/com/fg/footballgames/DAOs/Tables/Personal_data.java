package com.fg.footballgames.DAOs.Tables;

import com.fg.footballgames.DAOs.IDaoTableModel;

import java.util.List;

public class Personal_data implements IDaoTableModel {

    private String id_person;
    private String name;
    private String surname;
    private String year_of_birth;
    private String nationality;

    @Override
    public String[] getAll(){
        return new String[]{id_person, name, surname, year_of_birth, nationality};
    }

    @Override
    public String getID(){
        return id_person;
    }

    public Personal_data(){

    }

    public Personal_data(List<String> values){
        this.id_person = values.get(0);
        this.name = values.get(1);
        this.surname = values.get(2);
        this.year_of_birth = values.get(3);
        this.nationality = values.get(4);
    }

    public Personal_data(String id_person) {
        this.id_person = id_person;
    }

    public Personal_data(String id_person, String name, String surname, String year_of_birth, String nationality) {
        this.id_person = id_person;
        this.name = name;
        this.surname = surname;
        this.year_of_birth = year_of_birth;
        this.nationality = nationality;
    }

    public String getId_person() {
        return id_person;
    }

    public void setId_person(String id_person) {
        this.id_person = id_person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getYear_of_birth() {
        return year_of_birth;
    }

    public void setYear_of_birth(String year_of_birth) {
        this.year_of_birth = year_of_birth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
