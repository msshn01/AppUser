package com.example.appuser;

import android.view.LayoutInflater;

import android.view.ViewGroup;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.example.appuser.databinding.CommentsRowBinding;

import com.example.appuser.model.Comments;

import java.util.ArrayList;

public class AdepterComments extends RecyclerView.Adapter<AdepterComments.CommentsHolder> {
    ArrayList<Comments> commentsArrayList;

    public AdepterComments(ArrayList<Comments> commentsArrayList) {
        this.commentsArrayList = commentsArrayList;
    }

    @NonNull
    @Override
    public CommentsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CommentsRowBinding commentsRowBinding = CommentsRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new CommentsHolder(commentsRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsHolder holder, int position) {
        holder.commentsRowBinding.imageBuyer.setImageResource(R.drawable.message);
        holder.commentsRowBinding.commentText.setText(commentsArrayList.get(position).getComment());
        holder.commentsRowBinding.buyerEmail.setText(commentsArrayList.get(position).getBuyer().getEmail());
    }

    @Override
    public int getItemCount() {
        return commentsArrayList.size();
    }

    public static class CommentsHolder extends RecyclerView.ViewHolder{
        CommentsRowBinding commentsRowBinding;
        public CommentsHolder(CommentsRowBinding commentsRowBinding) {
            super(commentsRowBinding.getRoot());
            this.commentsRowBinding = commentsRowBinding;
        }
    }

}
