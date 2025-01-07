package com.example.springrestapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"department"})
@Entity(name="userdetails")
public class User {

    @Id
    Integer  id;

    @JsonProperty("UserName")
    String name;

    @JsonProperty("BirthDate")
    LocalDate birthDate;

    @JsonIgnore
    String password;

    @OneToMany(mappedBy = "user")
    private List<Book> books;

    public User() {
    }

    public User(int id, String name, LocalDate birthDate, String password) {
        this.name = name;
        this.id = id;
        this.birthDate = birthDate;
        this.password = password;
    }

    public User(int id, String name, LocalDate birthDate) {
        this.name = name;
        this.id = id;
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
