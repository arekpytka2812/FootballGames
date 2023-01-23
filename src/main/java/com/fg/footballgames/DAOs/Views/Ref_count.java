package com.fg.footballgames.DAOs.Views;

import com.fg.footballgames.DAOs.IDaoViewModel;

public class Ref_count implements IDaoViewModel {

    private String REFEREE;
    private String MATCHES_REFEREED;


    @Override
    public String[] getAll(){
        return new String[]{REFEREE, MATCHES_REFEREED};
    }

    public Ref_count() {
    }

    public Ref_count(String REFEREE, String MATCHES_REFEREED) {
        this.REFEREE = REFEREE;
        this.MATCHES_REFEREED = MATCHES_REFEREED;
    }

    public String getREFEREE() {
        return REFEREE;
    }

    public String getMATCHES_REFEREED() {
        return MATCHES_REFEREED;
    }
}
