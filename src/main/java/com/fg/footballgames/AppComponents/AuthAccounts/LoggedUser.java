package com.fg.footballgames.AppComponents.AuthAccounts;

public class LoggedUser extends LoggedPerson {

    private String username;
    private String password;

    private LoggedUser(String username, String password){

        super("logged_user", "");

        this.username = username;
        this.password = password;
    }

    public static LoggedUser getInstance(String username, String password){
        if(loggedPerson == null)
            loggedPerson = new LoggedUser(username, password);

        return (LoggedUser) loggedPerson;
    }
}
