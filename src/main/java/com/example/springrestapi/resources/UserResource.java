package com.example.springrestapi.resources;

import com.example.springrestapi.models.User;
import com.example.springrestapi.services.UserService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    private UserService userService;
    private MessageSource messageSource;

    public UserResource(UserService userService, MessageSource messageSource) {
        this.userService = userService;
        this.messageSource = messageSource;
    }

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable("id") int id) {
        return userService.getUser(id);
    }

    @GetMapping("/v2/getUser/{id}")
    public User getUserByIdV2(@PathVariable("id") int id) {
        User user = userService.getUser(id);
        return user;
    }

    @GetMapping(value = "/getUser/{id}", params = "version=1")
    public User getUserByIdVersion1(@PathVariable("id") int id) {
        User user = userService.getUser(id);
        return user;
    }

    @GetMapping(value = "/getUser/{id}", params = "version=2")
    public User getUserByIdVersion2(@PathVariable("id") int id) {
        User user = userService.getUser(id);
        return user;
    }

    @GetMapping(value = "v3/getUser/{id}")
    public MappingJacksonValue getUserByIdVersion3(@PathVariable("id") int id) {
        User user = userService.getUser(id);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(user);
        SimpleBeanPropertyFilter GradeFilter = SimpleBeanPropertyFilter.filterOutAllExcept("UserName", "id", "BirthDate");
        FilterProvider filter = new SimpleFilterProvider().addFilter("GradeFilter", GradeFilter);
        mappingJacksonValue.setFilters(filter);
        return mappingJacksonValue;
    }

    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity deleteUserById(@PathVariable("id") int id) {
        return userService.deleteUser(id);
    }
}
