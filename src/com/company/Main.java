package com.company;

import com.company.characters.Boss;
import com.company.characters.client.Client;
import com.company.characters.client.LazyClient;
import com.company.characters.client.projects.BeginnerProject;
import com.company.characters.client.projects.ElaborateProject;
import com.company.characters.client.projects.IntermidateProject;
import com.company.characters.client.projects.ProjectType;

import java.util.Calendar;
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

        LazyClient lazyClient = new LazyClient();
        /*Client client = new Client();*/

//zapelnic tablice liczbami od 1-6

        
        //generate starting resources
        me.generateRandomCashAmount();
        me.insertAbilitiesToBoss(me);
        System.out.println(live.getTime());

        BeginnerProject project = new BeginnerProject("FirstProject", ProjectType.BEGINNER,0,lazyClient);
        ElaborateProject elaborateProject = new ElaborateProject("Elaborate",ProjectType.ELABORATE,0,lazyClient);
        //creating Intermediate project
        IntermidateProject intermidateProject = new IntermidateProject("Intermediate",ProjectType.INTERMEDIATE,0,lazyClient);
        intermidateProject.setNeededAbilities(intermidateProject);




        intermidateProject.showTechnologiesAndWorkDaysTime(intermidateProject);





       // System.out.println(me.getCash());
    }
}
