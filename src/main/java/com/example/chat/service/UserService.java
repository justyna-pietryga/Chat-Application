package com.example.chat.service;

import com.example.chat.model.Role;
import com.example.chat.model.User;
import com.example.chat.model.UserDto;
import com.example.chat.repository.RoleRepository;
import com.example.chat.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static com.example.chat.model.ERole.ADMIN;
import static com.example.chat.model.ERole.NORMAL;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User registerUser(UserDto userDto) {
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
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
