package com.example.javaretrofit;

import com.google.gson.annotations.SerializedName;

public class RetroMovies {

    @SerializedName("title")
    private String title;

    @SerializedName("image")
    private String image;

    @SerializedName("rating")
    private Double rating;

    @SerializedName("releaseYear")
    private Integer releaseYear;

    public RetroMovies(String title, String image, Double rating, Integer realeaseYear) {
        this.title = title;
        this.image = image;
        this.rating = rating;
        this.releaseYear = realeaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }
}
