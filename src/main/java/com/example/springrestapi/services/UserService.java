package com.example.springrestapi.services;

import com.example.springrestapi.models.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    private static List<User> users = new ArrayList<>();
    private static Integer count = 0;

    static {
        users.add(new User(++count, "user1", new Date()));
        users.add(new User(++count, "user1", new Date()));
        users.add(new User(++count, "user1", new Date()));
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
        return null;
    }

    public int addUser(User user) {
        users.add(user);
        return ++count;
    }
}
