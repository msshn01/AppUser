package com.example.appuser.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appuser.DataApp;
import com.example.appuser.VeriTutucu;
import com.example.appuser.databinding.ActivityMenuBinding;
import com.example.appuser.model.Users;

public class MenuActivity extends AppCompatActivity {
    private ActivityMenuBinding binding;
    public Users selectUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
//        Intent intent = getIntent();
//        selectUser = (Users) intent.getSerializableExtra("selectUser");
    }

    public void goMain(View view){
        finish();
    }

    public void goProfile(View view){
        Intent intent  = new Intent(this,ProfileActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


    public void logOut(View view){
        VeriTutucu.getInstance().setKullanici(null);
        finishAffinity();
    }

}