package com.example.showtech.items;

import android.media.Image;

import com.example.showtech.DetailsActivity;

import java.util.ArrayList;

public class Electronic {

    private String names;
    private Float price;
    private String description;
    private String specification;
    private DetailsActivity details;
    private ArrayList<Image> images;

    public Electronic() {
    }





    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public DetailsActivity getDetails() {
        return details;
    }

    public void setDetails(DetailsActivity details) {
        this.details = details;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }
}
