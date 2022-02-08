package com.company.projects;

import com.company.Abilities;

public class Project {
    String projectName;
    ProjectTypes [] projectTypes;
    Integer workDaysAmount;
    Abilities [] needfulAbilities;

    public Project(String projectName, ProjectTypes[] projectTypes, Integer workDaysAmount, Integer needfulAbilitiesAmount) {
        this.projectName = projectName;
        this.projectTypes = projectTypes;
        this.workDaysAmount = workDaysAmount;
        this.needfulAbilities = new Abilities[needfulAbilitiesAmount];
    }
}
