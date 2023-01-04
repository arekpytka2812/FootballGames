package com.fg.footballgames.User.Controllers;

public enum UserPageEnum {

    MainPage("UserMainCenter.fxml"),
    StandingsPage("UserStandingsCenter.fxml");

    private final String path;

    UserPageEnum(String path){
        this.path = path;
    }

    public String getPath(){
        return path;
    }
}
