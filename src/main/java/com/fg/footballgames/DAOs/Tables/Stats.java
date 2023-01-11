package com.fg.footballgames.DAOs.Tables;

import com.fg.footballgames.DAOs.IDaoTableModel;

public class Stats  implements IDaoTableModel {

    private String id_player;
    private String goals;
    private String assists;
    private String yellow_cards;
    private String red_cards;

    @Override
    public String[] getAll(){
        return new String[]{id_player, goals, assists, yellow_cards, red_cards};
    }

    @Override
    public String getID(){
        return  id_player;
    }

    public Stats() {
    }

    public Stats(String id_player, String goals, String assists, String yellow_cards, String red_cards) {
        this.id_player = id_player;
        this.goals = goals;
        this.assists = assists;
        this.yellow_cards = yellow_cards;
        this.red_cards = red_cards;
    }

    public String getId_player() {
        return id_player;
    }

    public void setId_player(String id_player) {
        this.id_player = id_player;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getAssists() {
        return assists;
    }

    public void setAssists(String assists) {
        this.assists = assists;
    }

    public String getYellow_cards() {
        return yellow_cards;
    }

    public void setYellow_cards(String yellow_cards) {
        this.yellow_cards = yellow_cards;
    }

    public String getRed_cards() {
        return red_cards;
    }

    public void setRed_cards(String red_cards) {
        this.red_cards = red_cards;
    }
}
