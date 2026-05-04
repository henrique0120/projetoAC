package io.github.henrique0120.projetonsei.service;

import io.github.henrique0120.projetonsei.model.Client;
import io.github.henrique0120.projetonsei.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ClientService {
    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public Client registerClient(@RequestBody Client client){
        repository.save(client);
        return client;
    }

}
