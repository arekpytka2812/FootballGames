package com.fg.footballgames.DAOs.Views;

public class MatchView {
    private String HOST;
    private String GUEST;
    private String HOST_GOALS;
    private String GUEST_GOALS;
    private String STADIUM;
    private String DATE;
    private String REFEREE;

    public MatchView() {
    }

    public MatchView(String HOST, String GUEST, String HOST_GOALS, String GUEST_GOALS, String STADIUM, String DATE, String REFEREE) {
        this.HOST = HOST;
        this.GUEST = GUEST;
        this.HOST_GOALS = HOST_GOALS;
        this.GUEST_GOALS = GUEST_GOALS;
        this.STADIUM = STADIUM;
        this.DATE = DATE;
        this.REFEREE = REFEREE;
    }

    public String getHOST() {
        return HOST;
    }

    public void setHOST(String HOST) {
        this.HOST = HOST;
    }

    public String getGUEST() {
        return GUEST;
    }

    public void setGUEST(String GUEST) {
        this.GUEST = GUEST;
    }

    public String getHOST_GOALS() {
        return HOST_GOALS;
    }

    public void setHOST_GOALS(String HOST_GOALS) {
        this.HOST_GOALS = HOST_GOALS;
    }

    public String getGUEST_GOALS() {
        return GUEST_GOALS;
    }

    public void setGUEST_GOALS(String GUEST_GOALS) {
        this.GUEST_GOALS = GUEST_GOALS;
    }

    public String getSTADIUM() {
        return STADIUM;
    }

    public void setSTADIUM(String STADIUM) {
        this.STADIUM = STADIUM;
    }

    public String getDATE() {
        return DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    public String getREFEREE() {
        return REFEREE;
    }

    public void setREFEREE(String REFEREE) {
        this.REFEREE = REFEREE;
    }
}
