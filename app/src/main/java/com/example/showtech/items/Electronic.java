package com.example.showtech.items;


import com.example.showtech.DetailsActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class Electronic implements Serializable {

    private String name;
    private Float price;
    private String description;
    private String specification;
    private DetailsActivity details;
    private ArrayList<Integer> images;

    public Electronic() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public ArrayList<Integer> getImages() {
        return images;
    }

    public void setImages(ArrayList<Integer> images) {
        this.images = images;
    }
}
