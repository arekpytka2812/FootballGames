package com.fg.footballgames.DAOs;

import com.fg.footballgames.DAOs.Tables.*;

public enum DaoTableEnum {

    Accounts(Accounts.class),
    Clubs(Clubs.class),
    Coaches(Coaches.class),
    Fixtures(Fixtures.class),
    Nationality(Nationality.class),
    Personal_data(Personal_data.class),
    Players(Players.class),
    Positions(Positions.class),
    Referees(Referees.class),
    Stadiums(Stadiums.class),
    Standings(Standings.class),
    Stats(Stats.class),
    Suspensions(Suspensions.class);

    private Class<IDaoTableModel> clazz;

    <T extends IDaoTableModel> DaoTableEnum(Class<T> clazz){
        this.clazz = (Class<IDaoTableModel>) clazz;
    }

    public Class<IDaoTableModel> getClassName(){
        return clazz;
    }


}
