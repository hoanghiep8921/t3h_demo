package com.example.swagger.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class Actor {

    @ApiModelProperty(notes = "Name of Actor")
    private String name;

    @ApiModelProperty(notes = "Date of birth of actor")
    private Date birthDay;

    @ApiModelProperty(notes = "Gender of actor")
    private int sex;

    @ApiModelProperty(notes = "Dead or alive")
    private boolean isDead;

    public Actor(String name, Date birthDay, int sex, boolean isDead) {
        this.name = name;
        this.birthDay = birthDay;
        this.sex = sex;
        this.isDead = isDead;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }
}
