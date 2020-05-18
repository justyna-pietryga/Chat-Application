package com.example.chat.service;

import com.example.chat.model.ERole;
import com.example.chat.model.Role;
import com.example.chat.model.User;
import com.example.chat.model.UserDto;
import com.example.chat.repository.RoleRepository;
import com.example.chat.repository.UserRepository;
import lombok.val;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

import static com.example.chat.model.ERole.ADMIN_USER;
import static com.example.chat.model.ERole.NORMAL_USER;

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

    @Transactional
    public User registerUser(UserDto userDto) {
        String hashPassword = passwordEncoder.encode(userDto.getPassword());

        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setPassword(hashPassword);
        user.setEmail(userDto.getEmail());

        //test
        Set<Role> roles = new HashSet<>();
        roles.add(getRole(NORMAL_USER));
        roles.add(getRole(ADMIN_USER));

        user.setRoles(roles);
        roleRepository.saveAll(roles);

        return userRepository.save(user);
    }

    private Role getRole(ERole eRole) {
        val role = roleRepository.findRoleByRoleTypeName(eRole);
        return role.orElseGet(() -> new Role(eRole));
    }
}
