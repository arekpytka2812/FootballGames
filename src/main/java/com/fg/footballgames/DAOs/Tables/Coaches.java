package com.fg.footballgames.DAOs.Tables;

import com.fg.footballgames.DAOs.IDaoTableModel;

public class Coaches implements IDaoTableModel {

    private String id_coach;
    private String personal_data_id;
    private String club_id;
    private String permissions;
    private String role;

    @Override
    public String[] getAll(){
        return new String[]{id_coach, personal_data_id, club_id, permissions,role};
    }

    @Override
    public String getID(){
        return id_coach;
    }

    public Coaches(){

    }

    public Coaches(String id_coach){
        this.id_coach = id_coach;
    }

    public Coaches(String id_coach, String personal_data_id, String club_id, String permissions, String role) {
        this.id_coach = id_coach;
        this.personal_data_id = personal_data_id;
        this.club_id = club_id;
        this.permissions = permissions;
        this.role = role;
    }

    public String getId_coach() {
        return id_coach;
    }
    public void setId_coach(String id_coach) {
        this.id_coach = id_coach;
    }

    public String getPersonal_data_id() {
        return personal_data_id;
    }
    public void setPersonal_data_id(String personal_data_id) {
        this.personal_data_id = personal_data_id;
    }

    public String getClub_id() {
        return club_id;
    }
    public void setClub_id(String club_id) {
        this.club_id = club_id;
    }

    public String getPermissions() {
        return permissions;
    }
    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
