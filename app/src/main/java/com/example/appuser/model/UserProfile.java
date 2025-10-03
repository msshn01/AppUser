package com.example.appuser.model;

import java.util.Random;

public class UserProfile {
    String name;
    String surname;
    String email;
    String password;
    String number;
    String id;
    String field;
    Random random = new Random();

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    String point ;
    public UserProfile(String name, String surname, String email, String password, String number, String field,String point) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.number = number;
        this.field = field;
        this.point = point;
        int say = 10000 + random.nextInt(90000);
        id = name + surname + String.valueOf(say);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getField() {
        if (field == null){
            return "Kullanıcı";
        }else{
            return field;
        }

    }

    public void setField(String field) {
        this.field = field;
    }
}
