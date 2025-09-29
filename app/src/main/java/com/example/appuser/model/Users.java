package com.example.appuser.model;

import java.io.Serializable;

public class Users implements Serializable {
    String userName;
    String email;
    String phoneNumber;
    String point;

    public String getPasswoard() {
        return passwoard;
    }

    public void setPasswoard(String passwoard) {
        this.passwoard = passwoard;
    }

    String passwoard;

    public Users(String email, String passwoard) {
        this.passwoard = passwoard;
        this.email=email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
