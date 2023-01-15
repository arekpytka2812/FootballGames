package com.fg.footballgames.DAOs;

import com.fg.footballgames.DAOs.Views.*;

public enum DaoViewEnum {

    Clubs_view(Clubs_view.class),
    Coaches_view(Coaches_view.class),
    Fixtures_view(Fixtures_view.class),
    Goals_difference(Goals_difference.class),
    Main_standings(Main_standings.class),
    Players_view(Players_view.class),
    Referees_view(Referees_view.class),
    Stadiums_view(Stadiums_view.class),
    Stats_view(Stats_view.class),
    Suspensions_view(Suspensions_view.class);


    private Class<IDaoViewModel> clazz;

    <T extends IDaoViewModel> DaoViewEnum(Class<T> clazz){
        this.clazz = (Class<IDaoViewModel>) clazz;
    }

    public Class<IDaoViewModel> getClassName(){
        return clazz;
    }

}
