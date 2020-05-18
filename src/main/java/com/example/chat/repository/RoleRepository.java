package com.example.chat.repository;

import com.example.chat.model.ERole;
import com.example.chat.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findRoleByRoleTypeName(ERole eRole);
}
