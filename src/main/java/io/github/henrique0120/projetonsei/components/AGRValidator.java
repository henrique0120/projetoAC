package io.github.henrique0120.projetonsei.components;

import io.github.henrique0120.projetonsei.dto.ErroResposta;
import io.github.henrique0120.projetonsei.exception.CPFExistenteException;
import io.github.henrique0120.projetonsei.exception.EmailExistenteException;
import io.github.henrique0120.projetonsei.model.AGR;
import io.github.henrique0120.projetonsei.repository.AGRRepository;
import org.springframework.stereotype.Component;

@Component
public class AGRValidator {
    private final AGRRepository repository;

    public AGRValidator(AGRRepository repository) {
        this.repository = repository;
    }

    public void validateAGR(AGR agr){
        if(existsBycpf(agr.getCpf())){
            throw new CPFExistenteException("Já existe um(a) AGR cadastrado(a) com esse CPF!");
        }
    }

    public void validateEmail(AGR agr){
        if(existsByemail(agr.getEmail())){
            throw new EmailExistenteException("Já existe uma AGR cadastrada com esse Email!");
        }
    }

    public boolean existsBycpf(String cpf){
        return repository.existsBycpf(cpf);
    }

    public boolean existsByemail(String email){
        return repository.existsByemail(email);
    }
}
