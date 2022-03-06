package com.company.characters.client;

import com.company.characters.client.projects.Project;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class Client {
    ArrayList<Project> projectArrayList;
    String clientCompanyName;
    ClientTypes clientType;
    Boolean avoidCrossingDeadlinePunishment;
    Integer paymentDelay;

    public Client(ArrayList<Project> projectArrayList, String clientCompanyName, ClientTypes clientType) {
        this.projectArrayList = projectArrayList;
        this.clientCompanyName = clientCompanyName;
        this.clientType = clientType;
        setPaymentDelay();
        setAvoidCrossingDeadlinePunishment();
    }

    public ClientTypes getClientType() {
        return clientType;
    }

    public void setPaymentDelay(){
        Random r = new Random();
        int d = r.nextInt(1,3);
        if(clientType.equals(ClientTypes.LAZY)|| clientType.equals(ClientTypes.FCKRS) && d == 1 ){
            this.paymentDelay =7;
        }else{
            this.paymentDelay =0;
        }
    }

    public void setAvoidCrossingDeadlinePunishment() {
        Random r = new Random();
        int d = r.nextInt(1, 5);
        if(d ==1 ){
            this.avoidCrossingDeadlinePunishment = true;
        }else{
            this.avoidCrossingDeadlinePunishment = false;
        }
    }


}
