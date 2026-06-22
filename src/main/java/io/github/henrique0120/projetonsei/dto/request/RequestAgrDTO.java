package io.github.henrique0120.projetonsei.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public record RequestAgrDTO(

        @CPF
        @NotBlank(message = "O campo CPF não pode ficar vazio!")
        String cpf,
        @NotBlank(message = "O campo Nome não pode ficar vazio!")
        String name,
        @Email
        @NotBlank(message = "O campo Email não pode ficar vazio!")
        String email
){}
