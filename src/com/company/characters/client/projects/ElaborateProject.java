package com.company.characters.client.projects;

import com.company.characters.client.Client;

import java.util.Calendar;

public class ElaborateProject extends Project{
    public ElaborateProject(String projectName, ProjectType projectType, Integer workersAmount, Integer deadlineDays,Double forfeitForCrossingDeadline) {
        super(projectName, projectType, workersAmount,deadlineDays,forfeitForCrossingDeadline);
    }
}
