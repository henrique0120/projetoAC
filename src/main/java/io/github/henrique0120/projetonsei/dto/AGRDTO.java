package io.github.henrique0120.projetonsei.dto;

import io.github.henrique0120.projetonsei.model.AGR;
import jakarta.validation.constraints.NotBlank;

public record AGRDTO(
        @NotBlank(message = "O campo CPF não pode ficar vazio!")
        String cpf,
        String name,
        String email
){}
