package com.fg.footballgames.DAOs;

// TODO change database wnums to code enums??
// don't know if it will work

public class Coach {

    private String id_coach;
    private String personal_data_id;
    private String club_id;
    private String permissions;
    private String role;

    public Coach(){

    }

    public String getId_coach() {
        return id_coach;
    }

    public String getPersonal_data_id() {
        return personal_data_id;
    }

    public String getClub_id() {
        return club_id;
    }

    public String getPermissions() {
        return permissions;
    }

    public String getRole() {
        return role;
    }
}
