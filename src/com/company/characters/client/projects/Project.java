package com.company.characters.client.projects;

import com.company.Abilities;
import com.company.characters.client.Client;
import java.util.*;

public class Project implements Calculate {
    ProjectNamesPool projectName;
    ProjectType projectType;
    Integer [] workDaysAtTechnology;
 public  Abilities [] abilities;
    Double clientPayment;
    Calendar calendarDeadline;
    Double forfeitForCrossingDeadline;
    Integer workersAmount;
    Client client;
    public Boolean isDone = false;


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
    @Override
    public void calculatePayment(){
        double d =0;
        if(projectType.equals(ProjectType.BEGINNER))
            d= new Random().nextDouble(5.0,20.0);
        else if (projectType.equals(ProjectType.INTERMEDIATE))
            d = new Random().nextDouble(20.0,40.0);
        else if (projectType.equals(ProjectType.ELABORATE))
            d = new Random().nextDouble(50.0,100.0);

        d=Math.round(d*100.0)/100.0;
       this.clientPayment = d;
    }
    public void calculateWorkerAmount(){
        Integer i = 0;

        if(projectType.equals(ProjectType.BEGINNER))
            i= 1;
        else if (projectType.equals(ProjectType.INTERMEDIATE))
            i = new Random().nextInt(1,3);
        else if (projectType.equals(ProjectType.ELABORATE))
            i = new Random().nextInt(2,5);

       this.workersAmount = i;
    }
    public void calculateForfeitForCrossingDeadline(){
        double d =0;
        if(projectType.equals(ProjectType.BEGINNER))
            d= new Random().nextDouble(2.0,5.0);
        else if (projectType.equals(ProjectType.INTERMEDIATE))
            d = new Random().nextDouble(10.0,20.0);
        else if (projectType.equals(ProjectType.ELABORATE))
            d = new Random().nextDouble(30.0,50.0);

        d=Math.round(d*100.0)/100.0;
       this.forfeitForCrossingDeadline =d;
    }



    public void addRandomProjectNameFromEnum(){
        ProjectNamesPool b;
        b =  ProjectNamesPool.values()[new Random().nextInt(ProjectNamesPool.values().length)];
        this.projectName =b;
    }

    public void projectType() {
        ProjectType p;
        p = ProjectType.values()[new Random().nextInt(ProjectType.values().length)];
        this.projectType = p;

    }

    public void setDeadline() {

        Calendar calendar = Calendar.getInstance();

        Random r = new Random();
        int d;

        calendar.set(2020,Calendar.JANUARY,0);

        if(projectType.equals(ProjectType.ELABORATE)){

            d = r.nextInt(2,4);
            calendar.add(Calendar.DATE,d);
        }else if(projectType.equals(ProjectType.INTERMEDIATE)){
            d = r.nextInt(2,4);
            calendar.add(Calendar.DATE,d);
        }else if (projectType.equals(ProjectType.BEGINNER)){
            d = r.nextInt(2,4);
            calendar.add(Calendar.DATE,d);
        }

        this.calendarDeadline = calendar;
    }
    public void daysToDeadline(Calendar live,Project project){

        int a = live.get(Calendar.DATE);
        int b = project.getCalendarDeadline().get(Calendar.DATE);
        int value = b-a;
        System.out.println("Days left: " + value);

    }

    //default setters and getters



    public Double getClientPayment() {
        return clientPayment;
    }

    public Calendar getCalendarDeadline() {
        return calendarDeadline;
    }

    public Abilities[] getAbilities() {
        return abilities;
    }
    public ProjectType getProjectType() {
        return projectType;
    }

    public void setClient(Client client){
        this.client = client;
    }
    public Client getClient(){
        return client;
    }

    public void setForfeitForCrossingDeadline(Double forfeit){
        this.forfeitForCrossingDeadline = forfeit;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public String toString(){
        return "Project Name: "+projectName + " Project Type: " + projectType + " Client payment: " + clientPayment + " Value of forfeit for crossing Deadline:  " +
                forfeitForCrossingDeadline + " Deadline:  " + calendarDeadline.getTime()+ " Amount of waiting days for payment: " + workersAmount ;
    }



}




