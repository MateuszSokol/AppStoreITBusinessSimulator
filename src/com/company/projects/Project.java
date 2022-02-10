package com.company.projects;

import com.company.Abilities;
import com.company.characters.Client;

import java.util.*;

public abstract class Project {
    String projectName;
    ProjectType projectType;
    Integer workDaysAtTechnology;
   Abilities [] abilities;
    Client client;
    Double clientPayment;
    Date deadline;
    Double forfeitForCrossingDeadline;
    Integer amountOfDaysWaitingForPayment;
    Integer workersAmount;

    public Project(String projectName, ProjectType projectType, Integer workersAmount,Client client) {
        this.projectName = projectName;
        this.projectType = projectType;
        this.workersAmount = workersAmount;

    }

    public void setNeededAbilities(Project project){
        Random random = new Random();
        int a =0;
        EnumSet<Abilities> abilitiesEnumSet = EnumSet.noneOf(Abilities.class);

        if(project.projectType ==ProjectType.BEGINNER){
             a = random.nextInt(1,3);

            for (int i = 0; i <a ; i++) {

                abilitiesEnumSet.add(Abilities.values()[new Random().nextInt(Abilities.values().length)]);
            }

            project.abilities = new Abilities[abilitiesEnumSet.size()];
            abilitiesEnumSet.toArray(project.abilities);

            
        }else if(project.projectType ==ProjectType.INTERMEDIATE){
            a = random.nextInt(2,5);

            for (int i = 0; i <a ; i++) {

                abilitiesEnumSet.add(Abilities.values()[new Random().nextInt(Abilities.values().length)]);
            }

            project.abilities = new Abilities[abilitiesEnumSet.size()];
            abilitiesEnumSet.toArray(project.abilities);


        }else if(project.projectType == ProjectType.ELABORATE){
            a = random.nextInt(4,7);
            for (int i = 0; i <= a ; i++) {

                abilitiesEnumSet.add(Abilities.values()[new Random().nextInt(Abilities.values().length)]);
            }

            project.abilities = new Abilities[abilitiesEnumSet.size()];
            abilitiesEnumSet.toArray(project.abilities);
            for (Abilities ac:project.abilities)
             {
                System.out.println(ac);
            }

            }

        }

    public String getProjectName() {
        return projectName;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public Integer getWorkDaysAtTechnology() {
        return workDaysAtTechnology;
    }


    public Client getClient() {
        return client;
    }

    public Double getClientPayment() {
        return clientPayment;
    }

    public Date getDeadline() {
        return deadline;
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

}
