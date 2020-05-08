package com.example.chat.controller;

import com.example.chat.model.UserDto;
import com.example.chat.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public void registerUserAccount(@Valid UserDto userDto){
        userService.registerUser(userDto);
    }
}
