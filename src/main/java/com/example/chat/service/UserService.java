package com.example.chat.service;

import com.example.chat.model.Role;
import com.example.chat.model.User;
import com.example.chat.model.UserDto;
import com.example.chat.repository.RoleRepository;
import com.example.chat.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static com.example.chat.model.ERole.ADMIN;
import static com.example.chat.model.ERole.NORMAL;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(UserDto userDto) {
        String hashPassword = passwordEncoder.encode(userDto.getPassword());
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setPassword(hashPassword);
        user.setEmail(userDto.getEmail());

        //test
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(NORMAL));
        roles.add(new Role(ADMIN));
        roleRepository.saveAll(roles);
        user.setRoles(roles);

        return userRepository.save(user);
    }
}
