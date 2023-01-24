package com.seeksolution.altbalaji.models;

import android.net.Uri;

public class TrendingModel {
    private String imageUrls;

    public TrendingModel(String imageUrls) {
        this.imageUrls = imageUrls;
    }

    public String getImageUrls() {
        return imageUrls;
    }
}
