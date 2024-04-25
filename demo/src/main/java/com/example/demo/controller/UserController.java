package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return repository.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable long id) {
        return repository.findById(id);
    }

    // @SuppressWarnings("null")
    @PostMapping("/users")
    public User postUser(@RequestBody User user) {
        return repository.save(user);
    }

    @DeleteMapping(value = "/users/{id}")
    public boolean deleteUser(@PathVariable long id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    // @GetMapping("/users/title/{title}")
    // public List<User> getUserByTitle(@PathVariable String title) {
    // return repository.findByTitle(title);
    // }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") long id, @RequestBody User newUser) {
        Optional<User> oldUser = repository.findById(id);
        if (oldUser.isPresent()) {
            User user = oldUser.get();
            user.setUsername(newUser.getUsername());
            user.setName(newUser.getName());
            user.setEmail(newUser.getEmail());
            user.setPassword(newUser.getPassword());
            user.setComments(newUser.getComments());
            user.setEvaluations(newUser.getEvaluations());
            user.setComments(newUser.getComments());
            user.setEvaluations(newUser.getEvaluations());
            repository.save(user);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}