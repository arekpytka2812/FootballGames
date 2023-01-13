package com.fg.footballgames.DAOs.Tables;

public class Positions implements com.fg.footballgames.DAOs.IDaoTableModel {

    private String id_position;
    private String position;
    private String formation;

    @Override
    public String[] getAll(){
        return new String[]{id_position, position, formation};
    }

    @Override
    public String getID(){
        return  id_position;
    }

    public Positions() {
    }

    public Positions(String id_position) {
        this.id_position = id_position;
    }

    public Positions(String id_position, String position, String formation) {
        this.id_position = id_position;
        this.position = position;
        this.formation = formation;
    }

    public String getId_position() {
        return id_position;
    }

    public void setId_position(String id_position) {
        this.id_position = id_position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }
}
