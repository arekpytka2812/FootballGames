package com.fg.footballgames.User.Controllers;

public enum UserPageEnum {

    // TODO create these pages

    ClubsPage("UserClubsCenter.fxml"),
    CoachesPage("UserCoachesCenter.fxml"),
    FixturesPage("UserFixturesCenter.fxml"),
    GoalDiffPage("UserGoalDiffCenter.fxml"),
    StandingsPage("UserStandingsCenter.fxml"),
    PlayersPage("UserPlayersCenter.fxml"),
    RefereesPage("UserRefereesCenter.fxml"),
    StadiumsPage("UserStadiumsCenter.fxml"),
    StatsPage("UserStatsCenter.fxml"),
    SuspensionsPage("UserSuspensionsCenter.fxml");

    private final String path;

    UserPageEnum(String path){
        this.path = path;
    }

    public String getPath(){
        return path;
    }
}
