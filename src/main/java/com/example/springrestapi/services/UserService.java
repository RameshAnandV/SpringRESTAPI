package com.example.springrestapi.services;

import com.example.springrestapi.models.User;
import org.springframework.stereotype.Service;

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
        return null;
    }

    public int addUser(User user) {
        int id = ++count;
        user.setId(id);
        users.add(user);
        return id;
    }
}
