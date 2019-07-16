package com.pompidup.WildWarCircus.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Circus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String picture;
    private Double price;
    private Double capacity;
    private Integer nbShow;
    private Integer nbStand;
    private Integer level;
    private Double cost;

    @OneToOne(mappedBy = "circus")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "circus", cascade = CascadeType.ALL)
    private List<Shoow> shoows;

    @OneToMany(mappedBy = "circus", cascade = CascadeType.ALL)
    private List<Stand> stands;

    @OneToMany(mappedBy = "circus", cascade = CascadeType.ALL)
    private List<Pub> pubs;

    @OneToMany(mappedBy = "circus", cascade = CascadeType.ALL)
    private List<Crasse> crasses;

    public Circus() {
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public Integer getNbShow() {
        return nbShow;
    }

    public void setNbShow(Integer nbShow) {
        this.nbShow = nbShow;
    }

    public Integer getNbStand() {
        return nbStand;
    }

    public void setNbStand(Integer nbStand) {
        this.nbStand = nbStand;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Shoow> getShoows() {
        return shoows;
    }

    public void setShoows(List<Shoow> shoows) {
        this.shoows = shoows;
    }

    public List<Stand> getStands() {
        return stands;
    }

    public void setStands(List<Stand> stands) {
        this.stands = stands;
    }

    public List<Pub> getPubs() {
        return pubs;
    }

    public void setPubs(List<Pub> pubs) {
        this.pubs = pubs;
    }

    public List<Crasse> getCrasses() {
        return crasses;
    }

    public void setCrasses(List<Crasse> crasses) {
        this.crasses = crasses;
    }
}
