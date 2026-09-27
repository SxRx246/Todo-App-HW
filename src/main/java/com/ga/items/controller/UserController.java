package com.ga.items.controller;

import com.ga.items.model.User;
import com.ga.items.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth/users")
public class UserController {
    private final UserService userService;

@PostMapping("/register")
    public User createUser(@RequestBody User userObject){
    System.out.println("Calling createUser() ==>");
    return userService.createUser(userObject);
}
}
