package com.example.usellup.adapters;

import android.text.Spannable;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.usellup.R;
import com.example.usellup.models.slider_model;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterViewHolder> {

    private final List<slider_model> mSliderItems;

    public SliderAdapter(ArrayList<slider_model> sliderDataArrayList) {
        this.mSliderItems = sliderDataArrayList;
    }

    @Override
    public SliderAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_layout, null);
        return new SliderAdapterViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterViewHolder viewHolder, final int position) {

        final slider_model sliderItem = mSliderItems.get(position);

        Glide.with(viewHolder.itemView)
                .load(sliderItem.getImage())
                .fitCenter()
                .into(viewHolder.imageViewBackground);

        viewHolder.tvPriceOld .setText(String.valueOf(sliderItem.getPrice_old()), TextView.BufferType.SPANNABLE);
        StrikethroughSpan STRIKE_THROUGH_SPAN = new StrikethroughSpan();
        Spannable spannable = (Spannable) viewHolder.tvPriceOld.getText();
        spannable.setSpan(STRIKE_THROUGH_SPAN, 0, viewHolder.tvPriceOld.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        viewHolder.tvPriceOld.setText(spannable);

        viewHolder.tvPriceNew.setText(String.valueOf(sliderItem.getPrice_new()));
        viewHolder.tvPercentOff.setText(String.valueOf(sliderItem.getPercent_off()));
    }

    @Override
    public int getCount() {
        return mSliderItems.size();
    }

    static class SliderAdapterViewHolder extends SliderViewAdapter.ViewHolder {
        View itemView;
        ImageView imageViewBackground;
        TextView tvPriceNew, tvPriceOld, tvPercentOff;

        public SliderAdapterViewHolder(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.imv_slider_image);
            tvPriceNew = itemView.findViewById(R.id.tv_slider_price_new);
            tvPriceOld = itemView.findViewById(R.id.tv_slider_price_old);
            tvPercentOff = itemView.findViewById(R.id.tv_percent_price_off);

            this.itemView = itemView;
        }
    }
}
