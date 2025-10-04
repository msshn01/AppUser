package com.example.appuser.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appuser.AdepterComments;
import com.example.appuser.DataApp;
import com.example.appuser.VeriTutucu;
import com.example.appuser.databinding.ActivitySearchBinding;
import com.example.appuser.databinding.ActivityWorkerProfileBinding;
import com.example.appuser.model.Comments;
import com.example.appuser.model.UserProfile;
import com.example.appuser.model.Users;

import java.util.ArrayList;

public class WorkerProfileActivity extends AppCompatActivity {
    private ActivityWorkerProfileBinding binding;
    UserProfile selectUser;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWorkerProfileBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        selectUser = DataApp.getInstance().getSendUser();


        binding.userName.setText(selectUser.getName());
        binding.textView15.setText(selectUser.getName().toUpperCase()+ " 's profile");
        binding.userEmail.setText(selectUser.getEmail());
        binding.userNumber.setText(selectUser.getNumber());
        binding.textPoint.setText("Memnuniyet: " + selectUser.getPoint());

        ArrayList<Comments> commentsArrayList;
        commentsArrayList = new ArrayList<>();

        Comments comments = new Comments(selectUser,selectUser,"Tam bir fiyat performans ürünü tavsiye ederim");
        commentsArrayList.add(comments);
        commentsArrayList.add(comments);
        commentsArrayList.add(comments);
        commentsArrayList.add(comments);
        commentsArrayList.add(comments);
        commentsArrayList.add(comments);
        commentsArrayList.add(comments);
        commentsArrayList.add(comments);

        AdepterComments adepterComments = new AdepterComments(commentsArrayList);
        binding.commentRecylcerView.setLayoutManager(new LinearLayoutManager(this));
        binding.commentRecylcerView.setAdapter(adepterComments);



    }

    public void profileToMenu(View view) {
        finish();

    }
}