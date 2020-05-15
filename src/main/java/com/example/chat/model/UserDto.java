package com.example.chat.model;

import com.example.chat.model.validator.PasswordMatches;
import com.example.chat.model.validator.ValidEmail;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Value
@RequiredArgsConstructor
@PasswordMatches
public class UserDto {
    @NotNull
    @NotEmpty
    private String login;

    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;

    @NotNull
    @NotEmpty
    @Email
//    @ValidEmail
    private String email;
}
