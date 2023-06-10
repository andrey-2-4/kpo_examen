package com.kpoexamen.crudapp.pojo;

import lombok.NonNull;

public class HotelsResponse {
    // буду выводить и id, хотя и не просят, мне кажется, что так удобнее проверять
    private Long id;
    private String title;
    private String address;
    private Double price;
    private Long rating;

    public HotelsResponse(Long id, String title, String address, Double price) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }
}
