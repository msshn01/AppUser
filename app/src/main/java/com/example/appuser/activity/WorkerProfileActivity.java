package com.example.appuser.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appuser.DataApp;
import com.example.appuser.VeriTutucu;
import com.example.appuser.databinding.ActivitySearchBinding;
import com.example.appuser.databinding.ActivityWorkerProfileBinding;
import com.example.appuser.model.Users;

public class WorkerProfileActivity extends AppCompatActivity {
    private ActivityWorkerProfileBinding binding;
    Users selectUser;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWorkerProfileBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        selectUser = DataApp.getInstance().getSendUser();


        binding.userName.setText(selectUser.getUserName());
        binding.userEmail.setText(selectUser.getEmail());
        binding.userNumber.setText(selectUser.getPhoneNumber());
        binding.textPoint.setText("Memnuniyet: " + selectUser.getPoint());

    }

    public void profileToMenu(View view) {
        finish();

    }
}