package com.company;

import com.company.characters.Boss;
import com.company.characters.TypesOfEmployee;
import com.company.characters.client.projects.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello, welcome to ITSimulator" + '\n' + "The aim of the game is to make 3 elaborateProjects " +
                "without using boss. At least 1 projects must be earned by hire seller and u must have more cash than in the start");

        //generate starting resources

        Scanner scanner = new Scanner(System.in);
        Calendar live = Calendar.getInstance();

        int turnCounter = 0;
        boolean isGameRunning = true;

        ArrayList<Project> bossProjectList = new ArrayList<>();
        Boss me = new Boss("Matt", "Sprout", TypesOfEmployee.BOSS);
        me.setNumberOfEmployee(0);
        me.setCompany(null);

        ArrayList<Project> projectArrayList = new ArrayList<>();
        me.abilityGenerator();
        me.setCash(me.generateRandomCashAmount());
        me.setProjectList(bossProjectList);
        live.set(2020, Calendar.JANUARY, 1);

        //generate random project and add to list
        returnProjectList(projectArrayList);
        setDeadlineForProject(projectArrayList);


        System.out.println("Your type: " + me.getEmployeeType());
        me.showAbilities();
        System.out.println("Cash: " + me.getCash());
        live.set(2020, Calendar.JANUARY, 1);


        System.out.println("You are on your own now lets get some money and hire some employee, or maybe open a company? ");

        System.out.println(checkIfIsItWorkday(live.DATE));


        while (isGameRunning) {

            boolean checkProject;
            try {
                System.out.println("Turn: " + turnCounter);
                System.out.println("Projects available: ");

                for (int i = 0; i < projectArrayList.size(); i++) {

                    if (me.getNumberOfEmployee() > 0) {
                        System.out.println((i + 1) + ": " + projectArrayList.get(i).getProjectType() + " " + Arrays.toString(projectArrayList.get(i).getAbilities()));


                    } else if (!projectArrayList.get(i).getProjectType().equals(ProjectType.ELABORATE)) {
                        System.out.println((i + 1) + ": " + projectArrayList.get(i).getProjectType() + " " + Arrays.toString(projectArrayList.get(i).getAbilities()));

                    }

                    projectArrayList.get(i).getCalendarDeadline().add(Calendar.DATE, 1);
                }

                System.out.println("As Boss you can only do beginner and intermediate projects");
                System.out.println("Pick one of them typing index number");

                int command = scanner.nextInt();

                if (!projectArrayList.get(command - 1).getProjectType().equals(ProjectType.ELABORATE)) {

                    if (!me.check(projectArrayList.get(command - 1))) {
                        System.out.println("You don't have some abilities better check it out");
                        System.out.print(" " + Arrays.toString(projectArrayList.get(command - 1).getAbilities()));
                        System.out.println("Type 'cancel' to abort action otherwise type anything");
                        String cancelAction = scanner.next();
                        if (cancelAction.equals("cancel")) {
                            continue;
                        } else {
                            System.out.println("As u wish");
                            me.getProjectList().add(projectArrayList.get(command - 1));
                            projectArrayList.remove(command - 1);
                        }
                    } else {
                        me.getProjectList().add(projectArrayList.get(command - 1));
                        projectArrayList.remove(command - 1);
                    }
                } else {
                    System.out.println("bad input");
                    continue;
                }

                System.out.println("Your project list: ");
                for (Project p : me.getProjectList()
                ) {
                    System.out.println(p.toString());
                    p.daysToDeadline(live,p);
                }

                turnCounter++;
                updateDate(live, 1);

                System.out.println(live.getTime());


                if(checkIfIsItWorkday(live.DATE)){
                    System.out.println("Its weekend your employees don't work"+"\n"+"You can make project on your own");
                }else{
                    System.out.println("Its workday your employees work"+"\n"+"You can make project on your own");
                }
                System.out.println("""
                        Type 1 to start project if you don't have ability you can't make it and your day is waste
                        Check the employee list type 2
                        If you want to exit type 0""");


                command = scanner.nextInt();




                isGameRunning = exit(command);

                if (command == 1) {
                    System.out.println("Pick project: ");
                    for (int i = 0; i < bossProjectList.size(); i++) {
                        System.out.println(i + 1 + ": " + bossProjectList.get(i));
                    }

                }else if(!isGameRunning){
                    break;
                }



                checkProject = me.check(bossProjectList.get(command-1));

                int c = bossProjectList.indexOf(bossProjectList.get(command - 1));

                if (command == c+1) {
                   me.makeWork(bossProjectList,checkProject,command);
                }




            } catch (Exception e) {
                scanner.next();
            }

        }
    }

    public static boolean exit(int a) {

        return (a == 0) ? false : true;
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

    private static void setDeadlineForProject(ArrayList<Project> projectArrayList) {
        for (Project p : projectArrayList
        ) {
            p.setDeadline();
        }
    }

    private static boolean checkIfIsItWorkday(Integer dayCounter) {

        if (dayCounter ==1 || dayCounter==7) {
            return true;
        } else {
            return false;
        }
    }

}

