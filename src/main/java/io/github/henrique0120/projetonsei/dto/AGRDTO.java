package io.github.henrique0120.projetonsei.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public record AGRDTO(
        @NotBlank(message = "O campo CPF não pode ficar vazio!")
        @CPF
        String cpf,
        @NotBlank(message = "O campo Nome não pode ficar vazio!")
        String name,
        @NotBlank(message = "O campo Email não pode ficar vazio!")
        @Email
        String email
){}
