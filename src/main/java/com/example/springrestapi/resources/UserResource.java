package com.example.springrestapi.resources;

import com.example.springrestapi.models.User;
import com.example.springrestapi.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    private UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable("id") int id) {
        return userService.getUser(id);
    }

    @PostMapping("/addUser")
    public int addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
