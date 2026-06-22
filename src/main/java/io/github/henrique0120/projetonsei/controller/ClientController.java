package io.github.henrique0120.projetonsei.controller;

import io.github.henrique0120.projetonsei.dto.request.RequestClientDTO;
import io.github.henrique0120.projetonsei.dto.response.ResponseClientDTO;
import io.github.henrique0120.projetonsei.mapper.ClientMapper;
import io.github.henrique0120.projetonsei.model.Client;
import io.github.henrique0120.projetonsei.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;
    private final ClientMapper mapper;

    @PostMapping
    public ResponseEntity<Void> registerClient(@RequestBody @Valid RequestClientDTO dto){
        Client cliente = mapper.toEntity(dto);
        service.registerClient(cliente);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    public void updateClient(@PathVariable UUID id,
                             @RequestBody Client client,
                             @RequestParam UUID agrId) {
        service.updateClient(id, agrId, client);
    }

    @DeleteMapping("{id}")
    public void deleteClient(@PathVariable("id") UUID id){
        service.deleteClient(id);
    }
}
