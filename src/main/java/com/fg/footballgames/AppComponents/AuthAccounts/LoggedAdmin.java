package com.fg.footballgames.AppComponents.AuthAccounts;

public class LoggedAdmin extends LoggedPerson {

    private LoggedAdmin(String login, String password){
        super(login, password);
    }

    public static LoggedAdmin getInstance(String login, String password){
        if(loggedPerson == null)
            loggedPerson = new LoggedAdmin(login, password);

        return (LoggedAdmin) loggedPerson;
    }

    public static boolean isLoggedIn(){
        return loggedPerson != null;
    }

    public static void removeInstance(){
        loggedPerson = null;
    }
}
