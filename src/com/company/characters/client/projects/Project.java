package com.company.characters.client.projects;

import com.company.characters.Abilities;
import com.company.characters.client.ClientTypes;

import java.util.*;

public class Project implements Calculate {
    ProjectNamesPool projectName;
    ProjectType projectType;
public Integer workDaysAtProject;
 public  Abilities [] abilities;
    Double clientPayment;
    Calendar calendarDeadline;
    Double forfeitForCrossingDeadline;
    Integer workersAmount;
    ClientTypes client;
    public Boolean avoidCrossingDeadlinePunishment;
    Integer paymentDelay;


    public void setNeededAbilities(Project project) {
        Random random = new Random();
        int a;
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

    }

    public void addRandomDaysWorkAtTechnologies(){
       Random random = new Random();
        workDaysAtProject = random.nextInt(1,4);

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
        int i = 0;

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

//deadlin wiekszy niz ilosc dni potrzebnych na zrobineine projektu
            d = r.nextInt(3,5);

            calendar.add(Calendar.DATE,d);
        }else if(projectType.equals(ProjectType.INTERMEDIATE)){
            d = r.nextInt(4,6);

            calendar.add(Calendar.DATE,d);
        }else if (projectType.equals(ProjectType.BEGINNER)){
            d = r.nextInt(5,7);

            calendar.add(Calendar.DATE,d);
        }

        this.calendarDeadline = calendar;
    }
    public Integer daysToDeadline(Calendar live,Project project){

        int a = live.get(Calendar.DATE);
        int b = project.getCalendarDeadline().get(Calendar.DATE);

        return b-a;

    }
    public void setAvoidCrossingDeadlinePunishment(int deadlineDays) {
        Random r = new Random();
        int d = r.nextInt(1, 5);

        if(d==1 && deadlineDays > -7 && client.equals(ClientTypes.LAZY)){
            this.avoidCrossingDeadlinePunishment = true;
        }else if(deadlineDays>=0 && client.equals(ClientTypes.FCKRS) || client.equals(ClientTypes.DEMANDING)){
            this.avoidCrossingDeadlinePunishment = true;
        }
        else{
            this.avoidCrossingDeadlinePunishment = false;
        }
    }

    public void setBasicPaymentDelay(){
        Random r = new Random();
        int d = r.nextInt(1,3);
        if(client.equals(ClientTypes.LAZY)|| client.equals(ClientTypes.FCKRS) && d == 1 ){
            this.paymentDelay =7;
        }else{
            this.paymentDelay =0;
        }
    }

    //default setters and getters


    public Boolean getAvoidCrossingDeadlinePunishment() {
        return avoidCrossingDeadlinePunishment;
    }

    public Double getForfeitForCrossingDeadline() {
        return forfeitForCrossingDeadline;
    }

    public void setPaymentDelay(Integer paymentDelay) {
        this.paymentDelay = paymentDelay;
    }

    public Integer getPaymentDelay() {
        return paymentDelay;
    }

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

    public void setClient(ClientTypes client){
        this.client = client;
    }
    public ClientTypes getClient(){
        return client;
    }



    public String toString(){
        return "Project Name: "+projectName + " Project Type: " + projectType + " Client payment: " + clientPayment + " Value of forfeit for crossing Deadline: " +
                forfeitForCrossingDeadline + " Deadline:  " + calendarDeadline.getTime()+ " Amount of waiting days for payment: " + paymentDelay +" Days needed: " + workDaysAtProject ;
    }



}




