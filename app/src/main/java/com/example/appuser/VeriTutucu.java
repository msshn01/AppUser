package com.example.appuser;

import com.example.appuser.model.Users;

public class VeriTutucu {
    private static VeriTutucu instance;  // Tek bir örnek (singleton)
    private Users kullanici;         // Saklanacak veri

    public VeriTutucu() {} // Dışarıdan nesne oluşturulmasını engeller

    // Global erişim için metot
    public static VeriTutucu getInstance() {
        if (instance == null) {
            instance = new VeriTutucu();
        }
        return instance;
    }

    // Veri ayarlama (setter)
    public void setKullanici(Users kullanici) {
        this.kullanici = kullanici;
    }

    // Veri alma (getter)
    public Users getKullanici() {
        return kullanici;
    }
}
