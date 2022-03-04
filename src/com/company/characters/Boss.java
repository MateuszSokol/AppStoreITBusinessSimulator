package com.company.characters;
import com.company.Abilities;
import com.company.Company;
import com.company.characters.client.projects.Project;
import com.company.projectMaking;

import java.util.ArrayList;
import java.util.Random;

public class Boss implements projectMaking{
    String bossName;
    String bossLastName;
    Company company;
    TypesOfEmployee employeeType;
    Double cash;
    Integer numberOfEmployee;
    public ArrayList<Project> projectList;
    public Abilities[] abilities;


    public Boss(String bossName, String bossLastName, TypesOfEmployee typesOfEmployee) {

        this.bossName = bossLastName;
        this.bossLastName = bossLastName;
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
    public void makeWork(ArrayList<Project> projectList,boolean canDoIt,int command) throws InterruptedException {


            if(canDoIt){
                System.out.println("Project in progress");
                Thread.sleep(2000);
                System.out.println("You have earned: "+ projectList.get(command-1).getClientPayment());
                double var = projectList.get(command-1).getClientPayment();
                setCash(getCash()+var);
                System.out.println("Your Cash: " + getCash());
                projectList.remove(command-1);
            }


    }
    public void abilityGenerator() {
        abilities[0] = Abilities.BACKEND;
       abilities[1] = Abilities.FRONT_END;
       abilities[2] = Abilities.WORDPRESS;
       abilities[3] = Abilities.PRESTASHOP;
     abilities[4] = Abilities.DATA_BASE;
    }
    public Double generateRandomCashAmount(){
        System.out.println("Generating random cash amount");
        Random random = new Random();
        return (double) Math.round(random.nextDouble(10, 100));
    }


    public void showAbilities(){
    for (Abilities a:abilities
         ) {
        System.out.println(a);
    }
}

}
