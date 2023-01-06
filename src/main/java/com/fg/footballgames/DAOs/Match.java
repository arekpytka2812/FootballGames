package com.fg.footballgames.DAOs;

public class Match {

    private String id_match;
    private String host;
    private String guest;
    private String host_goals;
    private String guest_goals;
    private String stadium;
    private String referee;
    private String date;

    public Match(){

    }
    public Match(String id_match, String host, String guest, String host_goals, String guest_goals, String stadium, String referee, String date){
        this.id_match = id_match;
        this.host = host;
        this.guest = guest;
        this.host_goals = host_goals;
        this.guest_goals = guest_goals;
        this.stadium = stadium;
        this.referee  =referee;
        this.date = date;
    }
    public void setId_match(String id_match){
        this.id_match = id_match;
    }
    public String getId_match(){
        return id_match;
    }
    public void setHost(String host){
        this.host = host;
    }
    public String getHost(){
        return host;
    }
    public void setGuest(String guest){
        this.guest = guest;
    }
    public String getGuest(){
        return guest;
    }
    public void setHost_goals(String host_goals){
        this.host_goals = host_goals;
    }
    public String getHost_goals(){
        return host_goals;
    }
    public void setGuest_goals(String guest_goals){
        this.guest_goals = guest_goals;
    }
    public String getGuest_goals(){
        return guest_goals;
    }
    public void setStadium(String stadium){
        this.stadium = stadium;
    }
    public String getStadium(){
        return stadium;
    }
    public void setReferee(String referee){
        this.referee = referee;
    }
    public String getReferee(){
        return referee;
    }
    public void setDate(String date){
        this.date = date;
    }
    public String getDate(){
        return date;
    }

}
