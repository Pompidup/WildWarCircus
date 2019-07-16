package com.pompidup.WildWarCircus.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Stand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double gain;
    private double cost;
    private double maintenance;
    private float convertion;
    private String description;
    private String picture;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Circus circus;

    public Stand() {
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

    public double getGain() {
        return gain;
    }

    public void setGain(double gain) {
        this.gain = gain;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(double maintenance) {
        this.maintenance = maintenance;
    }

    public float getConvertion() {
        return convertion;
    }

    public void setConvertion(float convertion) {
        this.convertion = convertion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
