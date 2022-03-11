package com.company;

import com.company.characters.Boss;
import com.company.characters.employee.TypesOfEmployee;
import com.company.characters.client.Client;
import com.company.characters.client.ClientTypes;
import com.company.characters.client.projects.*;

import java.util.*;


public class Main {

    public static void main(String[] args) {

        System.out.println("Hello, welcome to ITSimulator" + '\n' + "The aim of the game is to make 3 elaborateProjects " +
                "without using boss. At least 1 projects must be earned by hire seller and u must have more cash than in the start");

        //generate starting resources

        Scanner scanner = new Scanner(System.in);
        Calendar live = Calendar.getInstance();

        int turnCounter = 1;


        ArrayList<Project> bossProjectList = new ArrayList<>();
        ArrayList<Project> madedProjectsList = new ArrayList<>();
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


        //info about character
        System.out.println("Your type: " + me.getEmployeeType());
        me.showAbilities();
        System.out.println("Cash: " + me.getCash());
        live.set(2020, Calendar.JANUARY, 1);

        ArrayList<Project> relaxedClientProjectList = new ArrayList<>();
        ArrayList<Project> demandingClientProjectList = new ArrayList<>();
        ArrayList<Project> fckrClientProjectList = new ArrayList<>();


        addProjectToClient(projectArrayList,relaxedClientProjectList,demandingClientProjectList,fckrClientProjectList);



        Client relaxedClient = new Client(relaxedClientProjectList,"relaxed Company", ClientTypes.LAZY);
        Client demandingClient = new Client(demandingClientProjectList,"demanding Company",ClientTypes.DEMANDING);
        Client fckrClient = new Client(fckrClientProjectList,"Fcker Company",ClientTypes.FCKRS);

        System.out.println("You are on your own now lets get some money and hire some employee, or maybe open a company? ");



        System.out.println("Each action take one turn");

        while (true) {
           /* for (Project p : relaxedClient.getProjectArrayList()
            ) {
                relaxedClient.setAvoidCrossingDeadlinePunishment(p.daysToDeadline(live, p));
            }
            System.out.println(projectArrayList.get(0).daysToDeadline(live, relaxedClient.getProjectArrayList().get(0)));
            System.out.println(relaxedClient.getAvoidCrossingDeadlinePunishment());*/
            if (checkIfIsItWeekend(live.get(Calendar.DATE))) {
                System.out.println("Its weekend your employees don't work" + "\n" + "You can make project on your own");
            } else {
                System.out.println("Its workday your employees work" + "\n" + "You can make project on your own");
            }
            boolean checkProject;
            try {
                System.out.println("""
                        0: Exit
                        1: Pick project
                        2: Choose an employee
                        3: Make project on your own
                        4: Fire an employee
                        5: submit project""");

                System.out.println("Turn: " + turnCounter);
                System.out.println(live.getTime());
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
                        projectArrayList.get(i).getCalendarDeadline().add(Calendar.DATE, 1);
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
                                updateDate(live, 1);
                            }
                        } else {
                            me.getProjectList().add(projectArrayList.get(command - 1));
                            projectArrayList.remove(command - 1);
                            turnCounter++;
                            updateDate(live, 1);
                        }
                    } else {
                        System.out.println("bad input");
                    }
                } else if (command == 2) {


                } else if (command == 3) {
                    System.out.println("Your project list: ");
                    for (Project p : me.getProjectList()
                    ) {
                        System.out.println(p.toString());
                        System.out.println("Days left: " +  p.daysToDeadline(live, p));
                        relaxedClient.setAvoidCrossingDeadlinePunishment(p.daysToDeadline(live,p));
                    }
                    System.out.println("If you don't have any projects type: 99"+" Otherwise type: 1");
                    command = scanner.nextInt();
                    if(command==99){
                        System.out.println("Back to start menu...");
                        Thread.sleep(2000);
                    }else{
                        System.out.println("Pick project: " +"\n"+"if you don't have ability you can't make it and your day is waste");
                        for (int i = 0; i < bossProjectList.size(); i++) {
                            System.out.println(i + 1 + ": " + bossProjectList.get(i));
                        }
                        command = scanner.nextInt();
                        checkProject = me.check(bossProjectList.get(command - 1));
                        int c = bossProjectList.indexOf(bossProjectList.get(command - 1));

                        if (command == c + 1) {
                            me.makeWork(bossProjectList, madedProjectsList,checkProject, command);
                        }
                        turnCounter++;
                        updateDate(live, 1);
                    }

                }else if(command ==5){
                    System.out.println("Type project index to submit project");

                    for (int i = 0; i <madedProjectsList.size(); i++) {
                        System.out.println(i+1+":"+madedProjectsList.get(i));
                    }
                    System.out.println("If it is empty type: 99");

                    command = scanner.nextInt();
                    if(command==99){
                        System.out.println("Back to start menu...");

                    }else{

                        me.addPaymentToBossIfProjectIsReady(madedProjectsList,command);
                    }

                }

            } catch (Exception e) {
                scanner.next();
            }

        }
    }

    public static void updateDate(Calendar calendar, int counter) {

        calendar.add(Calendar.DATE, counter);
    }

    private static void returnProjectList(ArrayList<Project> arrayList) {
        for (int i = 0; i < 15; i++) {
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

    private static boolean checkIfIsItWeekend(Integer dayCounter) {
        return dayCounter == 1 || dayCounter == 7;
    }
    public static void addProjectToClient(ArrayList<Project> projectArrayList,ArrayList<Project> relaxedClientProjectList,
                                          ArrayList<Project> demandingClientProjectList,ArrayList<Project> fckrsClientProjectList){

        for (int i = 0; i <projectArrayList.size()/3; i++) {
            relaxedClientProjectList.add(projectArrayList.get(i));
        }
        for (int i = projectArrayList.size()/3; i <projectArrayList.size() -projectArrayList.size()/3 ; i++) {
            demandingClientProjectList.add(projectArrayList.get(i));
        }
        for (int i = projectArrayList.size() - projectArrayList.size()/3; i <projectArrayList.size() ; i++) {
            fckrsClientProjectList.add(projectArrayList.get(i));
        }
    }

}

