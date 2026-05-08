package io.github.henrique0120.projetonsei.components;

import io.github.henrique0120.projetonsei.model.AGR;
import io.github.henrique0120.projetonsei.model.Client;
import io.github.henrique0120.projetonsei.repository.ClientRepository;
import org.springframework.stereotype.Component;

@Component
public class ClientValidator {

    private final ClientRepository repository;

    public ClientValidator(ClientRepository repository) {
        this.repository = repository;
    }

    public void validateClient(Client client){
        if(existsBycpf(client.getCpf())){
            throw new IllegalArgumentException("Já existe um(a) cliente cadastrado(a) com esse CPF!");
        }
    }

    public void validateEmail(Client client){
        if(existsByemail(client.getEmail())){
            throw new IllegalArgumentException("Já existe um(a) cliente cadastrado(a) com esse Email!");
        }
    }

    public boolean existsBycpf(String cpf){
        return repository.existsBycpf(cpf);
    }

    public boolean existsByemail(String email){
        return repository.existsByemail(email);
    }


}
