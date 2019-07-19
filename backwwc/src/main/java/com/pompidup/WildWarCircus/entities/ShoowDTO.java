package com.pompidup.WildWarCircus.entities;

public class ShoowDTO {


    private String name;
    private Double cost;
    private String type;
    private Double maintenance;
    private Double popUp;
    private String description;
    private String picture;
    private Long circusId;

    public ShoowDTO() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(Double maintenance) {
        this.maintenance = maintenance;
    }

    public Double getPopUp() {
        return popUp;
    }

    public void setPopUp(Double popUp) {
        this.popUp = popUp;
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
