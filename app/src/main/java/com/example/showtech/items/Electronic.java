package com.example.showtech.items;


import com.example.showtech.DetailsActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Electronic implements Serializable {

    private String name;
    private Float price;
    private String description;
    private String specification;
    private DetailsActivity details;
    private int[] images;
    private int views;

    public Electronic() {
        specification = "";
        views = ThreadLocalRandom.current().nextInt(0, 11);
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

    public int[] getImages() {
        return images;
    }

    public void setImages(ArrayList<Integer> images) {
        this.images = new int[images.size()];

        for (int i = 0; i < images.size(); i++) {
            this.images[i] = images.get(i);
        }
    }

    public int getViews() {
        return views;
    }

    public void addView() {
        this.views++;
    }
}
