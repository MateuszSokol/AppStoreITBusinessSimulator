package com.company.characters.employee;

import com.company.characters.Person;
import com.company.characters.client.projects.ProjectNamesPool;

import java.util.Random;

public class Employee extends Person {
    EmployeeNames name;
    EmployeeLastNames lastName;
    Double bid;
    TypesOfEmployee typesOfEmployee;


    public Employee(String firstName,String lastName, String nationality, String gender, int age,Double bid,TypesOfEmployee typesOfEmployee){

        super(firstName,lastName,nationality,gender,age);
        this.bid = bid;
        this.typesOfEmployee = typesOfEmployee;
        addRandomEmployeeNameFromEnum();
        addRandomEmployeeLastNameFromEnum();
        addRandomTypesOfEmployeeFromEnum();

    }

    public void addRandomEmployeeNameFromEnum(){
        EmployeeNames b;
        b =  EmployeeNames.values()[new Random().nextInt(EmployeeNames.values().length)];
        this.name =b;
    }
    public void addRandomEmployeeLastNameFromEnum(){
        EmployeeLastNames b;
        b =  EmployeeLastNames.values()[new Random().nextInt(EmployeeLastNames.values().length)];
        this.lastName =b;
    }

    public void addRandomTypesOfEmployeeFromEnum(){
        TypesOfEmployee t;
        t = TypesOfEmployee.values()[new Random().nextInt(TypesOfEmployee.values().length)];

        while(true){
            if(!t.equals(TypesOfEmployee.BOSS)){
                this.typesOfEmployee = t;
                break;
            }else{
                t = TypesOfEmployee.values()[new Random().nextInt(TypesOfEmployee.values().length)];
            }
        }
    }


}
