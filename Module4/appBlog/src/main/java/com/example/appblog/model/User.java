package com.example.appblog.model;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String img;

    @ManyToOne
    private Blog blog;

    public User() {
    }

    public User(Long id, String name, String img) {
        this.id = id;
        this.name = name;
        this.img = img;
    }

    public User(String name, String img, Blog blog) {
        this.name = name;
        this.img = img;
        this.blog = blog;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
