package com.company;

import com.company.characters.Boss;
import com.company.characters.employee.TypesOfEmployee;
import com.company.characters.client.ClientTypes;
import com.company.characters.client.projects.*;
import java.util.*;


public class Main {

    public static void main(String[] args) {

        System.out.println("Hello, welcome to ITSimulator" + '\n' + "The aim of the game is to make 3 elaborateProjects " +
                "without using boss. At least 1 projects must be earned by hire seller and u must have more cash than in the start");

        //generate starting resources


        Calendar live = Calendar.getInstance();

        int turnCounter = 1;



        ArrayList<Project> bossProjectList = new ArrayList<>();
        ArrayList<Project> madeProjectList = new ArrayList<>();
        Boss me = new Boss("Mathew","Broccoli", "Sweden","male",25,TypesOfEmployee.BOSS);
        me.setNumberOfEmployee(0);
        me.setCompany(null);

        ArrayList<Project> waitingPaymentProjects = new ArrayList<>();


        ArrayList<Project> projectArrayList = new ArrayList<>();
        me.abilityGenerator();
        me.setCash(me.generateRandomCashAmount());
        me.setProjectList(bossProjectList);
        live.set(2020, Calendar.JANUARY, 1);

        //generate random project and add to list
        returnProjectList(projectArrayList);
        setDeadlineForProject(projectArrayList);


        //info about character
        System.out.println("Your type: " + me.getEmployeeType());
        me.showAbilities();



        addClientToProject(projectArrayList);



        System.out.println("You are on your own now lets get some money and hire some employee, or maybe open a company? ");


        System.out.println("Each action take one turn");




        while (true) {
            System.out.println("Turn: " + turnCounter);
            System.out.println(live.getTime());
            double cashBeforeTaxes = me.getCash();
            me.setCash(me.getCash()-5);
            System.out.println("Expenses take u 5$, your balance was:  " + cashBeforeTaxes + " after is : " + me.getCash());

            turnCounter++;
            for (Project p : projectArrayList
            ) {
                p.setBasicDeadline();
            }

            if (checkIfIsItWeekend(live.get(Calendar.DAY_OF_WEEK))) {
                System.out.println("Its weekend your employees don't work" + "\n" + "You can make project on your own");
            } else {
                System.out.println("Its workday your employees work" + "\n" + "You can make project on your own");
            }

            boolean checkProject;
            if(me.getCash()<=0){
                System.out.println("You lost, try again");
                break;
            }
            try {
                Scanner scanner = new Scanner(System.in);

                System.out.println("""
                        0: Exit
                        1: Pick project
                        2: Choose an employee
                        3: Make project on your own
                        4: Fire an employee
                        5: submit project
                        6: Hire an employee""");





                int command = scanner.nextInt();


                if (command == 0) {
                    break;
                } else if (command == 1) {
                    System.out.println("Projects available: ");
                    for (int i = 0; i < projectArrayList.size(); i++) {
                        if (me.getNumberOfEmployee() > 0) {
                            System.out.println((i + 1) + ": " + projectArrayList.get(i).getProjectType() + " " + Arrays.toString(projectArrayList.get(i).getAbilities()));
                        } else if (!projectArrayList.get(i).getProjectType().equals(ProjectType.ELABORATE)) {
                            System.out.println((i + 1) + ": " + projectArrayList.get(i).getProjectType() + " " + Arrays.toString(projectArrayList.get(i).getAbilities()));
                        }

                    }

                    System.out.println("As Boss you can only do beginner and intermediate projects");
                    System.out.println("Pick one of them typing index number");
                    command = scanner.nextInt();

                    if (!projectArrayList.get(command - 1).getProjectType().equals(ProjectType.ELABORATE)) {
                        if (!me.check(projectArrayList.get(command - 1))) {
                            System.out.println("You don't have some abilities better check it out");
                            System.out.print(" " + Arrays.toString(projectArrayList.get(command - 1).getAbilities()));
                            System.out.println("Type 'cancel' to abort action otherwise type anything");
                            String cancelAction = scanner.next();
                            if (!cancelAction.equals("cancel")) {
                                System.out.println("As u wish");
                                me.getProjectList().add(projectArrayList.get(command - 1));
                                projectArrayList.remove(command - 1);
                                turnCounter++;
                                updateDate(live);
                                checkPaymentDelay(waitingPaymentProjects, me);
                            }
                        } else {
                            me.getProjectList().add(projectArrayList.get(command - 1));
                            projectArrayList.remove(command - 1);

                            checkPaymentDelay(waitingPaymentProjects, me);
                        }
                    } else {
                        turnCounter--;
                        System.out.println("bad input");
                    }
                } else if (command == 2) {

                    checkPaymentDelay(waitingPaymentProjects, me);

                    updateDate(live);

                } else if (command == 3) {
                    System.out.println("Your project list: ");
                    for (Project p : me.getProjectList()
                    ) {
                        System.out.println(p.toString());
                        System.out.println("Days left: " + p.daysToDeadline(live, p));


                    }
                    System.out.println("If you don't have any projects type: 99" + " Otherwise type: 1");
                    command = scanner.nextInt();
                    if (command == 99) {
                        System.out.println("Back to start menu...");
                        turnCounter--;
                        Thread.sleep(2000);
                    } else {
                        System.out.println("Pick project: " + "\n" + "if you don't have ability you can't make it and your day is waste");
                        for (int i = 0; i < bossProjectList.size(); i++) {
                            System.out.println(i + 1 + ": " + bossProjectList.get(i));
                        }
                        command = scanner.nextInt();
                        checkProject = me.check(bossProjectList.get(command - 1));
                        int c = bossProjectList.indexOf(bossProjectList.get(command - 1));

                        if (command == c + 1) {
                            me.makeAProject(bossProjectList, madeProjectList, checkProject, command);
                        }
                        turnCounter++;
                        updateDate(live);
                        checkPaymentDelay(waitingPaymentProjects, me);
                    }

                } else if (command == 5) {
                    System.out.println("Type project index to submit project");
                    System.out.println("If it is empty type: 99");

                    for (int i = 0; i < madeProjectList.size(); i++) {
                        System.out.println(i + 1 + ":" + madeProjectList.get(i));

                    }

                    command = scanner.nextInt();
                    int c = madeProjectList.indexOf(madeProjectList.get(command - 1));

                    if (command == 99) {
                        System.out.println("Back to start menu...");

                        turnCounter--;

                    } else if (command == c + 1) {
                        /*waitingPaymentProjects.add(madeProjectList.get(c));*/
                        madeProjectList.get(command - 1).
                                setAvoidCrossingDeadlinePunishment(madeProjectList.get(command - 1).
                                        daysToDeadline(live, madeProjectList.get(command - 1)));
                        checkPaymentStatus(madeProjectList, waitingPaymentProjects, command, me, live);
                        updateDate(live);


                    }


                }else if(command == 6){
                    System.out.println("Choose employee to hire: ");
                   // ------------------- add code here
                }


            } catch (Exception e) {
                System.out.println("Heading back to start");
                me.setCash(me.getCash()+5);
                turnCounter--;

            }


        }
    }

