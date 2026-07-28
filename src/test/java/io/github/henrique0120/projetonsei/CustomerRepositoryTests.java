package io.github.henrique0120.projetonsei;

import io.github.henrique0120.projetonsei.model.AGR;
import io.github.henrique0120.projetonsei.model.Customer;
import io.github.henrique0120.projetonsei.repository.AGRRepository;
import io.github.henrique0120.projetonsei.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
public class CustomerRepositoryTests {

    @Autowired
    CustomerRepository repository;

    @Autowired
    AGRRepository agrRepository;

    @Test
    void registerClient(){
        Customer customer = new Customer();
        customer.setName("Joao");
        customer.setCpf("9485432109");
        customer.setEmail("Joao@email.com");

        AGR agr = agrRepository
                .findById(UUID.fromString("e24d4c49-7091-4179-af16-27895384fdc3"))
                .orElse(null);

        customer.setAgr(agr);
        repository.save(customer);
    }


    @Test
    void listarAGRs(){
        List<AGR> agrs = repository.listarAGRsDosCustomers();
        agrs.forEach(System.out::println);
    }

    @Test
    void listarNomesDosClients(){
        List<Customer> names = repository.listarNomesDosCustomers();
        names.forEach(System.out::println);
    }
}
