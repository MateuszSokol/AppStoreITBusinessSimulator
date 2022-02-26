package com.company.characters;

import com.company.Abilities;
import com.company.characters.client.projects.Project;

import java.util.ArrayList;
import java.util.Random;

public abstract class Employee {
    String name;
    String lastName;
    ArrayList<Project>projectList;
    Double cash;
    public Abilities [] abilities;



    public Employee(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.abilities = new Abilities[5];
    }

    public void insertAbilities(){
        abilities[0] = Abilities.BACKEND;
        abilities[1] = Abilities.FRONT_END;
        abilities[2] = Abilities.WORDPRESS;
        abilities[3] = Abilities.PRESTASHOP;
        abilities[4] = Abilities.DATA_BASE;
    }
    public void showAbilities(){
        for (Abilities a:abilities
             ) {
            System.out.println("Ability: "+a);
        }
    }


    public void generateRandomCashAmount(){
        System.out.println("Generating random cash amount");
        Random random = new Random();
        this.cash = (double) Math.round(random.nextDouble(10, 100));
    }
}
