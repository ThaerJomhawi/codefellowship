package com.example.codefellowship.model;

import javax.persistence.*;

@Entity
public class PostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String body;
    private String createdAt;
    @ManyToOne
    private UserDataModel applicationUser;




    public PostModel(){

    }

    public PostModel(String body, String createdAt, UserDataModel applicationUser) {
        this.body = body;
        this.createdAt = createdAt;
        this.applicationUser = applicationUser;
    }

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public UserDataModel getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(UserDataModel applicationUser) {
        this.applicationUser = applicationUser;
    }
}
