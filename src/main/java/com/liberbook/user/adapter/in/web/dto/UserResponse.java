package com.liberbook.user.adapter.in.web.dto;

import com.liberbook.user.domain.model.User;

import java.time.Instant;

public record UserResponse(String id, String name, String email, Instant createdAt) {
    public static UserResponse from(User user) {
        return new UserResponse(
                user.getId().toString(),
                user.getName(),
                user.getEmail().value(),
                user.getCreatedAt()
        );
    }
}
