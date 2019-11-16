package com.example.midterm;

public class Games {
    private String name;
    private String rating;
    private String price;
    private String description;

    public Games(){

    }

    public Games(String name, String rating, String price,String description) {
        this.name = name;
        this.rating = rating;
        this.price = price;
        this.description=description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
