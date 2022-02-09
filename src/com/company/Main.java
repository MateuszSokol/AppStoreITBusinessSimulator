package com.company;

import com.company.characters.Boss;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello, welcome to ITSimulator"+'\n'+"The aim of the game is to make 3 elaborateProjects " +
                "without using boss. At least 1 projects must be earned by hire seller and u must have more cash than in the start");
        Scanner scanner = new Scanner(System.in);
        Calendar live = Calendar.getInstance();
        int turnCounter =0 ;


        live.set(2020, Calendar.JANUARY, 1);
        Boss me = new Boss("Matt","Sprout",0);


        //generate starting resources
        me.generateRandomCashAmount();
        me.insertAbilitiesToBoss(me);
        System.out.println(live.getTime());


        System.out.println(me.getCash());
    }
}
