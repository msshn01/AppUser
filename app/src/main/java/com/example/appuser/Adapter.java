package com.example.appuser;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appuser.activity.ProfileActivity;
import com.example.appuser.activity.WorkerProfileActivity;
import com.example.appuser.databinding.RecyclerRowBinding;
import com.example.appuser.model.Users;
import com.example.appuser.model.Worker;

import java.util.ArrayList;



public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {
    private ArrayList<Worker> arrayList;

    public Adapter(ArrayList<Worker> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return  new Holder(recyclerRowBinding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Holder holder, @SuppressLint("RecyclerView") int position) {
        holder.recyclerRowBinding.txtName.setText(arrayList.get(position).getUserName().substring(0, 1).toUpperCase() + arrayList.get(position).getUserName().substring(1).toLowerCase());
        holder.recyclerRowBinding.txtScore.setText("Score: 85");
        holder.recyclerRowBinding.txtJob.setText(arrayList.get(position).getJob().substring(0, 1).toUpperCase() + arrayList.get(position).getJob().substring(1).toLowerCase());


        holder.recyclerRowBinding.imgArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataApp.getInstance().setSendUser(arrayList.get(position));
                Intent intent = new Intent(v.getContext(), WorkerProfileActivity.class);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {
        RecyclerRowBinding recyclerRowBinding;

        public Holder(RecyclerRowBinding recyclerRowBinding) {
            super(recyclerRowBinding.getRoot());
            this.recyclerRowBinding = recyclerRowBinding;
        }


    }
}
