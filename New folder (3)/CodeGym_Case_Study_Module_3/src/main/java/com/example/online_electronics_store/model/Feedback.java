package com.example.online_electronics_store.model;

import java.time.LocalDateTime;

public class Feedback {
    private User user;
    private Product product;
    private Integer rate;
    private String comment;
    private LocalDateTime date;

    public Feedback() {
    }

    public Feedback(User user, Product product, String comment, LocalDateTime date) {
        this.user = user;
        this.product = product;
        this.comment = comment;
        this.date = date;
    }

    public Feedback(User user, Product product, Integer rate, String comment, LocalDateTime date) {
        this.user = user;
        this.product = product;
        this.rate = rate;
        this.comment = comment;
        this.date = date;
    }

    public Feedback(User user, Product product, Integer rate, LocalDateTime date) {
        this.user = user;
        this.product = product;
        this.rate = rate;
        this.date = date;
    }

    public Feedback(User user, Product product) {
        this.user = user;
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
