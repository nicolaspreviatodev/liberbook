package com.liberbook.user.domain.model;

import java.time.Instant;
import java.util.Objects;

/**
 * Entidade de domínio pura — sem anotações de Spring ou JPA.
 * Regras de negócio do usuário, independentes de infraestrutura.
 */
public class User {

    private final UserId id;
    private final String name;
    private final Email email;
    private final Instant createdAt;

    private User(UserId id, String name, Email email, Instant createdAt) {
        this.id = id;
        this.name = Objects.requireNonNull(name, "name é obrigatório");
        this.email = Objects.requireNonNull(email, "email é obrigatório");
        this.createdAt = createdAt;
    }

    /** Criação de um novo usuário (caso de uso de cadastro). */
    public static User register(String name, Email email) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        return new User(UserId.newId(), name, email, Instant.now());
    }

    /** Reconstrução a partir de dados já persistidos (usado pelo adapter de persistência). */
    public static User reconstruct(UserId id, String name, Email email, Instant createdAt) {
        return new User(id, name, email, createdAt);
    }

    public UserId getId() { return id; }
    public String getName() { return name; }
    public Email getEmail() { return email; }
    public Instant getCreatedAt() { return createdAt; }
}
