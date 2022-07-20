package com.company;

import com.company.characters.client.projects.Project;

import java.util.ArrayList;

public interface projectMaking {
   void makeAProject(ArrayList<Project> projectList , ArrayList<Project> madeProjectList, boolean canDoIt, int command) throws InterruptedException;
}
