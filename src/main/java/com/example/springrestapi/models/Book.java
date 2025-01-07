package com.example.springrestapi.models;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String author;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Book() {
    }

    public Book(Integer id, String title, String author, User user) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
