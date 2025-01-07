package com.example.springrestapi.services;

import com.example.springrestapi.exceptions.NotFoudException;
import com.example.springrestapi.models.User;
import com.example.springrestapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    MessageSource messageSource;

    @Autowired
    UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(Integer id) {
        Optional<User> users = userRepository.findById(id);
        Locale locale = LocaleContextHolder.getLocale();
        if(users.isEmpty()) {
            throw new NotFoudException(messageSource.getMessage("user.not.found", null, "User with id not found", locale) + id);
        }
      return users.get();
    }

    public ResponseEntity addUser(User user) {
        user = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/getUser/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    public ResponseEntity deleteUser(Integer id) {
        userRepository.readUsersById(id);
        return ResponseEntity.ok().build();
    }
}