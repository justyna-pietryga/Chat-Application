package com.example.chat.controller;

import com.example.chat.model.UserDto;
import com.example.chat.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public void registerUserAccount(@Validated @RequestBody UserDto userDto){
        System.out.println("here");
        userService.registerUser(userDto);
    }
}
