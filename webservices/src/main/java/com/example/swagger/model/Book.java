package com.example.swagger.model;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "Id of book auto increase")
    private Integer id;
    @Column(name = "name")
    @ApiModelProperty(notes = "Name of book")
    private String name;

    @ApiModelProperty(notes = "Category of book")
    @Column(name = "category")
    private Integer category;

    @Column(name = "year")
    @ApiModelProperty(notes = "Year of release book")
    private Integer year;

    @ApiModelProperty(notes = "Name actor of book")
    @Column(name = "actor")
    private String actor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
