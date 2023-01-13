package com.fg.footballgames.DAOs.Tables;

import com.fg.footballgames.DAOs.IDaoTableModel;

public class Standings  implements IDaoTableModel {

    private String club_id;
    private String points;
    private String goals_scored;
    private String goals_conceded;
    private String wins;
    private String draws;
    private String losses;

    @Override
    public String[] getAll(){
        return new String[]{club_id, points, goals_conceded, goals_conceded, wins, draws, losses};
    }

    @Override
    public String getID(){
        return  club_id;
    }

    public Standings() {
    }

    public Standings(String club_id) {
        this.club_id = club_id;
    }

    public Standings(String club_id, String points, String goals_scored, String goals_conceded, String wins, String draws, String losses) {
        this.club_id = club_id;
        this.points = points;
        this.goals_scored = goals_scored;
        this.goals_conceded = goals_conceded;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
    }

    public String getClub_id() {
        return club_id;
    }

    public void setClub_id(String club_id) {
        this.club_id = club_id;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getGoals_scored() {
        return goals_scored;
    }

    public void setGoals_scored(String goals_scored) {
        this.goals_scored = goals_scored;
    }

    public String getGoals_conceded() {
        return goals_conceded;
    }

    public void setGoals_conceded(String goals_conceded) {
        this.goals_conceded = goals_conceded;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public String getDraws() {
        return draws;
    }

    public void setDraws(String draws) {
        this.draws = draws;
    }

    public String getLosses() {
        return losses;
    }

    public void setLosses(String losses) {
        this.losses = losses;
    }
}
