package com.company.mateuszsCompany;

import com.company.Abilities;

import java.util.Random;

public class Boss {
    String bossName;
    String bossLastName;
    Double cash;
    public Abilities [] bossAbilities;


    public Boss(String bossName, String bossLastName) {
        this.bossName = bossName;
        this.bossLastName = bossLastName;
        this.bossAbilities = new Abilities[5];
    }

    public void insertAbilitiesToBoss(Boss boss){
        boss.bossAbilities[0] = Abilities.BACKEND;
        boss.bossAbilities[1] = Abilities.FRONT_END;
        boss.bossAbilities[2] = Abilities.WORDPRESS;
        boss.bossAbilities[3] = Abilities.PRESTASHOP;
        boss.bossAbilities[4] = Abilities.DATA_BASE;
    }


    public void generateRandomCashAmount(){
        System.out.println("Generating random cash amount");
        Random random = new Random();
        this.cash = (double) Math.round(random.nextDouble(10, 100));
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }
}
