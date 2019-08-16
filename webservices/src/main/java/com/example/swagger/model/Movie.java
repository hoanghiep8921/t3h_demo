package com.example.swagger.model;

import io.swagger.annotations.ApiModelProperty;

public class Movie {
    @ApiModelProperty(notes = "Id of movie")
    private int id;
    @ApiModelProperty(notes = "Name of movie")
    private String name;

    @ApiModelProperty(notes = "Year of release movie")
    private int year;
    @ApiModelProperty(notes = "Image of movie")
    private String image;
    @ApiModelProperty(notes = "Actor of movie")
    private Actor actor;

    @ApiModelProperty(notes = "Rating of movie")
    private double rate;

    public Movie(int id, String name, int year, String image, Actor actor, double rate) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.image = image;
        this.actor = actor;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
