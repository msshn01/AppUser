package com.example.appuser.model;

public class Worker{
    String name;
    String surname;
    String email;
    String password;
    String number;
    String id;
    String field;
    String job;

    public Worker(String name, String field, String job, String number, String password, String surname, String email) {
        this.name = name;
        this.field = field;
        this.job = job;
        this.number = number;
        this.password = password;
        this.surname = surname;
        this.email = email;
    }
}
