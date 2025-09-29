package com.example.appuser.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appuser.Adapter;
import com.example.appuser.DataApp;
import com.example.appuser.R;
import com.example.appuser.databinding.ActivityMenuBinding;
import com.example.appuser.databinding.ActivitySearchBinding;
import com.example.appuser.model.Worker;

import java.util.ArrayList;
import java.util.Objects;

public class SearchActivity extends AppCompatActivity {
    private ActivitySearchBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        String na = intent.getStringExtra("search");
        System.out.println(na);
        if (na == null){
            Adapter adapter = new Adapter(DataApp.getInstance().getWorkerArrayList());
            recyclerView.setAdapter(adapter);
        }else{
            ArrayList<Worker> searchList = new ArrayList<>();

            for (int i = 0; i < DataApp.getInstance().getWorkerArrayList().size(); i++) {
                if (DataApp.getInstance().getWorkerArrayList().get(i).getJob().toLowerCase().contains(na.toLowerCase())){
                    searchList.add(DataApp.getInstance().getWorkerArrayList().get(i));
                }

            }
            Adapter adapter = new Adapter(searchList);
            recyclerView.setAdapter(adapter);
        }



    }
}