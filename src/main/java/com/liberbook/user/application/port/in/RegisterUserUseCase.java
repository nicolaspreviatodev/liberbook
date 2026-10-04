package com.liberbook.user.application.port.in;

import com.liberbook.user.domain.model.User;

/** Porta de entrada: o que o mundo de fora (ex: o controller) pode pedir a este módulo. */
public interface RegisterUserUseCase {
    User register(String name, String email);
}
