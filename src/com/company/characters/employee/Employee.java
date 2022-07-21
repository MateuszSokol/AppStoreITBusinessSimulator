package com.company.characters.employee;

import com.company.characters.Person;
import com.company.characters.client.projects.ProjectNamesPool;

import java.util.Random;

public class Employee extends Person {

    Double bid;
    TypesOfEmployee typesOfEmployee;


    public Employee(String firstName,String lastName, String nationality, int age,Double bid,TypesOfEmployee typesOfEmployee){

        super(firstName,lastName,nationality,age);
        this.bid = bid;
        this.typesOfEmployee = typesOfEmployee;

    }

    public static String addRandomEmployeeFirstName(){

        EmployeeNames h = EmployeeNames.values()[new Random().nextInt(EmployeeNames.values().length)];

        return h.toString();
    }


    public static String addRandomEmployeeLastNameFromEnum(){
        EmployeeLastNames b;
        b =  EmployeeLastNames.values()[new Random().nextInt(EmployeeLastNames.values().length)];
        return b.toString();
    }
    public static String addRandomEmployeeNationality(){

        EmployeeNationality b;
        b = EmployeeNationality.values()[new Random().nextInt(EmployeeNationality.values().length)];
        return b.toString();
    }
    public static int addRandomEmployeeAge(){
        return new Random().nextInt(20,50);
    }
    public static double addRandomEmployeeBid(){
        return new Random().nextDouble(30,60);
    }

    public static TypesOfEmployee addRandomTypesOfEmployeeFromEnum(){
        TypesOfEmployee t;
        t = TypesOfEmployee.values()[new Random().nextInt(TypesOfEmployee.values().length)];

        while(true){
            if(!t.equals(TypesOfEmployee.BOSS)){
                return t;
            }else{
                t = TypesOfEmployee.values()[new Random().nextInt(TypesOfEmployee.values().length)];
            }
        }
    }


}
