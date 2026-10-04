package com.liberbook.user.domain.model;

import java.util.Objects;
import java.util.regex.Pattern;

public final class Email {

    private static final Pattern PATTERN = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");

    private final String value;

    private Email(String value) {
        this.value = value;
    }

    public static Email of(String raw) {
        Objects.requireNonNull(raw, "email é obrigatório");
        if (!PATTERN.matcher(raw).matches()) {
            throw new IllegalArgumentException("Email inválido: " + raw);
        }
        return new Email(raw.toLowerCase());
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Email other && other.value.equals(value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value;
    }
}
