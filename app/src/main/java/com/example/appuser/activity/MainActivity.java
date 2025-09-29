package com.example.appuser.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.appuser.DataApp;
import com.example.appuser.R;
import com.example.appuser.VeriTutucu;
import com.example.appuser.databinding.ActivityMainBinding;
import com.example.appuser.fragment.NewLoginFragment1;
import com.example.appuser.fragment.NewLoginFragment2;
import com.example.appuser.fragment.NewLoginFragment3;
import com.example.appuser.model.Employer;
import com.example.appuser.model.UserProfile;
import com.example.appuser.model.Users;
import com.example.appuser.model.Worker;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Objects;

public class MainActivity extends AppCompatActivity  {
    private ActivityMainBinding binding;
    ArrayList<Fragment> fragments = new ArrayList<>();
    int i = 1;
    Worker selectUser;
    ArrayList<UserProfile> userProfiles = new ArrayList<>();
    ArrayList<Users> arrayListUsers ;
    ArrayList<Worker> workerArrayList ;
    ArrayList<Employer> employerArrayList ;
//    private FirebaseAuth mAuth;
    FirebaseFirestore firebaseFirestore;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);

        fragments.add(new NewLoginFragment1());
        fragments.add(new NewLoginFragment2());
        fragments.add(new NewLoginFragment3());






        selectUser = null;


        callData();

