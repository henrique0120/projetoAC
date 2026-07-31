package io.github.henrique0120.projetonsei.controller;

import io.github.henrique0120.projetonsei.dto.request.RequestClientDTO;
import io.github.henrique0120.projetonsei.mapper.ClientMapper;
import io.github.henrique0120.projetonsei.model.Client;
import io.github.henrique0120.projetonsei.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;
    private final ClientMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)

    @PreAuthorize("hasRole('SUPORTE')")
    public void salvar (@RequestBody RequestClientDTO clientDto){
        var sla = mapper.toEntity(clientDto);
        service.salvar(sla);
    }

}
