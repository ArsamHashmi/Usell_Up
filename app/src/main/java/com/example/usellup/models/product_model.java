package com.example.usellup.models;

public class product_model {
    int image, price_off_percent;
    double price_now, price_old, distance;
    float rating;
    String product_title;

    public product_model(int image, float rating, int price_off_percent, double price_now, double price_old, double distance, String product_title) {
        this.image = image;
        this.rating = rating;
        this.price_off_percent = price_off_percent;
        this.price_now = price_now;
        this.price_old = price_old;
        this.distance = distance;
        this.product_title = product_title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getPrice_off_percent() {
        return price_off_percent;
    }

    public void setPrice_off_percent(int price_off_percent) {
        this.price_off_percent = price_off_percent;
    }

    public double getPrice_now() {
        return price_now;
    }

    public void setPrice_now(double price_now) {
        this.price_now = price_now;
    }

    public double getPrice_old() {
        return price_old;
    }

    public void setPrice_old(double price_old) {
        this.price_old = price_old;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getProduct_title() {
        return product_title;
    }

    public void setProduct_title(String product_title) {
        this.product_title = product_title;
    }
}
