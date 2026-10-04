package com.liberbook.user.adapter.out.persistence;

import com.liberbook.user.application.port.out.LoadUserPort;
import com.liberbook.user.application.port.out.SaveUserPort;
import com.liberbook.user.domain.model.Email;
import com.liberbook.user.domain.model.User;
import com.liberbook.user.domain.model.UserId;
import org.springframework.stereotype.Component;

import java.util.Optional;

/** Implementa as duas portas de saída do módulo, traduzindo domínio <-> entidade JPA. */
@Component
public class UserPersistenceAdapter implements SaveUserPort, LoadUserPort {

    private final UserJpaRepository repository;

    public UserPersistenceAdapter(UserJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        UserJpaEntity entity = new UserJpaEntity(
                user.getId().value(), user.getName(), user.getEmail().value(), user.getCreatedAt());
        repository.save(entity);
        return user;
    }

    @Override
    public Optional<User> findByEmail(Email email) {
        return repository.findByEmail(email.value())
                .map(e -> User.reconstruct(
                        UserId.of(e.getId()), e.getName(), Email.of(e.getEmail()), e.getCreatedAt()));
    }
}
