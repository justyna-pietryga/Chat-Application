package com.example.chat.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = {"users"})
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name="role_type_name")
    private ERole roleTypeName;

    public Role() {}

    public Role(ERole roleTypeName) {
        this.roleTypeName = roleTypeName;
    }

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
