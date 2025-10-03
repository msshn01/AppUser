package com.example.appuser.activity;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;


import androidx.activity.ComponentActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.appuser.DataApp;
import com.example.appuser.R;

import com.example.appuser.databinding.ActivityMainBinding;
import com.example.appuser.fragment.NewLoginFragment1;
import com.example.appuser.fragment.NewLoginFragment2;
import com.example.appuser.fragment.NewLoginFragment3;
import com.example.appuser.model.Employer;

import com.example.appuser.model.UserProfile;
import com.example.appuser.model.Users;
import com.example.appuser.model.Worker;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.auth.User;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;


public class MainActivity extends AppCompatActivity  {
    private ActivityMainBinding binding;
    ArrayList<Fragment> fragments = new ArrayList<>();
    int i = 1;
    ArrayList<UserProfile> arrayListUsers = new ArrayList<>();
    FirebaseFirestore db ;
    Boolean touch = true;
    FirebaseUser user;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);

        fragments.add(new NewLoginFragment1());
        fragments.add(new NewLoginFragment2());
        fragments.add(new NewLoginFragment3());

        db = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();



        callData();
//
//        for (UserProfile u : arrayListUsers) {
//            HashMap<String,Object> hashMap = new HashMap<>();
//            hashMap.put("name", u.getName());
//            hashMap.put("surname", u.getSurname());
//            hashMap.put("email", u.getEmail());
//            hashMap.put("password", u.getPassword());
//            hashMap.put("number", u.getNumber());
//            hashMap.put("id",u.getId());
//            hashMap.put("field",u.getField());
//            hashMap.put("point",u.getPoint());
//            db.collection("users").add(hashMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                @Override
//                public void onSuccess(DocumentReference documentReference) {
//                    System.out.println("Db yazımı tamamlandı");
//                }
//            }).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    System.out.println("Db yazımı tamamlanamadı!!!! " + u.getId());
//                }
//            });
//
//        }



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


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (touch) {
            // dokunmayı engelle
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }



    public void callData(){


        FrameLayout loadingOverlay = findViewById(R.id.loadingOverlay);


        loadingOverlay.setVisibility(View.VISIBLE);


        db.collection("users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String name = Objects.requireNonNull(document.getData().get("name")).toString();
                        String surname = Objects.requireNonNull(document.getData().get("surname")).toString();
                        String email = Objects.requireNonNull(document.getData().get("email")).toString();
                        String password = Objects.requireNonNull(document.getData().get("password")).toString();
                        String number = Objects.requireNonNull(document.getData().get("number")).toString();
                        String field = Objects.requireNonNull(document.getData().get("field")).toString();
                        String id = Objects.requireNonNull(document.getData().get("id")).toString();
                        String point = Objects.requireNonNull(document.getData().get("point")).toString();
                        UserProfile userProfile = new UserProfile(name,surname,email,password,number,field,point);
                        arrayListUsers.add(userProfile);
                    }

                    DataApp.getInstance().setUsersArrayList(arrayListUsers);
                    System.out.println("Veri çekildi listeye yazıldı");
                    System.out.println("Dokunmatik açıldı");
                    touch = false;
                    loadingOverlay.setVisibility(View.GONE);

                    if (user != null){
                        skip(binding.getRoot());
                    }
                }
            }
        });





















