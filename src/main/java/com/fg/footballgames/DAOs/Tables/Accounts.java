package com.fg.footballgames.DAOs.Tables;

import com.fg.footballgames.DAOs.IDaoTableModel;

import java.util.List;

public class Accounts implements IDaoTableModel {

    private String login;
    private String password;
    private String fav_club;

    @Override
    public String[] getAll(){
        return new String[]{login, password, fav_club};
    }

    @Override
    public String getID(){
        return login;
    }

    public Accounts(){

    }

    public Accounts(List<String> values){
        this.login = values.get(0);
        this.password = values.get(1);
        this.fav_club = values.get(2);
    }

    public Accounts(String login){
        this.login = login;
    }

    public Accounts(String login, String password, String fav_club){
        this.login = login;
        this.password = password;
        this.fav_club = fav_club;
    }

    void setLogin(String login){
        this.login = login;
    }

    public String getLogin(){
        return this.login;
    }

    void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    void setfavClub(String favClub){
        this.fav_club = favClub;
    }

    public String getFav_club(){
        return this.fav_club;
    }
}