package com.example.springrestapi.models;

import com.fasterxml.jackson.annotation.*;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"department"})
@JsonFilter("GradeFilter")
public class User {

    int id;
    @JsonProperty("UserName")
    String name;

    @JsonProperty("BirthDate")
    LocalDate birthDate;
    String department;

    @JsonIgnore
    String password;

    int grade;

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public User(int id, String name, LocalDate birthDate, String department, String password, int grade) {
        this.name = name;
        this.id = id;
        this.birthDate = birthDate;
        this.password = password;
        this.department = department;
        this.grade = grade;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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
