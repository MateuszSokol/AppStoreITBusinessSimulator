package com.company.characters;

import com.company.Company;
import com.company.characters.client.projects.Project;
import com.company.characters.employee.TypesOfEmployee;
import com.company.projectMaking;

import java.util.ArrayList;
import java.util.Random;

public class Boss extends Person implements projectMaking {
    Company company;
    TypesOfEmployee employeeType;
    Double cash;
    Integer numberOfEmployee;
    public ArrayList<Project> projectList;
    public Abilities[] abilities;

    public Boss(String firstName, String lastName, String nationality, String gender, int age, TypesOfEmployee typesOfEmployee) {
        super(firstName, lastName, nationality, gender, age);
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
        main_loop:
        for (int i = 0; i < project.abilities.length; i++) {
            for (int j = 0; j < abilities.length; j++) {
                if (project.abilities[i].equals(abilities[j]) && abilities[j] != null) {
                    isEqual = true;
                    break;
                } else {
                    isEqual = false;

                }
                if (j == abilities.length - 1 && !isEqual) {

                    break main_loop;
                }
            }
        }
        return isEqual;
    }

    @Override
    public void makeAProject(ArrayList<Project> projectList, ArrayList<Project> madeProjectList, boolean canDoIt, int command) throws InterruptedException {
        if (canDoIt) {
            System.out.println("Project in progress");
            Thread.sleep(2000);


            if(projectList.get(command-1).workDaysAtProject == 1){
                projectList.get(command-1).workDaysAtProject -=1;
                madeProjectList.add(projectList.get(command-1));
                projectList.remove(command - 1);
            }else{
                projectList.get(command-1).workDaysAtProject -=1;
            }
        }
    }

    public void abilityGenerator() {
        abilities[0] = Abilities.BACKEND;
        abilities[1] = Abilities.FRONT_END;
        abilities[2] = Abilities.WORDPRESS;
        abilities[3] = Abilities.PRESTASHOP;
        abilities[4] = Abilities.DATA_BASE;
    }

    public Double generateRandomCashAmount() {
        System.out.println("Generating random cash amount");
        Random random = new Random();
        return (double) Math.round(random.nextDouble(30, 100));
    }


    public void showAbilities() {
        for (Abilities a : abilities
        ) {
            System.out.println(a);
        }
    }

    public void addPaymentToBossIfProjectIsReady(ArrayList<Project> madedProjectList,int command) {
        System.out.println("You have earned: " +madedProjectList.get(command - 1).getClientPayment());
        double var = madedProjectList.get(command - 1).getClientPayment();
        setCash(getCash() + var);
        System.out.println("Your Cash: " + getCash());
        madedProjectList.remove(madedProjectList.get(command-1));
    }


}
