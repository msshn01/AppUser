package com.example.appuser.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appuser.VeriTutucu;
import com.example.appuser.databinding.ActivityLoginBinding;
import com.example.appuser.model.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null){
            Intent intent = new Intent(binding.getRoot().getContext(),AppMainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            VeriTutucu.getInstance().setKullanici(new Users(mAuth.getCurrentUser().getEmail(),"0"));
        }
    }


    public void enterLogin(View view){
        //kayıt arama yoksa hesap oluşturma firebase

        String email = binding.emailText.getText().toString();
        String password = binding.paswoardText.getText().toString();

        mAuth = FirebaseAuth.getInstance();




        if (email.isEmpty() || password.isEmpty()){
            Snackbar.make(view, "Bilgiler boş olamaz", Snackbar.LENGTH_SHORT).show();
        }else {
            mAuth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){

                                user = mAuth.getCurrentUser();

                                VeriTutucu.getInstance().setKullanici(new Users(user.getEmail(),"0"));
                                Intent intent = new Intent(binding.getRoot().getContext(),AppMainActivity.class);
                                System.out.println("kayıtlı kullanıcı girişi yapıldı: " + user.getEmail());
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                finish();
                            }else{
                                System.out.println(Objects.requireNonNull(task.getException()).toString());
                            }

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            System.out.println("Hazır kullanıcı yok");
                            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){

                                        FirebaseUser userNew = mAuth.getCurrentUser();

                                        Intent intent = new Intent(binding.getRoot().getContext(),AppMainActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(intent);
                                        finish();
                                        System.out.println("Kullanıcı oluşturuldu : " + userNew.getEmail());
                                        VeriTutucu.getInstance().setKullanici(new Users(userNew.getEmail(),"0"));
                                    }else{
                                        System.out.println(Objects.requireNonNull(task.getException()).toString());
                                    }
                                }
                            });
                        }
                    });


        }



    }
}