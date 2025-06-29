package com.gre.gre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gre.gre.model.User;
import com.gre.gre.service.UserService;
@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping public List<User> getAll() { return userService.getAllUsers(); }
    @PostMapping public User create(@RequestBody User user) { return userService.createUser(user); }
    @GetMapping("/{id}") public User get(@PathVariable Long id) { return userService.getUser(id); }
    @PutMapping("/{id}") public User update(@PathVariable Long id, @RequestBody User user) { return userService.updateUser(id, user); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { userService.deleteUser(id); }
}

