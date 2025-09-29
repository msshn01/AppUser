package com.example.appuser.model;

public class Worker extends Users  {
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    String job;


    public Worker(String email, String passwoard,String job) {
        super(email, passwoard);
        this.job = job;

    }


}
