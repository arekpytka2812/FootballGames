package com.fg.footballgames.User;

public class UserAccount {
    private String username;
    private String password;
    private String favClub;

    public UserAccount(String username, String password, String favClub){
        this.username = password;
        this.password = password;
        this.favClub = favClub;
    }

    void setUsername(String username){
        this.username = username;
    }

    String getUsername(){
        return this.username;
    }

    void setPassword(String password){
        this.password = password;
    }

    String getPassword(){
        return this.password;
    }

    void setfavClub(String favClub){
        this.favClub = favClub;
    }

    String getFavClub(){
        return this.favClub;
    }
}