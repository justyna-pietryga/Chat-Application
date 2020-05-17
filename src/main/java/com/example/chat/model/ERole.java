package com.example.chat.model;

import lombok.Getter;

@Getter
public enum ERole {
    NORMAL_USER,
    MODERATOR,
    ADMIN_USER,
    BLOCKED
}
