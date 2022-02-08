package com.company;

import com.company.mateuszsCompany.Boss;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello, welcome to ITSimulator"+'\n'+"The aim of the game is to make 3 elaborateProjects " +
                "without using boss. At least 1 projects must be earned by hire seller and u must have more cash than in the start");
        Scanner scanner = new Scanner(System.in);
        Boss me = new Boss("Matt","Sprout");
        //generate starting resources
        me.generateRandomCashAmount();
        me.insertAbilitiesToBoss(me);

        
        System.out.println(me.getCash());
    }
}
