package com.company.projects;

import com.company.Abilities;
import com.company.characters.Client;

import java.util.Date;
import java.util.Random;

public class Project {
    String projectName;
    ProjectType projectType;
    Integer workDaysAtTechnology;
    Abilities [] neededAbilities;
    Client client;
    Double clientPayment;
    Date deadline;
    Double forfeitForCrossingDeadline;
    Integer amountOfDaysWaitingForPayment;
    Integer workersAmount;

    public Project(String projectName, ProjectType projectType, Integer workersAmount) {
        this.projectName = projectName;
        this.projectType = projectType;
        this.workersAmount = workersAmount;

    }

    public void setNeededAbilities(Project project){
        Random random = new Random();
        if(project.projectType ==ProjectType.BEGINNER){
            int a = random.nextInt(1,2);
            this.neededAbilities = new Abilities[a];
        }else if(project.projectType ==ProjectType.INTERMEDIATE){
            int b = random.nextInt(2,4);
            this.neededAbilities = new Abilities[b];
        }else if(project.projectType == ProjectType.ELABORATE){
            int c = random.nextInt(3,6);
            this.neededAbilities = new Abilities[c];
        }
    }


}
