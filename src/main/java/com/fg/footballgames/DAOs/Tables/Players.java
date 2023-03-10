package com.fg.footballgames.DAOs.Tables;

import com.fg.footballgames.DAOs.IDaoTableModel;

public class Players implements IDaoTableModel {

    private String id_player;
    private String personal_data_id;
    private String club;
    private String position;

    @Override
    public String[] getAll(){
        return new String[]{id_player, personal_data_id, club, position};
    }

    @Override
    public String getID(){
        return id_player;
    }

    public Players(){

    }

    public Players(String id_player) {
        this.id_player = id_player;
    }

    public Players(String id_player, String personal_data_id, String club, String position) {
        this.id_player = id_player;
        this.personal_data_id = personal_data_id;
        this.club = club;
        this.position = position;
    }

    public String getId_player() {
        return id_player;
    }

    public void setId_player(String id_player) {
        this.id_player = id_player;
    }

    public String getPersonal_data_id() {
        return personal_data_id;
    }

    public void setPersonal_data_id(String personal_data_id) {
        this.personal_data_id = personal_data_id;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
