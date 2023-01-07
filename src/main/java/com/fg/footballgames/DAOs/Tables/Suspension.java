package com.fg.footballgames.DAOs.Tables;
public class Suspension {
    private String id_suspension;
    private String player_id;
    private String club_id;
    private String type;
    private String received_match;
    private String return_match;
    public Suspension() {
    }
    public Suspension(String id_suspension, String player_id, String club_id, String type, String received_match, String return_match) {
        this.id_suspension = id_suspension;
        this.player_id = player_id;
        this.club_id = club_id;
        this.type = type;
        this.received_match = received_match;
        this.return_match = return_match;
    }
    public String getId_suspension() {
        return id_suspension;
    }
    public void setId_suspension(String id_suspension) {
        this.id_suspension = id_suspension;
    }
    public String getPlayer_id() {
        return player_id;
    }
    public void setPlayer_id(String player_id) {
        this.player_id = player_id;
    }
    public String getClub_id() {
        return club_id;
    }
    public void setClub_id(String club_id) {
        this.club_id = club_id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getReceived_match() {
        return received_match;
    }
    public void setReceived_match(String received_match) {
        this.received_match = received_match;
    }
    public String getReturn_match() {
        return return_match;
    }
    public void setReturn_match(String return_match) {
        this.return_match = return_match;
    }
}
