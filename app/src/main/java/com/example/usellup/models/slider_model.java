package com.example.usellup.models;

public class slider_model {
    int image;
    double price_old,price_new,percent_off;

    public slider_model(int image, double price_old, double price_new, double percent_off) {
        this.image = image;
        this.price_old = price_old;
        this.price_new = price_new;
        this.percent_off = percent_off;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public double getPrice_old() {
        return price_old;
    }

    public void setPrice_old(double price_old) {
        this.price_old = price_old;
    }

    public double getPrice_new() {
        return price_new;
    }

    public void setPrice_new(double price_new) {
        this.price_new = price_new;
    }

    public double getPercent_off() {
        return percent_off;
    }

    public void setPercent_off(double percent_off) {
        this.percent_off = percent_off;
    }
}

