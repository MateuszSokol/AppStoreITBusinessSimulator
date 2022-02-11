package com.company;

import com.company.characters.Boss;
import com.company.characters.Client;
import com.company.projects.BeginnerProject;
import com.company.projects.ElaborateProject;
import com.company.projects.IntermidateProject;
import com.company.projects.ProjectType;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello, welcome to ITSimulator"+'\n'+"The aim of the game is to make 3 elaborateProjects " +
                "without using boss. At least 1 projects must be earned by hire seller and u must have more cash than in the start");
        Scanner scanner = new Scanner(System.in);
        Calendar live = Calendar.getInstance();
        live.set(2020, Calendar.JANUARY, 1);
        int turnCounter =0 ;

        Boss me = new Boss("Matt","Sprout",0);
        Client client = new Client();

//zapelnic tablice liczbami od 1-6

        
        //generate starting resources
        me.generateRandomCashAmount();
        me.insertAbilitiesToBoss(me);
        System.out.println(live.getTime());

        BeginnerProject project = new BeginnerProject("FirstProject", ProjectType.BEGINNER,0,client);
        ElaborateProject elaborateProject = new ElaborateProject("Elaborate",ProjectType.ELABORATE,0,client);
        IntermidateProject intermidateProject = new IntermidateProject("Intermediate",ProjectType.INTERMEDIATE,0,client);


        project.setNeededAbilities(project);
        project.setNeededAbilities(elaborateProject);
        project.setNeededAbilities(intermidateProject);

      for (Abilities a:intermidateProject.abilities
             ) {
            System.out.println(a);
        }
        System.out.println(project.abilities.length);
       // System.out.println(me.getCash());
    }
}