//        if (selectUser != null){
//            VeriTutucu.getInstance().setKullanici(selectUser);
//            skip(view);
//        }else{
//            Intent intent = new Intent(this,LoginActivity.class);
//            this.startActivity(intent);
//            finish();
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        }
    }





    public void callData(){
        arrayListUsers = new ArrayList<>();
        workerArrayList = new ArrayList<>();
        employerArrayList = new ArrayList<>();
        // --- Users ---
        arrayListUsers.add(new Users("user1@example.com", "pass123"));
        arrayListUsers.add(new Users("user2@example.com", "abc456"));
        arrayListUsers.add(new Users("user3@example.com", "qwe789"));
        arrayListUsers.add(new Users("user4@example.com", "zxc321"));
        arrayListUsers.add(new Users("user5@example.com", "pass999"));
        arrayListUsers.add(new Users("user6@example.com", "login321"));
        arrayListUsers.add(new Users("user7@example.com", "secret456"));
        arrayListUsers.add(new Users("user8@example.com", "mypwd789"));
        arrayListUsers.add(new Users("user9@example.com", "test1234"));
        arrayListUsers.add(new Users("user10@example.com", "hello321"));
// --- Workers ---
        Worker worker1 = new Worker("worker1@example.com", "wpass1", "boyacı");
        worker1.setUserName("MehmetYıldız");
        worker1.setPoint("9.2");

        Worker worker2 = new Worker("worker2@example.com", "wpass2", "tesisatçı");
        worker2.setUserName("AyşeKara");
        worker2.setPoint("8.7");

        Worker worker3 = new Worker("worker3@example.com", "wpass3", "elektrikçi");
        worker3.setUserName("AliDemir");
        worker3.setPoint("7.5");

        Worker worker4 = new Worker("worker4@example.com", "wpass4", "marangoz");
        worker4.setUserName("ZeynepGüneş");
        worker4.setPoint("9.0");

        Worker worker5 = new Worker("worker5@example.com", "wpass5", "mekanikçi");
        worker5.setUserName("BurakKurt");
        worker5.setPoint("8.3");

        Worker worker6 = new Worker("worker6@example.com", "wpass6", "kaynakçı");
        worker6.setUserName("ElifAslan");
        worker6.setPoint("7.8");

        Worker worker7 = new Worker("worker7@example.com", "wpass7", "inşaatçı");
        worker7.setUserName("CanÖztürk");
        worker7.setPoint("8.5");

        Worker worker8 = new Worker("worker8@example.com", "wpass8", "şoför");
        worker8.setUserName("FatmaYalçın");
        worker8.setPoint("9.1");

        Worker worker9 = new Worker("worker9@example.com", "wpass9", "teknisyen");
        worker9.setUserName("MertDoğan");
        worker9.setPoint("7.9");

        Worker worker10 = new Worker("worker10@example.com", "wpass10", "çatı ustası");
        worker10.setUserName("EceŞahin");
        worker10.setPoint("8.0");

// 20 yeni worker daha

        Worker worker11 = new Worker("worker11@example.com", "wpass11", "tesisatçı");
        worker11.setUserName("AhmetKoç");
        worker11.setPoint("8.6");

        Worker worker12 = new Worker("worker12@example.com", "wpass12", "boyacı");
        worker12.setUserName("SelinÇelik");
        worker12.setPoint("7.4");

        Worker worker13 = new Worker("worker13@example.com", "wpass13", "elektrikçi");
        worker13.setUserName("HakanEr");
        worker13.setPoint("9.1");

        Worker worker14 = new Worker("worker14@example.com", "wpass14", "boyacı");
        worker14.setUserName("GizemUslu");
        worker14.setPoint("8.2");

        Worker worker15 = new Worker("worker15@example.com", "wpass15", "marangoz");
        worker15.setUserName("KemalBozkurt");
        worker15.setPoint("7.7");

        Worker worker16 = new Worker("worker16@example.com", "wpass16", "tesisatçı");
        worker16.setUserName("YaseminAydın");
        worker16.setPoint("8.9");

        Worker worker17 = new Worker("worker17@example.com", "wpass17", "mekanikçi");
        worker17.setUserName("SerkanYıldız");
        worker17.setPoint("7.3");

        Worker worker18 = new Worker("worker18@example.com", "wpass18", "boyacı");
        worker18.setUserName("CemAksoy");
        worker18.setPoint("9.0");

        Worker worker19 = new Worker("worker19@example.com", "wpass19", "kaynakçı");
        worker19.setUserName("MelisaTuna");
        worker19.setPoint("7.6");

        Worker worker20 = new Worker("worker20@example.com", "wpass20", "şoför");
        worker20.setUserName("TanerYavuz");
        worker20.setPoint("8.1");

        Worker worker21 = new Worker("worker21@example.com", "wpass21", "elektrikçi");
        worker21.setUserName("SevgiTopal");
        worker21.setPoint("9.3");

        Worker worker22 = new Worker("worker22@example.com", "wpass22", "mekanikçi");
        worker22.setUserName("KoraySönmez");
        worker22.setPoint("8.2");

        Worker worker23 = new Worker("worker23@example.com", "wpass23", "inşaatçı");
        worker23.setUserName("BetülAkın");
        worker23.setPoint("7.8");

        Worker worker24 = new Worker("worker24@example.com", "wpass24", "çatı ustası");
        worker24.setUserName("UfukDikmen");
        worker24.setPoint("9.4");

        Worker worker25 = new Worker("worker25@example.com", "wpass25", "teknisyen");
        worker25.setUserName("DeryaKar");
        worker25.setPoint("8.3");

        Worker worker26 = new Worker("worker26@example.com", "wpass26", "boyacı");
        worker26.setUserName("OnurAltun");
        worker26.setPoint("9.5");

        Worker worker27 = new Worker("worker27@example.com", "wpass27", "tesisatçı");
        worker27.setUserName("İlaydaKurt");
        worker27.setPoint("7.9");

        Worker worker28 = new Worker("worker28@example.com", "wpass28", "elektrikçi");
        worker28.setUserName("TolgaUçar");
        worker28.setPoint("8.7");

        Worker worker29 = new Worker("worker29@example.com", "wpass29", "marangoz");
        worker29.setUserName("NazlıDemirtaş");
        worker29.setPoint("7.6");

        Worker worker30 = new Worker("worker30@example.com", "wpass30", "boyacı");
        worker30.setUserName("ErhanBal");
        worker30.setPoint("9.1");


        worker1.setPhoneNumber("5540123456");
        worker2.setPhoneNumber("5309876543");
        worker3.setPhoneNumber("5321234567");
        worker4.setPhoneNumber("5537654321");
        worker5.setPhoneNumber("5052345678");
        worker6.setPhoneNumber("5456789012");
        worker7.setPhoneNumber("5073456789");
        worker8.setPhoneNumber("5314567890");
        worker9.setPhoneNumber("5591231234");
        worker10.setPhoneNumber("5386543210");

        worker11.setPhoneNumber("5347891234");
        worker12.setPhoneNumber("5523216549");
        worker13.setPhoneNumber("5397418529");
        worker14.setPhoneNumber("5449638527");
        worker15.setPhoneNumber("5011597538");
        worker16.setPhoneNumber("5572583691");
        worker17.setPhoneNumber("5063571594");
        worker18.setPhoneNumber("5374569512");
        worker19.setPhoneNumber("5047531598");
        worker20.setPhoneNumber("5328527419");

        worker21.setPhoneNumber("5367412583");
        worker22.setPhoneNumber("5483691475");
        worker23.setPhoneNumber("5107894561");
        worker24.setPhoneNumber("5561594872");
        worker25.setPhoneNumber("5359517536");
        worker26.setPhoneNumber("5501239874");
        worker27.setPhoneNumber("5334563217");
        worker28.setPhoneNumber("5478529630");
        worker29.setPhoneNumber("5491592638");
        worker30.setPhoneNumber("5437896541");


// Listeye ekleme
        workerArrayList.add(worker1);
        workerArrayList.add(worker2);
        workerArrayList.add(worker3);
        workerArrayList.add(worker4);
        workerArrayList.add(worker5);
        workerArrayList.add(worker6);
        workerArrayList.add(worker7);
        workerArrayList.add(worker8);
        workerArrayList.add(worker9);
        workerArrayList.add(worker10);
        workerArrayList.add(worker11);
        workerArrayList.add(worker12);
        workerArrayList.add(worker13);
        workerArrayList.add(worker14);
        workerArrayList.add(worker15);
        workerArrayList.add(worker16);
        workerArrayList.add(worker17);
        workerArrayList.add(worker18);
        workerArrayList.add(worker19);
        workerArrayList.add(worker20);
        workerArrayList.add(worker21);
        workerArrayList.add(worker22);
        workerArrayList.add(worker23);
        workerArrayList.add(worker24);
        workerArrayList.add(worker25);
        workerArrayList.add(worker26);
        workerArrayList.add(worker27);
        workerArrayList.add(worker28);
        workerArrayList.add(worker29);
        workerArrayList.add(worker30);

// --- Employers ---
        employerArrayList.add(new Employer("employer1@example.com", "epass1", "05070010001"));
        employerArrayList.add(new Employer("employer2@example.com", "epass2", "05070010002"));
        employerArrayList.add(new Employer("employer3@example.com", "epass3", "05070010003"));
        employerArrayList.add(new Employer("employer4@example.com", "epass4", "05070010004"));
        employerArrayList.add(new Employer("employer5@example.com", "epass5", "05070010005"));
        employerArrayList.add(new Employer("employer6@example.com", "epass6", "05070010006"));
        employerArrayList.add(new Employer("employer7@example.com", "epass7", "05070010007"));
        employerArrayList.add(new Employer("employer8@example.com", "epass8", "05070010008"));
        employerArrayList.add(new Employer("employer9@example.com", "epass9", "05070010009"));
        employerArrayList.add(new Employer("employer10@example.com", "epass10", "05070010010"));


        DataApp.getInstance().setEmployerArrayList(employerArrayList);
        DataApp.getInstance().setUsersArrayList(arrayListUsers);
        DataApp.getInstance().setWorkerArrayList(workerArrayList);



    }





    public void skip(View view){

        if (selectUser == null){
            //giriş ve kayıt
            Intent intent = new Intent(this,LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }else {
            
        }


    }

    public void nextFunc(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(i != 3){
            fragmentTransaction.replace(R.id.fragmentContainerView2,fragments.get(i)).commit();
            i++;
        }else{
            skip(view);
        }
    }
}