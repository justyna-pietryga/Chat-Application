package com.example.chat.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private ERole name;

    public Role(ERole eRole) {
        this.name = eRole;
    }

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
