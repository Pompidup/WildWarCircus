package com.pompidup.WildWarCircus.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Crasse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double cost;
    private String description;
    private Double popDown;
    private Integer missTurn;
    private String picture;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
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

    public String getDescription() {
        return description;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getPopDown() {
        return popDown;
    }

    public void setPopDown(Double popDown) {
        this.popDown = popDown;
    }

    public Integer getMissTurn() {
        return missTurn;
    }

    public void setMissTurn(Integer missTurn) {
        this.missTurn = missTurn;
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
