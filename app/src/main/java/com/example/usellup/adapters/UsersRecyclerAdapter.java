package com.example.usellup.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.usellup.R;
import com.example.usellup.models.user_model;

import java.util.ArrayList;

public class UsersRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<user_model> user_items;
    Activity activity;

    public UsersRecyclerAdapter(ArrayList<user_model> user_items, Activity activity){
        this.user_items=user_items;
        this.activity=activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemsView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_profile,parent,false);
        return new Holder(itemsView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final Holder classHolder = (Holder) holder;
        classHolder.tv_user_name.setText(user_items.get(position).getName());
        Glide.with(holder.itemView.getContext())
                .load(user_items.get(position).getImage())
                .apply(RequestOptions.circleCropTransform())
                .into(classHolder.imv_profile);
    }

    @Override
    public int getItemCount() {
        return user_items.size();
    }


    static class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_user_name;
        ImageView imv_profile;

        public Holder(View itemView) {
            super(itemView);
            tv_user_name = (TextView) itemView.findViewById(R.id.tv_user_name);
            imv_profile = (ImageView) itemView.findViewById(R.id.imv_profile);
        }

        @Override
        public void onClick(View v) {
            //TODO = Action on click
        }
    }
}