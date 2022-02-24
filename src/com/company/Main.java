package com.company;

import com.company.characters.Boss;
import com.company.characters.TypesOfEmployee;
import com.company.characters.client.ClientTypes;
import com.company.characters.client.LazyClient;
import com.company.characters.client.projects.*;
import com.company.characters.client.projects.projectObjects.ProjectNamesPool;

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

        ArrayList<Project> bossProjectList = new ArrayList<>();
        Boss me = new Boss("Matt", "Sprout", TypesOfEmployee.BOSS);
        me.setNumberOfEmployee(0);
        me.setCompany(null);
        ArrayList<Project> projectArrayList = new ArrayList<>();


        //generate starting resources

        me.generateRandomCashAmount();
        me.insertAbilitiesToBoss();
        me.setProjectList(bossProjectList);

        System.out.println(live.getTime());

        //creating client
        LazyClient lazyClient = new LazyClient("company", ClientTypes.LAZY);

        //creating projects


        //generator


        for (int i = 0; i <10 ; i++) {
            Project project = new Project();
            project.projectType();
            System.out.println(project.getProjectType());
            project.setNeededAbilities(project);
            project.addRandomProjectNameFromEnum();
            project.addRandomDaysWorkAtTechnologies(project);
            project.calculatePayment();
            project.calculateWorkerAmount();
            project.calculateForfeitForCrossingDeadline();

            projectArrayList.add(project);
        }



        for (Project p:projectArrayList
             ) {
            p.setDeadline(live);
            System.out.println(p);
        }








        System.out.println("Your type: " + me.getEmployeeType());
        for (Abilities a : me.bossAbilities)
            System.out.println("Abilities: " + a);
        System.out.println("Cash: " + me.getCash());



        System.out.println("You are on your own now lets get some money and hire some employee, or maybe open a company? ");

        while (isGameRunning) {
            System.out.println("Turn: "+ turnCounter);

            System.out.println("Projects available: ");

            for (int i = 0; i <projectArrayList.size(); i++) {

                if(me.getNumberOfEmployee()>0) {
                    System.out.println((i+1)+": "+projectArrayList.get(i).getProjectType());
                }else if(!projectArrayList.get(i).getProjectType().equals(ProjectType.ELABORATE)){
                    System.out.println((i+1)+": "+projectArrayList.get(i).getProjectType());

                }
            }



                System.out.println("As Boss you can only do beginner and intermediate projects");
                System.out.println("Pick one of them typing index number");


               int command = scanner.nextInt();

            for (int i = 0; i < projectArrayList.size() ; i++) {
                if(command == i && projectArrayList.get(i)!=null){
                    System.out.println(projectArrayList.get(i).toString());
                    projectArrayList.get(i).showTechnologiesAndWorkDaysTime();
                    me.getProjectList().add(projectArrayList.get(i));

                }
            }

            System.out.println("Your project list: ");
            for (Project p:me.getProjectList()
                 ) {
                System.out.println(p.toString());
            }




            turnCounter++;
            live.add(Calendar.DATE,1);

            System.out.println(live.getTime());



            System.out.println("If you want to exit type 0");
            command = scanner.nextInt();
            if(command ==0){

                isGameRunning = false;
            }
        }


    }
}

