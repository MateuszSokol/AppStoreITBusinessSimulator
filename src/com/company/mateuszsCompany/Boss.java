package com.company.mateuszsCompany;

import com.company.Abilities;

public class Boss {
    String bossName;
    String bossLastName;
    Double cash;
    Abilities [] bossAbilities;


    public Boss(String bossName, String bossLastName, Double cash) {
        this.bossName = bossName;
        this.bossLastName = bossLastName;
        this.cash = cash;
        this.bossAbilities = new Abilities[5];
    }

    public void insertAbilitiesToBoss(Boss boss){
        boss.bossAbilities[0] = Abilities.BACKEND;
        boss.bossAbilities[1] = Abilities.FRONT_END;
        boss.bossAbilities[2] = Abilities.WORDPRESS;
        boss.bossAbilities[3] = Abilities.PRESTASHOP;
        boss.bossAbilities[4] = Abilities.DATA_BASE;
    }
}
