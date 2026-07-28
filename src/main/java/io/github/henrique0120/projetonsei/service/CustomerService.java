package io.github.henrique0120.projetonsei.service;

import io.github.henrique0120.projetonsei.components.CustomerValidator;
import io.github.henrique0120.projetonsei.model.AGR;
import io.github.henrique0120.projetonsei.model.Customer;
import io.github.henrique0120.projetonsei.repository.AGRRepository;
import io.github.henrique0120.projetonsei.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final AGRRepository AGRrepository;
    private final CustomerValidator validator;

    public void registerCustomer(Customer customer){
        validator.validateCustomer(customer);
        validator.validateEmail(customer);
        customerRepository.save(customer);
    }

    public void updateCustomer(UUID id, UUID agrId, Customer customer) {
        AGR agr = AGRrepository.getReferenceById(agrId);
        customer.setAgr(agr);
        customer.setId(id);
        customerRepository.save(customer);
    }

    public void deleteCustomer(UUID id){
        customerRepository.deleteById(id);
    }
}
