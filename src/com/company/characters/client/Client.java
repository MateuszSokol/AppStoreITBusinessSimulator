package com.company.characters.client;

import com.company.characters.client.projects.Project;

import java.util.ArrayList;

public abstract class Client {
    String clientCompanyName;
    ClientTypes clientType;
    ArrayList<Project> clientProject;

    public Client(String clientCompanyName, ClientTypes clientType) {
        this.clientCompanyName = clientCompanyName;
        this.clientType = clientType;
    }

    public void addProjectToClient(Project project){
        clientProject.add(project);
    }

}
