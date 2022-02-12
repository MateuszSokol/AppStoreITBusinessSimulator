package com.company;

import com.company.characters.Boss;
import com.company.characters.TypesOfEmployee;
import com.company.characters.client.ClientTypes;
import com.company.characters.client.LazyClient;
import com.company.characters.client.projects.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello, welcome to ITSimulator" + '\n' + "The aim of the game is to make 3 elaborateProjects " +
                "without using boss. At least 1 projects must be earned by hire seller and u must have more cash than in the start");
        Scanner scanner = new Scanner(System.in);

        Calendar live = Calendar.getInstance();

        live.set(2020, Calendar.JANUARY, 1);
        int turnCounter = 0;
        boolean isGameRunning = true;

        Boss me = new Boss("Matt", "Sprout", TypesOfEmployee.BOSS);
        me.setNumberOfEmployee(0);

        //generate starting resources
        me.generateRandomCashAmount();
        me.insertAbilitiesToBoss();

        System.out.println(live.getTime());

        //creating client
        LazyClient lazyClient = new LazyClient("company", ClientTypes.LAZY);

        //creating projects
        // creating beginner project
        BeginnerProject project = new BeginnerProject("FirstProject", ProjectType.BEGINNER, 0, 3, 10.0);
        //creating Intermediate project
        Intermediate intermediateProject = new Intermediate("Intermediate", ProjectType.INTERMEDIATE, 0, 9, 1000.0);
        intermediateProject.setNeededAbilities(intermediateProject);
        ElaborateProject elaborateProject = new ElaborateProject("Elaborate", ProjectType.ELABORATE, 0, 6, 100.0);

        ArrayList<Project> projectArrayList = new ArrayList<>();
        projectArrayList.add(project);
        projectArrayList.add(intermediateProject);
        projectArrayList.add(elaborateProject);


        intermediateProject.showTechnologiesAndWorkDaysTime();

        System.out.println("Your type: " + me.getEmployeeType());
        for (Abilities a : me.bossAbilities)
            System.out.println("Abilities: " + a);
        System.out.println("Cash: " + me.getCash());



        System.out.println("You are on your own now lets get some money and hire some employee, or maybe open a company? ");

        while (isGameRunning) {


            System.out.println("Projects available: ");

            for (int i = 0; i <projectArrayList.size(); i++) {

                if(me.getNumberOfEmployee()>0) {
                    System.out.println((i+1)+": "+projectArrayList.get(i).getProjectType());
                }else if(!projectArrayList.get(i).getProjectType().equals(ProjectType.ELABORATE)){
                    System.out.println((i+1)+": "+projectArrayList.get(i).getProjectType());

                }
            }



                System.out.println("As Boss you can only do beginner and intermediate projects");
                System.out.println("Pick one of them");




                isGameRunning = false;


        }


    }
}

