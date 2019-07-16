package com.pompidup.WildWarCircus.entities;


public class UserDTO {

    private String username;
    private String password;
    private String picture;
    private boolean bot;
    private Long circusId;

    public UserDTO() {
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

    public boolean isBot() {
        return bot;
    }

    public void setBot(boolean bot) {
        this.bot = bot;
    }

    public Long getCircusId() {
        return circusId;
    }

    public void setCircusId(Long circusId) {
        this.circusId = circusId;
    }
}
