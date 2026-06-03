package io.github.henrique0120.projetonsei.dto;

import io.github.henrique0120.projetonsei.model.AGR;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record AGRDTO(
        @NotBlank(message = "O campo CPF não pode ficar vazio!")
        @Size(min = 2, max = 11, message = "Campo fora do tamanho padrão")
        @CPF(message = "Digite um CPF válido")
        String cpf,
        @NotBlank(message = "O campo Nome não pode ficar vazio!")
        @Size(min = 2, max = 50, message = "Campo fora do tamanho padrão")
        String name,
        @NotBlank(message = "O campo Email não pode ficar vazio!")
        @Size(min = 2, max = 50, message = "Campo fora do tamanho padrão")
        @Email(message = "Email inválido")
        String email
){
    public AGR mapearParaAgr(){
        AGR agr = new AGR();
        agr.setCpf(this.cpf());
        agr.setName(this.name());
        agr.setEmail(this.email());
        return agr;
    }
}
