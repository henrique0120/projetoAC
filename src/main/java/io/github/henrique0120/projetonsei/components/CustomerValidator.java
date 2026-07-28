package io.github.henrique0120.projetonsei.components;

import io.github.henrique0120.projetonsei.model.Customer;
import io.github.henrique0120.projetonsei.repository.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class CustomerValidator {

    private final CustomerRepository repository;

    public CustomerValidator(CustomerRepository repository) {
        this.repository = repository;
    }

    public void validateCustomer(Customer customer){
        if(existsBycpf(customer.getCpf())){
            throw new IllegalArgumentException("Já existe um(a) cliente cadastrado(a) com esse CPF!");
        }
    }

    public void validateEmail(Customer customer){
        if(existsByemail(customer.getEmail())){
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
