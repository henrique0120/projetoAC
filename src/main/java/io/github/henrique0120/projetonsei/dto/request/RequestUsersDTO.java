package io.github.henrique0120.projetonsei.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record RequestUsersDTO(

        @NotBlank(message = "O campo login não pode ficar vazio!")
        String login,
        @NotBlank(message = "O campo password não pode ficar vazio!")
        String password,
        @NotBlank(message = "O campo email não pode ficar vazio!")
        String email,
        @NotNull
        List<String>roles
) {}
