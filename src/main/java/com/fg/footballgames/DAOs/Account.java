package com.fg.footballgames.DAOs;

public class Account {
    private String login;
    private String password;
    private String fav_club;

    public Account(){

    }

    public Account(String login, String password, String fav_club){
        this.login = password;
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

    String getPassword(){
        return this.password;
    }

    void setfavClub(String favClub){
        this.fav_club = favClub;
    }

    public String getFav_club(){
        return this.fav_club;
    }
}