package com.pompidup.WildWarCircus.entities;


public class UserDTO {

    private String username;
    private String password;
    private String picture;
    private Boolean bot;
    private Double money;
    private Long circusId;

    public UserDTO() {
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Boolean isBot() {
        return bot;
    }

    public void setBot(Boolean bot) {
        this.bot = bot;
    }

    public Long getCircusId() {
        return circusId;
    }

    public void setCircusId(Long circusId) {
        this.circusId = circusId;
    }
}
