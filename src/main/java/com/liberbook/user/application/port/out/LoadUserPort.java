package com.liberbook.user.application.port.out;

import com.liberbook.user.domain.model.Email;
import com.liberbook.user.domain.model.User;

import java.util.Optional;

public interface LoadUserPort {
    Optional<User> findByEmail(Email email);
}
