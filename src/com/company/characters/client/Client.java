package com.company.characters.client;

import com.company.characters.client.projects.Project;

import java.util.ArrayList;
import java.util.Random;

public class Client {
    ArrayList<Project> projectArrayList;
    String clientCompanyName;
    ClientTypes clientType;
    Boolean avoidCrossingDeadlinePunishment;


    public Client(ArrayList<Project> projectArrayList, String clientCompanyName, ClientTypes clientType) {
        this.projectArrayList = projectArrayList;
        this.clientCompanyName = clientCompanyName;
        this.clientType = clientType;
    }

    public ClientTypes getClientType() {
        return clientType;
    }





}
