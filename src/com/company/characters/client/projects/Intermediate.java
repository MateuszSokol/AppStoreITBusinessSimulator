package com.company.characters.client.projects;

import com.company.characters.client.Client;

import java.util.Calendar;
import java.util.Date;

public class Intermediate extends Project{


    public Intermediate(String projectName, ProjectType projectType, Integer workersAmount, Integer deadline, Double forfeitForCrossingDeadline) {
        super(projectName, projectType, workersAmount,deadline,forfeitForCrossingDeadline);
    }
}
