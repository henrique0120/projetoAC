package io.github.henrique0120.projetonsei.controller;

import io.github.henrique0120.projetonsei.model.Client;
import io.github.henrique0120.projetonsei.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @PostMapping
    public Client registerClient(@RequestBody Client client, @RequestParam int agrId){
        return service.registerClient(client, agrId);
    }

}
