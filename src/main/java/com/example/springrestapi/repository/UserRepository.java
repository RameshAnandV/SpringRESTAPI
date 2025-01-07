package com.example.springrestapi.repository;

import com.example.springrestapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> getUserById(int id);

    List<User> readUsersById(int id);
}
