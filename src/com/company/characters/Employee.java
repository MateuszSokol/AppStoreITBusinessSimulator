package com.company.characters;

import com.company.Abilities;
import com.company.characters.client.projects.Project;

import java.util.ArrayList;
import java.util.Random;

public abstract class Employee {
    String name;
    String lastName;
    ArrayList<Project>projectList;
    Double cash;



    public Employee(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;

    }



}
