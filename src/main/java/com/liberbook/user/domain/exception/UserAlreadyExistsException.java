package com.liberbook.user.domain.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String email) {
        super("Já existe um usuário com o email: " + email);
    }
}
