package com.company.characters.client;

import com.company.characters.client.projects.Project;

import java.util.ArrayList;

public class Client {
    Project project;
    String clientCompanyName;
    ClientTypes clientType;
    Double ability;

    public Client(String clientCompanyName, ClientTypes clientType) {
        this.clientCompanyName = clientCompanyName;
        this.clientType = clientType;
    }

    public void setAbility(){

    }
}
