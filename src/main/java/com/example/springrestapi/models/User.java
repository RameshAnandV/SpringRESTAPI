package com.example.springrestapi.models;

import java.time.LocalDate;
import java.util.Date;

public class User {
    int id;
    String name;
    LocalDate birtDate;


    public User(int id, String name, LocalDate birtDate) {
        this.name = name;
        this.id = id;
        this.birtDate = birtDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirtDate() {
        return birtDate;
    }

    public void setBirtDate(LocalDate birtDate) {
        this.birtDate = birtDate;
    }
}
