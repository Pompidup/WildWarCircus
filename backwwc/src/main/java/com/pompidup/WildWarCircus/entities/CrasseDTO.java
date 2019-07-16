package com.pompidup.WildWarCircus.entities;

public class CrasseDTO {

    private String name;
    private double cost;
    private String description;
    private double popDown;
    private int missTurn;
    private String picture;
    private Long circusId;

    public CrasseDTO() {
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

    public Long getCircusId() {
        return circusId;
    }

    public void setCircusId(Long circusId) {
        this.circusId = circusId;
    }
}
