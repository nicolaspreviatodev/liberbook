package com.liberbook.user.adapter.in.web;

import com.liberbook.user.adapter.in.web.dto.RegisterUserRequest;
import com.liberbook.user.adapter.in.web.dto.UserResponse;
import com.liberbook.user.application.port.in.RegisterUserUseCase;
import com.liberbook.user.domain.model.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final RegisterUserUseCase registerUserUseCase;

    public UserController(RegisterUserUseCase registerUserUseCase) {
        this.registerUserUseCase = registerUserUseCase;
    }

    @PostMapping
    public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterUserRequest request) {
        User user = registerUserUseCase.register(request.name(), request.email());
        return ResponseEntity.ok(UserResponse.from(user));
    }
}
