package com.company.characters.employee;

import com.company.characters.client.projects.ProjectNamesPool;

import java.util.Random;

public abstract class Employee {
    EmployeeNames name;
    EmployeeLastNames lastName;
    Double bid;
    TypesOfEmployee typesOfEmployee;



    public Employee(Double bid,TypesOfEmployee typesOfEmployee) {
        addRandomEmployeeNameFromEnum();
        addRandomEmployeeLastNameFromEnum();
        this.bid = bid;
        this.typesOfEmployee = typesOfEmployee;

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



}
