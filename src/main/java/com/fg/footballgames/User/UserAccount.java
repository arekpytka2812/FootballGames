package com.fg.footballgames.User;

public class UserAccount {
    private String login;
    private String password;
    private String fav_club;

    public UserAccount(){

    }

    public UserAccount(String login, String password, String fav_club){
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