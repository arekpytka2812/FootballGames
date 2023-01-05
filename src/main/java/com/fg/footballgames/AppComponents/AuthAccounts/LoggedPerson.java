package com.fg.footballgames.AppComponents.AuthAccounts;

class LoggedPerson {

    protected String conLogin;
    protected String conPass;

    protected static LoggedPerson loggedPerson = null;

    protected LoggedPerson(String conLogin, String conPass){
        this.conLogin = conLogin;
        this.conPass = conPass;
    }

    protected String getConLogin(){
        return conLogin;
    }

    protected String getConPass(){
        return conPass;
    }
}
