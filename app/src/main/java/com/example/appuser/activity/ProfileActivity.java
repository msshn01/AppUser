package com.example.appuser.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appuser.R;
import com.example.appuser.VeriTutucu;
import com.example.appuser.databinding.ActivityMainBinding;
import com.example.appuser.databinding.ActivityProfileBinding;
import com.example.appuser.model.Users;

import org.checkerframework.checker.units.qual.A;

public class ProfileActivity extends AppCompatActivity {
    private ActivityProfileBinding binding;
    public Users selectUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        selectUser = VeriTutucu.getInstance().getKullanici();



        binding.userName.setText(selectUser.getUserName());
        binding.userEmail.setText(selectUser.getEmail());
        binding.userNumber.setText(selectUser.getPhoneNumber());


    }

    public void changeName(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final EditText input = new EditText(this);
        input.setHint("Metninizi girin");
        builder.setView(input);
        builder.setMessage("Yeni isminizi giriniz")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String newData = input.getText().toString();
                        selectUser.setUserName(newData);
                        recreate();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancels the dialog.
                        dialog.cancel();
                    }
                }).show();


    }

    public void changeNumber(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final EditText input = new EditText(this);
        input.setHint("Metninizi girin");
        builder.setView(input);
        builder.setMessage("Yeni numaranızı giriniz")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String newData = input.getText().toString();
                        selectUser.setPhoneNumber(newData);
                        recreate();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancels the dialog.
                        dialog.cancel();
                    }
                }).show();
    }

    public void profileToMenu(View view){
        finish();
    }
}