    private static void updateDate(Calendar calendar) {

        calendar.add(Calendar.DAY_OF_WEEK, 1);
    }

    private static void returnProjectList(ArrayList<Project> arrayList) {
        for (int i = 0; i < 15; i++) {
            Project project = new Project();
            project.projectType();
            project.setNeededAbilities(project);
            project.addRandomProjectNameFromEnum();
            project.addRandomDaysWorkAtTechnologies();
            project.calculatePayment();
            project.calculateWorkerAmount();
            project.calculateForfeitForCrossingDeadline();
            arrayList.add(project);
        }
    }

    private static void setDeadlineForProject(ArrayList<Project> projectArrayList) {
        for (Project p : projectArrayList
        ) {
            p.setBasicDeadline();
        }
    }

    private static boolean checkIfIsItWeekend(Integer dayCounter) {

        return dayCounter == 1 || dayCounter == 7;
    }

    private static void addClientToProject(ArrayList<Project> projectArrayList) {

        for (int i = 0; i < projectArrayList.size() / 3; i++) {
            projectArrayList.get(i).setClient(ClientTypes.LAZY);
            projectArrayList.get(i).setBasicPaymentDelay();
        }
        for (int i = projectArrayList.size() / 3; i < projectArrayList.size() - projectArrayList.size() / 3; i++) {
            projectArrayList.get(i).setClient(ClientTypes.DEMANDING);
            projectArrayList.get(i).setBasicPaymentDelay();
        }
        for (int i = projectArrayList.size() - projectArrayList.size() / 3; i < projectArrayList.size(); i++) {
            projectArrayList.get(i).setClient(ClientTypes.FCKRS);
            projectArrayList.get(i).setBasicPaymentDelay();
        }

    }

    private static void checkPaymentStatus(ArrayList<Project> madeProjectList, ArrayList<Project> waitingPaymentProjects, Integer command, Boss me, Calendar live) {


            if (madeProjectList.get(command - 1).getPaymentDelay() > 0) {
                System.out.println("Days left to payment: " + madeProjectList.get(command - 1).getPaymentDelay());
                if (madeProjectList.get(command - 1).daysToDeadline(live, madeProjectList.get(command - 1)) < 0) {
                    System.out.println("You are late!!!!!");
                    me.setCash(madeProjectList.get(command - 1).getForfeitForCrossingDeadline());
                }else{
                    System.out.println("You are on time waiting for payment");
                }

            } else {

                if (madeProjectList.get(command - 1).getAvoidCrossingDeadlinePunishment()) {
                    System.out.println("You submitted your project on time :) ");
                    me.addPaymentToBossIfProjectIsReady(madeProjectList, command);

                } else {
                    System.out.println("You are late :/" + " You must pay forfeit: " +
                            madeProjectList.get(command - 1).getForfeitForCrossingDeadline());
                    me.setCash(madeProjectList.get(command - 1).getForfeitForCrossingDeadline());
                    me.addPaymentToBossIfProjectIsReady(madeProjectList, command);

                }

            }

        waitingPaymentProjects.add(madeProjectList.get(command - 1));
        madeProjectList.remove(madeProjectList.get(command - 1));
    }

    public static void checkPaymentDelay(ArrayList<Project> waitingPaymentProjects, Boss me) {
        for (int i = 0; i < waitingPaymentProjects.size(); i++) {
            if (waitingPaymentProjects.get(i) != null && waitingPaymentProjects.get(i).getPaymentDelay() > 0) {
                waitingPaymentProjects.get(i).setPaymentDelay(waitingPaymentProjects.get(i).getPaymentDelay() - 1);
                System.out.println("Days to payment: " + waitingPaymentProjects.get(i).getPaymentDelay());
                if (waitingPaymentProjects.get(i).getPaymentDelay() <= 0) {
                    System.out.println("Your payment added successfully" + " cash Before: " + me.getCash());
                    me.setCash(waitingPaymentProjects.get(i).getClientPayment());
                    System.out.println("Cash after: " + me.getCash());

                }
                break;
            }
        }
    }
}

