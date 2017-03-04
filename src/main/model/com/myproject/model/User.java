package com.myproject.model;

import java.util.Date;

/**
 * Created by uyutthy on 2/9/2017.
 */
public class User {

    private int id;
    private String email;
    private String password;
    private Date createdDate;
    private String urlPhoto;

    public User(int id, String email, String password, Date createdDate, String urlPhoto){
        this.id = id;
        this.email = email;
        this.password = password;
        this.createdDate = createdDate;
        this.urlPhoto = urlPhoto;
    }

    public User(){}

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }


}
