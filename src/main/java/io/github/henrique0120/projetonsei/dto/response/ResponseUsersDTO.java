package io.github.henrique0120.projetonsei.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record ResponseUsersDTO(

        @NotNull
        UUID id,
        @NotBlank(message = "O campo login não pode ficar vazio!")
        String login,
        @NotBlank(message = "O campo password não pode ficar vazio!")
        String password,
        @NotNull
        List<String> roles


) {}
