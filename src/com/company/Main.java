package com.company;

import com.company.characters.Boss;
import com.company.characters.TypesOfEmployee;
import com.company.characters.client.ClientTypes;
import com.company.characters.client.LazyClient;
import com.company.characters.client.projects.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello, welcome to ITSimulator" + '\n' + "The aim of the game is to make 3 elaborateProjects " +
                "without using boss. At least 1 projects must be earned by hire seller and u must have more cash than in the start");
        Scanner scanner = new Scanner(System.in);

        Calendar live = Calendar.getInstance();
        Calendar deadlineCal  = Calendar.getInstance();
        deadlineCal = live;


        int turnCounter = 0;
        boolean isGameRunning = true;

        ArrayList<Project> bossProjectList = new ArrayList<>();
        Boss me = new Boss("Matt", "Sprout", TypesOfEmployee.BOSS);
        me.setNumberOfEmployee(0);
        me.setCompany(null);
        ArrayList<Project> projectArrayList = new ArrayList<>();
        me.abilityGenerator(me);


        //generate starting resources

        me.setCash(me.generateRandomCashAmount());
        me.setProjectList(bossProjectList);


        //creating client
        LazyClient lazyClient = new LazyClient("company", ClientTypes.LAZY);



        //generate random project and add to list

        returnProjectList(projectArrayList);




        for (Project p : projectArrayList
        ) {
            p.setDeadline();

        }
        live.set(2020, Calendar.JANUARY, 1);



        System.out.println("Your type: " + me.getEmployeeType());
        me.showAbilities();
        System.out.println("Cash: " + me.getCash());




        System.out.println("You are on your own now lets get some money and hire some employee, or maybe open a company? ");

   while (isGameRunning) {
            try {
                System.out.println("Turn: " + turnCounter);


                System.out.println("Projects available: ");

                for (int i = 0; i < projectArrayList.size(); i++) {

                    if (me.getNumberOfEmployee() > 0) {
                        System.out.println((i + 1) + ": " + projectArrayList.get(i).getProjectType() + " "+ Arrays.toString(projectArrayList.get(i).getAbilities()));


                    } else if (!projectArrayList.get(i).getProjectType().equals(ProjectType.ELABORATE)) {
                        System.out.println((i + 1) + ": " + projectArrayList.get(i).getProjectType() + " "+ Arrays.toString(projectArrayList.get(i).getAbilities()));


                    }
                }


                System.out.println("As Boss you can only do beginner and intermediate projects");
                System.out.println("Pick one of them typing index number");


                int command = scanner.nextInt();

                if(!me.check(projectArrayList.get(command-1))){
                    System.out.println("You don't have some abilities better check it out");
                    System.out.print(" "+ Arrays.toString(projectArrayList.get(command - 1).getAbilities()));
                    System.out.println("Type 'cancel' to abort action otherwise type anything");
                    String cancelAction = scanner.next();
                    if(cancelAction.equals("cancel")){
                        continue;
                    }else{
                        System.out.println("As u wish");
                    }
                }


                for (int i = 0; i < projectArrayList.size(); i++) {
                    if (command == i + 1 && projectArrayList.get(i) != null && !projectArrayList.get(i).getProjectType().equals(ProjectType.ELABORATE)) {
                        projectArrayList.get(i).showTechnologiesAndWorkDaysTime();
                        me.getProjectList().add(projectArrayList.get(i));

                    }
                }


                System.out.println("Your project list: ");
                for (Project p : me.getProjectList()
                ) {
                    System.out.println(p.toString());
                }


                turnCounter++;
                updateDate(live, turnCounter);

                System.out.println(live.getTime());


                System.out.println("If you want to exit type 0");


                command = scanner.nextInt();
                isGameRunning = exit(command);
            }catch (Exception e){
                scanner.next();
            }



        }
        }



    public static boolean exit(int a) {

        boolean abc = true;
        abc = (a == 0) ? false : true;

        return abc;
    }

    public static void updateDate(Calendar calendar, int counter) {

        calendar.add(Calendar.DATE, counter);
    }


    private static void returnProjectList(ArrayList<Project> arrayList) {
        for (int i = 0; i < 10; i++) {
            Project project = new Project();
            project.projectType();
            project.setNeededAbilities(project);
            project.addRandomProjectNameFromEnum();
            project.addRandomDaysWorkAtTechnologies(project);
            project.calculatePayment();
            project.calculateWorkerAmount();
            project.calculateForfeitForCrossingDeadline();

            arrayList.add(project);
        }
    }

}

