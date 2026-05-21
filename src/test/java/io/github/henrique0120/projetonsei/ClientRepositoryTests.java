package io.github.henrique0120.projetonsei;

import io.github.henrique0120.projetonsei.model.AGR;
import io.github.henrique0120.projetonsei.model.Client;
import io.github.henrique0120.projetonsei.repository.AGRRepository;
import io.github.henrique0120.projetonsei.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class ClientRepositoryTests {

    @Autowired
    ClientRepository repository;

    @Autowired
    AGRRepository agrRepository;

    @Test
    void registerClient(){
        Client client = new Client();
        client.setName("Joao");
        client.setCpf("9485432109");
        client.setEmail("Joao@email.com");

        AGR agr = agrRepository
                .findById(UUID.fromString("e24d4c49-7091-4179-af16-27895384fdc3"))
                .orElse(null);

        client.setAgr(agr);
        repository.save(client);
    }


    @Test
    void listarAGRs(){
        List<AGR> agrs = repository.listarAGRsDosClients();
        agrs.forEach(System.out::println);
    }

    @Test
    void listarNomesDosClients(){
        List<Client> names = repository.listarNomesDosClients();
        names.forEach(System.out::println);
    }
}
