package com.fg.footballgames.DAOs.Tables;

public class Referee{

    private String id_referee;
    private String personal_data_id;
    private String permissions;

    public Referee(){

    }

    public Referee(String id_referee, String personal_data_id, String permissions) {
        this.id_referee = id_referee;
        this.personal_data_id = personal_data_id;
        this.permissions = permissions;
    }

    public String getId_referee() {
        return id_referee;
    }

    public void setId_referee(String id_referee) {
        this.id_referee = id_referee;
    }

    public String getPersonal_data_id() {
        return personal_data_id;
    }

    public void setPersonal_data_id(String personal_data_id) {
        this.personal_data_id = personal_data_id;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
}
