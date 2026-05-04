package io.github.henrique0120.projetonsei.controller;

import io.github.henrique0120.projetonsei.model.Client;
import io.github.henrique0120.projetonsei.service.ClientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    private Client registerClient(@RequestBody Client client){
        service.registerClient(client);
        return client;
    }

}
