package com.example.appuser.model;

public class Employer extends Users {


    public Employer(String email, String passwoard,String phoneNumber) {
        super(email, passwoard);
        this.phoneNumber = phoneNumber;
    }
}
