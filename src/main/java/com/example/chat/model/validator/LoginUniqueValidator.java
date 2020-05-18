package com.example.chat.model.validator;

import com.example.chat.model.UserDto;
import com.example.chat.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LoginUniqueValidator implements ConstraintValidator<ValidLoginUnique, UserDto> {
    private final UserRepository userRepository;

    public LoginUniqueValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(UserDto user, ConstraintValidatorContext constraintValidatorContext) {
        return !userRepository.existsByLogin(user.getLogin());
    }
}
