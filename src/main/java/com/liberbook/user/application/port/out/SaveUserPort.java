package com.liberbook.user.application.port.out;

import com.liberbook.user.domain.model.User;

/** Porta de saída: o que a aplicação precisa do mundo de fora (ex: persistência). */
public interface SaveUserPort {
    User save(User user);
}
