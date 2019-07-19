package com.pompidup.WildWarCircus.entities;

public class CrasseDTO {

    private String name;
    private Double cost;
    private String description;
    private Double popDown;
    private Integer missTurn;
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

    public Long getCircusId() {
        return circusId;
    }

    public void setCircusId(Long circusId) {
        this.circusId = circusId;
    }
}
