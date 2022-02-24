package com.company.characters;
import com.company.Abilities;
import com.company.Company;
import com.company.characters.client.projects.Project;
import com.company.projectMaking;

import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.EnumSet;
import java.util.Random;

public class Boss extends Employee implements projectMaking {
    Company company;
    TypesOfEmployee employeeType;
     Double cash;
    public Abilities [] bossAbilities;
    Integer numberOfEmployee;
 ArrayList<Project>projectList;




    public Boss(String bossName, String bossLastName,TypesOfEmployee typesOfEmployee) {

        super(bossName,bossLastName);
        this.employeeType = typesOfEmployee;
        this.bossAbilities = new Abilities[5];

    }

    public void insertAbilitiesToBoss(){
        bossAbilities[0] = Abilities.BACKEND;
        bossAbilities[1] = Abilities.FRONT_END;
       bossAbilities[2] = Abilities.WORDPRESS;
        bossAbilities[3] = Abilities.PRESTASHOP;
        bossAbilities[4] = Abilities.DATA_BASE;
    }


    public void generateRandomCashAmount(){
        System.out.println("Generating random cash amount");
        Random random = new Random();
        this.cash = (double) Math.round(random.nextDouble(10, 100));
    }
    public void updateDate(Calendar calendar){
        calendar.add(Calendar.DAY_OF_MONTH,1);

    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public void setNumberOfEmployee(Integer numberOfEmployee) {
        this.numberOfEmployee = numberOfEmployee;
    }

    public void setProjectList(ArrayList<Project> projectList) {
        this.projectList = projectList;
    }

    public Double getCash() {
        return cash;
    }

    public TypesOfEmployee getEmployeeType() {
        return employeeType;
    }

    public Abilities[] getBossAbilities() {
        return bossAbilities;
    }

    public Integer getNumberOfEmployee() {
        return numberOfEmployee;
    }

    public ArrayList<Project> getProjectList() {
        return projectList;
    }

    @Override
    public void makeWork(Project project) {

        for (int i = 0; i < project.abilities.length ; i++) {


        }
    }
}