//
//        arrayListUsers.add(new UserProfile("Musa","Şahan","musa.sahan@gmail.com","000000","5540108683","Sıvacı","7"));
//        arrayListUsers.add(new UserProfile("Ahmet","Demir","ahmet.demir@gmail.com","123456","5321234567","Boyacı","3"));
//        arrayListUsers.add(new UserProfile("Ayşe","Kaya","ayse.kaya@gmail.com","654321","5307654321","Özel Ders Öğretmeni","10"));
//        arrayListUsers.add(new UserProfile("Mehmet","Çelik","mehmet.celik@gmail.com","987654","5559876543","Tesisatçı","2"));
//        arrayListUsers.add(new UserProfile("Fatma","Yılmaz","fatma.yilmaz@gmail.com","456789","5344567890","Temizlikçi","9"));
//        arrayListUsers.add(new UserProfile("Elif","Aydın","elif.aydin@gmail.com","111222","5369876543","Elektrikçi","4"));
//        arrayListUsers.add(new UserProfile("Can","Koç","can.koc@gmail.com","222333","5377654321","Marangoz","1"));
//        arrayListUsers.add(new UserProfile("Zeynep","Arslan","zeynep.arslan@gmail.com","333444","5383456789","Kuaför","6"));
//        arrayListUsers.add(new UserProfile("Efe","Polat","efe.polat@gmail.com","444555","5391239876","Tamirci","5"));
//        arrayListUsers.add(new UserProfile("Selin","Taş","selin.tas@gmail.com","555666","5306789123","Aşçı","8"));
//
//        arrayListUsers.add(new UserProfile("Burak","Şimşek","burak.simsek@gmail.com","666777","5312345678","Garson","2"));
//        arrayListUsers.add(new UserProfile("Hakan","Öztürk","hakan.ozturk@gmail.com","777888","5328765432","Kaynakçı","7"));
//        arrayListUsers.add(new UserProfile("Gamze","Kurt","gamze.kurt@gmail.com","888999","5337654321","Çilingir","9"));
//        arrayListUsers.add(new UserProfile("Kerem","Sevgi","kerem.sevgi@gmail.com","999000","5348761234","Bahçıvan","1"));
//        arrayListUsers.add(new UserProfile("Deniz","Yalçın","deniz.yalcin@gmail.com","121212","5356547890","Güvenlik Görevlisi","0"));
//        arrayListUsers.add(new UserProfile("Ceren","Bal","ceren.bal@gmail.com","232323","5369871234","Nakliyeci","3"));
//        arrayListUsers.add(new UserProfile("Mert","Ergin","mert.ergin@gmail.com","343434","5374567891","Mobilyacı","10"));
//        arrayListUsers.add(new UserProfile("Aslı","Doğan","asli.dogan@gmail.com","454545","5386543210","Usta","6"));
//        arrayListUsers.add(new UserProfile("Onur","Başar","onur.basar@gmail.com","565656","5397894561","İnşaat İşçisi","4"));
//        arrayListUsers.add(new UserProfile("Pelin","Kara","pelin.kara@gmail.com","676767","5301122334","Boya Ustası","8"));
//
//        arrayListUsers.add(new UserProfile("Serkan","Uçar","serkan.ucar@gmail.com","787878","5319988776","Parke Döşemeci","2"));
//        arrayListUsers.add(new UserProfile("Yasemin","Çınar","yasemin.cinar@gmail.com","898989","5324455667","Temizlik Görevlisi","7"));
//        arrayListUsers.add(new UserProfile("Emre","Altun","emre.altun@gmail.com","909090","5333344556","Camcı","9"));
//        arrayListUsers.add(new UserProfile("Hande","Karaaslan","hande.karaaslan@gmail.com","112233","5342233445","Klima Servisi","1"));
//        arrayListUsers.add(new UserProfile("Tolga","Yıldırım","tolga.yildirim@gmail.com","223344","5351122334","Halı Yıkamacı","0"));
//        arrayListUsers.add(new UserProfile("Seda","Güneş","seda.gunes@gmail.com","334455","5369988776","Dikiş Ustası","3"));
//        arrayListUsers.add(new UserProfile("Barış","Eren","baris.eren@gmail.com","445566","5378877665","Mobilya Tamircisi","5"));
//        arrayListUsers.add(new UserProfile("Melis","Acar","melis.acar@gmail.com","556677","5387766554","Çatı Ustası","6"));
//        arrayListUsers.add(new UserProfile("Furkan","Bozkurt","furkan.bozkurt@gmail.com","667788","5396655443","Bahçe Düzenleyici","8"));
//        arrayListUsers.add(new UserProfile("Sinem","Türkmen","sinem.turkmen@gmail.com","778899","5305544332","Boyacı Ustası","4"));
//
//        arrayListUsers.add(new UserProfile("Kaan","Orhan","kaan.orhan@gmail.com","889900","5314433221","Asansör Bakımcısı","10"));
//        arrayListUsers.add(new UserProfile("Büşra","Çetin","busra.cetin@gmail.com","990011","5323322110","CNC Operatörü","2"));
//        arrayListUsers.add(new UserProfile("Okan","Aksoy","okan.aksoy@gmail.com","101010","5332211009","Kaynak Ustası","9"));
//        arrayListUsers.add(new UserProfile("Nazlı","Ersoy","nazli.ersoy@gmail.com","202020","5341100998","Su Tesisatçısı","3"));
//        arrayListUsers.add(new UserProfile("Alper","Özkan","alper.ozkan@gmail.com","303030","5350099887","Doğalgaz Ustası","7"));
//        arrayListUsers.add(new UserProfile("Derya","Tekin","derya.tekin@gmail.com","404040","5369988775","Alçıpan Ustası","1"));
//        arrayListUsers.add(new UserProfile("Gökhan","Ekinci","gokhan.ekinci@gmail.com","505050","5378877664","Duvar Ustası","5"));
//        arrayListUsers.add(new UserProfile("Sevgi","Ulu","sevgi.ulu@gmail.com","606060","5387766553","Fayans Döşeyici","6"));
//        arrayListUsers.add(new UserProfile("Levent","Çolak","levent.colak@gmail.com","707070","5396655442","PVC Ustası","8"));
//        arrayListUsers.add(new UserProfile("Özlem","Sağlam","ozlem.saglam@gmail.com","808080","5305544331","Elektrikçi","0"));
//
//        arrayListUsers.add(new UserProfile("İsmail","Tunç","ismail.tunc@gmail.com","909191","5314433220","Kombi Servisi","2"));
//        arrayListUsers.add(new UserProfile("Mine","Başaran","mine.basaran@gmail.com","121314","5323322109","Mobilya Montajcısı","9"));
//        arrayListUsers.add(new UserProfile("Cihan","Toprak","cihan.toprak@gmail.com","141516","5332211008","Mutfak Dolapçısı","3"));
//        arrayListUsers.add(new UserProfile("Ezgi","Özer","ezgi.ozer@gmail.com","171819","5341100997","Perdeci","7"));
//        arrayListUsers.add(new UserProfile("Umut","Saçlı","umut.sacli@gmail.com","202122","5350099886","Demir Doğramacı","1"));
//        arrayListUsers.add(new UserProfile("Selma","Akın","selma.akin@gmail.com","232425","5369988774","Boyacı","4"));
//        arrayListUsers.add(new UserProfile("Koray","Erbil","koray.erbil@gmail.com","262728","5378877663","Sıhhi Tesisatçı","6"));
//        arrayListUsers.add(new UserProfile("Şule","Çakır","sule.cakir@gmail.com","292931","5387766552","Duvar Kağıdı Döşeyici","0"));
//        arrayListUsers.add(new UserProfile("Harun","Yavuz","harun.yavuz@gmail.com","323334","5396655441","Parke Ustası","5"));
//        arrayListUsers.add(new UserProfile("Betül","Korkmaz","betul.korkmaz@gmail.com","353637","5306677889","Temizlikçi","8"));
//        arrayListUsers.add(new UserProfile("Arda","Keskin","arda.keskin@gmail.com","141414","5301112233","null","null"));
//        arrayListUsers.add(new UserProfile("Nil","Özdemir","nil.ozdemir@gmail.com","151515","5312223344","null","null"));
//        arrayListUsers.add(new UserProfile("Tuna","Boz","tuna.boz@gmail.com","161616","5323334455","null","null"));
//        arrayListUsers.add(new UserProfile("Ceyda","Bulut","ceyda.bulut@gmail.com","171717","5334445566","null","null"));
//        arrayListUsers.add(new UserProfile("Ulaş","Akpınar","ulas.akpinar@gmail.com","181818","5345556677","null","null"));
//        arrayListUsers.add(new UserProfile("Melike","Türkmen","melike.turkmen@gmail.com","191919","5356667788","null","null"));
//        arrayListUsers.add(new UserProfile("Erdem","Sarı","erdem.sari@gmail.com","202020","5367778899","null","null"));
//        arrayListUsers.add(new UserProfile("Aylin","Şentürk","aylin.senturk@gmail.com","212121","5378889900","null","null"));
//        arrayListUsers.add(new UserProfile("Gürkan","Yıldız","gurkan.yildiz@gmail.com","222222","5389990011","null","null"));
//        arrayListUsers.add(new UserProfile("İpek","Ersoy","ipek.ersoy@gmail.com","232323","5391112234","null","null"));
//        arrayListUsers.add(new UserProfile("Volkan","Kaya","volkan.kaya@gmail.com","242424","5302223345","null","null"));
//        arrayListUsers.add(new UserProfile("Damla","Şahin","damla.sahin@gmail.com","252525","5313334456","null","null"));
//        arrayListUsers.add(new UserProfile("Çağrı","Deniz","cagri.deniz@gmail.com","262626","5324445567","null","null"));
//        arrayListUsers.add(new UserProfile("Sibel","Uzun","sibel.uzun@gmail.com","272727","5335556678","null","null"));


    }





    public void skip(View view){


        //giriş ve kayıt
        Intent intent = new Intent(this,LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();



    }
    //58888888888888888888888888888888888888888888888888888
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