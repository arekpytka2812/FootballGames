package com.fg.footballgames.AppComponents.AuthAccounts;

public class LoggedUser extends LoggedPerson {

    private final String username;
    private String favClub;

    private LoggedUser(String username){

        super("user", "");

        this.username = username;
    }

    public static LoggedUser getInstance(String username){
        if(loggedPerson == null)
            loggedPerson = new LoggedUser(username);

        return (LoggedUser) loggedPerson;
    }
    public String getFavClub(){
        return favClub;
    }

    public void setFavClub(String fav){
        this.favClub = fav;
    }

    public static void removeInstance(){
        if(loggedPerson != null)
            loggedPerson = null;
    }

    public static boolean isLoggedIn(){
        return loggedPerson != null;
    }

    public String getUsername(){
        return username;
    }

}
