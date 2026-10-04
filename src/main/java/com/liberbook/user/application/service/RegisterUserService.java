package com.liberbook.user.application.service;

import com.liberbook.user.application.port.in.RegisterUserUseCase;
import com.liberbook.user.application.port.out.LoadUserPort;
import com.liberbook.user.application.port.out.SaveUserPort;
import com.liberbook.user.domain.exception.UserAlreadyExistsException;
import com.liberbook.user.domain.model.Email;
import com.liberbook.user.domain.model.User;
import org.springframework.stereotype.Service;

/** Implementa o caso de uso. É aqui, na camada "application", que o Spring entra em cena. */
@Service
public class RegisterUserService implements RegisterUserUseCase {

    private final SaveUserPort saveUserPort;
    private final LoadUserPort loadUserPort;

    public RegisterUserService(SaveUserPort saveUserPort, LoadUserPort loadUserPort) {
        this.saveUserPort = saveUserPort;
        this.loadUserPort = loadUserPort;
    }

    @Override
    public User register(String name, String emailRaw) {
        Email email = Email.of(emailRaw);
        loadUserPort.findByEmail(email).ifPresent(u -> {
            throw new UserAlreadyExistsException(email.value());
        });
        User user = User.register(name, email);
        return saveUserPort.save(user);
    }
}
