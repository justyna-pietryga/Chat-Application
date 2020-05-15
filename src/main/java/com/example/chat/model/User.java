package com.example.chat.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "APP_USER", uniqueConstraints = {@UniqueConstraint(columnNames = "login"), @UniqueConstraint(columnNames = "email")})
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String login;

    @NotBlank
    @Size(max = 60)
    private String password;

    @NotBlank
    @Size(max = 50)
    private String email;

    @ManyToMany(fetch = LAZY)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }
}
