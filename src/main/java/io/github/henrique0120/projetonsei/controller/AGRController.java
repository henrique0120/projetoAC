package io.github.henrique0120.projetonsei.controller;

import io.github.henrique0120.projetonsei.dto.request.RequestAgrDTO;
import io.github.henrique0120.projetonsei.mapper.AGRMapper;
import io.github.henrique0120.projetonsei.model.AGR;
import io.github.henrique0120.projetonsei.service.AGRService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/AGR")
@RequiredArgsConstructor
public class AGRController implements GenericController{

    private final AGRService service;
    private final AGRMapper mapper;

    @PostMapping
    @PreAuthorize("hasRole('SUPORTE')")
    public ResponseEntity<Object> registerAGR(@RequestBody @Valid RequestAgrDTO dto){
        AGR agr = mapper.toEntity(dto);
        service.registerAGR(agr);
        URI location = gerarHeaderLocation(agr.getId());
        return ResponseEntity.created(location).body("Registro de AGR feito com sucesso!");
    }

    @PutMapping("{id}")
    public void updateAGR(@PathVariable("id") UUID id, @RequestBody AGR agr){
        service.updateAGR(id, agr);
    }

    @DeleteMapping("{id}")
    public void deleteAGR(@PathVariable("id") UUID id){
        service.deleteAGR(id);
    }

}
