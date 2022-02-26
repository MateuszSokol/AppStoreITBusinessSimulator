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
    Integer numberOfEmployee;
 public ArrayList<Project>projectList;




    public Boss(String bossName, String bossLastName,TypesOfEmployee typesOfEmployee) {

        super(bossName,bossLastName);
        this.employeeType = typesOfEmployee;
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
