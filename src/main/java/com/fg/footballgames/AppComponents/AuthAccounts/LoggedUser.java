package com.fg.footballgames.AppComponents.AuthAccounts;

public class LoggedUser extends LoggedPerson {

    private final String username;

    private LoggedUser(String username){

        super("logged_user", "");

        this.username = username;
    }

    public static LoggedUser getInstance(String username){
        if(loggedPerson == null)
            loggedPerson = new LoggedUser(username);

        return (LoggedUser) loggedPerson;
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
