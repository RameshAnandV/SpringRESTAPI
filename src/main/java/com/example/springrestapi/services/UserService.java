package com.example.springrestapi.services;

import com.example.springrestapi.exceptions.UserNotFoudException;
import com.example.springrestapi.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static List<User> users = new ArrayList<>();
    private static Integer count = 0;

    static {
        users.add(new User(++count, "user1", LocalDate.now().minusYears(20).minusMonths(2).minusDays(3)));
        users.add(new User(++count, "user2", LocalDate.now().minusYears(30).minusMonths(3).minusDays(5)));
        users.add(new User(++count, "user3", LocalDate.now().minusYears(22).minusMonths(6).minusDays(4)));
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUser(Integer id) {
        for (User user : users) {
            if(user.getId() == id) {
                return user;
            }
        }
        throw new UserNotFoudException("User with id not found: " + id);
    }

    public ResponseEntity addUser(User user) {
        int id = ++count;
        user.setId(id);
        users.add(user);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/getUser/{id}").buildAndExpand(id ).toUri();
        return ResponseEntity.created(location).build();
    }

    public ResponseEntity deleteUser(Integer id) {
        for (User user : users) {
            if(user.getId() == id) {
               users.remove(user);
            }
        }
        return ResponseEntity.ok().build();
    }
}
