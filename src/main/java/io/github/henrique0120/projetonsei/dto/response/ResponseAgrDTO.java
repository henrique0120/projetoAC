package io.github.henrique0120.projetonsei.dto.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import java.util.UUID;

public record ResponseAgrDTO(
        UUID id,
        @CPF
        @NotBlank(message = "O campo CPF não pode ficar vazio!")
        String cpf,
        @NotBlank(message = "O campo Nome não pode ficar vazio!")
        String name,
        @Email
        @NotBlank(message = "O campo Email não pode ficar vazio!")
        String email
){}
