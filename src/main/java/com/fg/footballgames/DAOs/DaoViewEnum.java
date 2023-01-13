package com.fg.footballgames.DAOs;

import com.fg.footballgames.DAOs.Views.*;

public enum DaoViewEnum {

    Clubs_view(Clubs_view.class),
    Coaches_view(Coaches_view.class),
    Fixtures_View(Fixtures_view.class),
    Goals_Difference(Goals_difference.class),
    Main_Standings(Main_standings.class),
    Players_View(Players_view.class),
    Referees_View(Referees_view.class),
    Stadiums_View(Stadiums_view.class),
    Stats_View(Stats_view.class),
    Suspensions_View(Suspensions_view.class);


    private Class<IDaoViewModel> clazz;

    <T extends IDaoViewModel> DaoViewEnum(Class<T> clazz){
        this.clazz = (Class<IDaoViewModel>) clazz;
    }

    public Class<IDaoViewModel> getClassName(){
        return clazz;
    }

}
