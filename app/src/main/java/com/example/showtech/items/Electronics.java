package com.example.showtech.items;

import com.example.showtech.DetailsActivity;

public class Electronics {

    private String names;
    private Float price;
    private String description;
    private String specification;
    private DetailsActivity details;

    public Electronics() {
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
}
