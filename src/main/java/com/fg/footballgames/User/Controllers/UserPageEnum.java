package com.fg.footballgames.User.Controllers;

public enum UserPageEnum {

    StandingsPage("UserStandingsCenter.fxml");

    private final String path;

    UserPageEnum(String path){
        this.path = path;
    }

    public String getPath(){
        return path;
    }
}
