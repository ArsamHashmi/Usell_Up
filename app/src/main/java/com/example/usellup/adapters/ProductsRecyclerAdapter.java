package com.example.usellup.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.usellup.R;
import com.example.usellup.models.product_model;
import com.google.android.material.button.MaterialButton;
import com.willy.ratingbar.ScaleRatingBar;

import java.util.ArrayList;

public class ProductsRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<product_model> product_items;
    Activity activity;

    public ProductsRecyclerAdapter(ArrayList<product_model> product_items, Activity activity){
        this.product_items=product_items;
        this.activity=activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemsView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false);
        return new Holder(itemsView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final Holder classHolder = (Holder) holder;
        classHolder.tv_product_title.setText(product_items.get(position).getProduct_title());
        classHolder.tv_price_new.setText(String.valueOf(product_items.get(position).getPrice_now()));
        classHolder.tv_price_off.setText(product_items.get(position).getPrice_off_percent() +"%");
        classHolder.btn_distance.setText(String.valueOf(product_items.get(position).getDistance()));
        classHolder.ratingBar.setRating(product_items.get(position).getRating());

        classHolder.tv_price_old .setText(
                String.valueOf(product_items.get(position).getPrice_old()), TextView.BufferType.SPANNABLE);
        StrikethroughSpan STRIKE_THROUGH_SPAN = new StrikethroughSpan();
        Spannable spannable = (Spannable) classHolder.tv_price_old.getText();
        spannable.setSpan(STRIKE_THROUGH_SPAN, 0, classHolder.tv_price_old.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        classHolder.tv_price_old.setText(spannable);

        Glide.with(holder.itemView.getContext())
                .load(product_items.get(position).getImage())
                .into(classHolder.imv_product_image);
    }

    @Override
    public int getItemCount() {
        return product_items.size();
    }


    static class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_price_old, tv_price_new, tv_price_off, tv_product_title;
        MaterialButton btn_distance;
        ImageView imv_product_image;
        ScaleRatingBar ratingBar;

        public Holder(View itemView) {
            super(itemView);
            tv_price_old = (TextView) itemView.findViewById(R.id.tv_price_old);
            tv_price_new = (TextView) itemView.findViewById(R.id.tv_slider_price_new);
            tv_price_off = (TextView) itemView.findViewById(R.id.tv_percent_price_off);
            tv_product_title = (TextView) itemView.findViewById(R.id.tv_product_title);
            btn_distance = (MaterialButton) itemView.findViewById(R.id.btn_distance);
            ratingBar = (ScaleRatingBar) itemView.findViewById(R.id.simpleRatingBar);
            imv_product_image = (ImageView) itemView.findViewById(R.id.imv_product_image);
        }

        @Override
        public void onClick(View v) {
            //TODO = Action on click
        }
    }
}