package com.liberbook.user.domain.model;

import java.util.Objects;
import java.util.UUID;

public final class UserId {

    private final UUID value;

    private UserId(UUID value) {
        this.value = value;
    }

    public static UserId newId() {
        return new UserId(UUID.randomUUID());
    }

    public static UserId of(UUID value) {
        return new UserId(Objects.requireNonNull(value));
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof UserId other && other.value.equals(value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
