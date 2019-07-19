package com.pompidup.WildWarCircus.entities;

public class StandDTO {

    private String name;
    private Double gain;
    private Double cost;
    private Double maintenance;
    private Float convertion;
    private String description;
    private String picture;
    private Long circusId;

    public StandDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGain() {
        return gain;
    }

    public void setGain(Double gain) {
        this.gain = gain;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(Double maintenance) {
        this.maintenance = maintenance;
    }

    public Float getConvertion() {
        return convertion;
    }

    public void setConvertion(Float convertion) {
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

    public Long getCircusId() {
        return circusId;
    }

    public void setCircusId(Long circusId) {
        this.circusId = circusId;
    }
}
