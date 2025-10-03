package com.example.appuser;

import com.example.appuser.model.UserProfile;
import com.example.appuser.model.Users;

import java.util.ArrayList;

public class DataApp {

        private static com.example.appuser.DataApp instance;  // Tek bir örnek (singleton)
        private ArrayList<UserProfile> usersArrayList;
        private UserProfile sendUser;
        public DataApp() {} // Dışarıdan nesne oluşturulmasını engeller
        // Global erişim için meto
        public static com.example.appuser.DataApp getInstance() {
            if (instance == null) {
                instance = new com.example.appuser.DataApp();
            }
            return instance;
        }

    public UserProfile getSendUser() {
        return sendUser;
    }

    public void setSendUser(UserProfile sendUser) {
        this.sendUser = sendUser;
    }

    public ArrayList<UserProfile> getUsersArrayList() {
        return usersArrayList;
    }

    public void setUsersArrayList(ArrayList<UserProfile> usersArrayList) {
        this.usersArrayList = usersArrayList;
    }
}
