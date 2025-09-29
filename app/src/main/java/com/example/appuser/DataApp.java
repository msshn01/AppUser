package com.example.appuser;

import com.example.appuser.model.Employer;
import com.example.appuser.model.Users;
import com.example.appuser.model.Worker;

import java.util.ArrayList;

public class DataApp {

        private static com.example.appuser.DataApp instance;  // Tek bir örnek (singleton)
        private ArrayList<Users> usersArrayList;         // Saklanacak veri
        private ArrayList<Worker> workerArrayList;         // Saklanacak veri
        private ArrayList<Employer> employerArrayList;         // Saklanacak veri
        private Users sendUser;
        public DataApp() {} // Dışarıdan nesne oluşturulmasını engeller
        // Global erişim için meto
        public static com.example.appuser.DataApp getInstance() {
            if (instance == null) {
                instance = new com.example.appuser.DataApp();
            }
            return instance;
        }

    public Users getSendUser() {
        return sendUser;
    }

    public void setSendUser(Users sendUser) {
        this.sendUser = sendUser;
    }

    public ArrayList<Users> getUsersArrayList() {
            return usersArrayList;
        }

        public void setUsersArrayList(ArrayList<Users> usersArrayList) {
            this.usersArrayList = usersArrayList;
        }

        public ArrayList<Worker> getWorkerArrayList() {
            return workerArrayList;
        }

        public void setWorkerArrayList(ArrayList<Worker> workerArrayList) {
            this.workerArrayList = workerArrayList;
        }

        public ArrayList<Employer> getEmployerArrayList() {
            return employerArrayList;
        }

        public void setEmployerArrayList(ArrayList<Employer> employerArrayList) {
            this.employerArrayList = employerArrayList;
        }
}
