package com.example.online_electronics_store.model;

import java.time.LocalDateTime;

public class Order {
    private Long id;
    private User user;
    private LocalDateTime date;

    public Order() {
    }

    public Order(Long id, User user, LocalDateTime date) {
        this.id = id;
        this.user = user;
        this.date = date;
    }

    public Order(Long id, User user) {
        this.id = id;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
