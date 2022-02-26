package com.company.characters;
import com.company.Abilities;
import com.company.Company;
import com.company.characters.client.projects.Project;
import com.company.projectMaking;

import java.util.ArrayList;

public class Boss extends Employee implements projectMaking, InsertAbilities {
    Company company;
    TypesOfEmployee employeeType;
    Double cash;
    Integer numberOfEmployee;
    public ArrayList<Project> projectList;
    public Abilities[] abilities;


    public Boss(String bossName, String bossLastName, TypesOfEmployee typesOfEmployee) {

        super(bossName, bossLastName);
        this.employeeType = typesOfEmployee;
        this.abilities = new Abilities[5];
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

    public boolean check(Project project) {
        boolean isEqual = true;
        main_loop: for (int i = 0; i <project.abilities.length; i++) {
            for (int j = 0; j <abilities.length ; j++) {
                if(project.abilities[i].equals(abilities[j])&& abilities[j]!=null){
                    isEqual = true;
                    break;
                }else {
                    isEqual = false;

                }
                if(j==abilities.length-1&& !isEqual){

                    break main_loop;
                }
            }
        }
        return isEqual;
    }

    @Override
    public void makeWork(Project project) {

        for (int i = 0; i < project.abilities.length; i++) {


        }
    }


    @Override
    public void abilityGenerator(Employee employee) {
        abilities[0] = Abilities.BACKEND;
       abilities[1] = Abilities.FRONT_END;
       abilities[2] = Abilities.WORDPRESS;
       abilities[3] = Abilities.PRESTASHOP;
     abilities[4] = Abilities.DATA_BASE;
    }



    public void showAbilities(){
    for (Abilities a:abilities
         ) {
        System.out.println(a);
    }
}

}
