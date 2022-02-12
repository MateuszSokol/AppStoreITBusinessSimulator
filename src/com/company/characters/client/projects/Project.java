package com.company.characters.client.projects;

import com.company.Abilities;
import com.company.characters.client.Client;

import java.util.*;

public abstract class Project {
    String projectName;
    ProjectType projectType;
    Integer [] workDaysAtTechnology;
 public  Abilities [] abilities;
    Client client;
    Double clientPayment;
    Integer deadline;
    Double forfeitForCrossingDeadline;
    Integer amountOfDaysWaitingForPayment;
    Integer workersAmount;



    public Project(String projectName, ProjectType projectType, Integer workersAmount,Integer deadlineDays,Double forfeitForCrossingDeadline) {
        this.projectName = projectName;
        this.projectType = projectType;
        this.workersAmount = workersAmount;
        this.deadline = deadlineDays;
        this.forfeitForCrossingDeadline = forfeitForCrossingDeadline;

    }
    public void setNeededAbilities(Project project) {
        Random random = new Random();
        int a = 0;
        EnumSet<Abilities> abilitiesEnumSet = EnumSet.noneOf(Abilities.class);

        if (project.projectType == ProjectType.BEGINNER) {
            a = random.nextInt(1, 3);

            for (int i = 0; i < a; i++) {

                abilitiesEnumSet.add(Abilities.values()[new Random().nextInt(Abilities.values().length)]);
            }
            project.abilities = new Abilities[abilitiesEnumSet.size()];
            abilitiesEnumSet.toArray(project.abilities);
        } else if (project.projectType == ProjectType.INTERMEDIATE) {
            a = random.nextInt(3, 5);

            for (int i = 0; i < a; i++) {

                abilitiesEnumSet.add(Abilities.values()[new Random().nextInt(Abilities.values().length)]);
            }
            project.abilities = new Abilities[abilitiesEnumSet.size()];
            abilitiesEnumSet.toArray(project.abilities);
        } else if (project.projectType == ProjectType.ELABORATE) {
            a = random.nextInt(4, 7);
            for (int i = 0; i <= a; i++) {

                abilitiesEnumSet.add(Abilities.values()[new Random().nextInt(Abilities.values().length)]);
            }
            project.abilities = new Abilities[abilitiesEnumSet.size()];
            abilitiesEnumSet.toArray(project.abilities);

        }

        workDaysAtTechnology = new Integer[project.abilities.length];

        addRandomDaysWorkAtTechnologies(project);



    }

    public void addRandomDaysWorkAtTechnologies(Project project){

       Random random = new Random();

        for (int i = 0; i < project.workDaysAtTechnology.length; i++) {

            int randomDaysAtTech = random.nextInt(1,4);
            workDaysAtTechnology[i] =randomDaysAtTech;
        }
    }

    public void showTechnologiesAndWorkDaysTime(){
        for (int i = 0; i <workDaysAtTechnology.length; i++) {
            if(abilities[i] != null){
                System.out.println(abilities[i] + " -- " + workDaysAtTechnology[i] +" days");
            }
        }
    }



    public String getProjectName() {
        return projectName;
    }

    public ProjectType getProjectType() {
        return projectType;
    }



    public Client getClient() {
        return client;
    }

    public Double getClientPayment() {
        return clientPayment;
    }



    public Double getForfeitForCrossingDeadline() {
        return forfeitForCrossingDeadline;
    }

    public Integer getAmountOfDaysWaitingForPayment() {
        return amountOfDaysWaitingForPayment;
    }

    public Integer getWorkersAmount() {
        return workersAmount;
    }

    public void setAbilities(Abilities[] abilities) {
        this.abilities = abilities;
    }

    public void setClientPayment(Double clientPayment) {
        this.clientPayment = clientPayment;
    }

    public void setAmountOfDaysWaitingForPayment(Integer amountOfDaysWaitingForPayment) {
        this.amountOfDaysWaitingForPayment = amountOfDaysWaitingForPayment;
    }


    /*String projectName;
    ProjectType projectType;
    Integer [] workDaysAtTechnology;
    public  Abilities [] abilities;
    Client client;
    Double clientPayment;
    Integer deadline;
    Double forfeitForCrossingDeadline;
    Integer amountOfDaysWaitingForPayment;
    Integer workersAmount;*/
    public String toString(){

        return projectName + " " + projectType;
    }



}
