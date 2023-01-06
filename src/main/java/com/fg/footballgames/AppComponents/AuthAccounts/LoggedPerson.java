package com.fg.footballgames.AppComponents.AuthAccounts;

class LoggedPerson {

    protected String conLogin;
    protected String conPass;

    protected static LoggedPerson loggedPerson = null;

    protected LoggedPerson(String conLogin, String conPass){
        this.conLogin = conLogin;
        this.conPass = conPass;
    }

    public String getConLogin(){
        return conLogin;
    }

    public String getConPass(){
        return conPass;
    }
}
