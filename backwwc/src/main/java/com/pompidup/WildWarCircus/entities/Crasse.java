package com.pompidup.WildWarCircus.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Crasse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double cost;
    private String description;
    private double popDown;
    private int missTurn;
    private String picture;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Circus circus;

    public Crasse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPopDown() {
        return popDown;
    }

    public void setPopDown(double popDown) {
        this.popDown = popDown;
    }

    public int getMissTurn() {
        return missTurn;
    }

    public void setMissTurn(int missTurn) {
        this.missTurn = missTurn;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Circus getCircus() {
        return circus;
    }

    public void setCircus(Circus circus) {
        this.circus = circus;
    }
}
