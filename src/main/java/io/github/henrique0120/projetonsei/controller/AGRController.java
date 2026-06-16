package io.github.henrique0120.projetonsei.controller;

import io.github.henrique0120.projetonsei.dto.AGRDTO;
import io.github.henrique0120.projetonsei.mapper.AGRMapper;
import io.github.henrique0120.projetonsei.model.AGR;
import io.github.henrique0120.projetonsei.service.AGRService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/AGR")
@RequiredArgsConstructor
public class AGRController {

    private final AGRService service;
    private final AGRMapper mapper;

    @PostMapping("/register")
    public ResponseEntity<Object> registerAGR(@RequestBody @Valid AGRDTO dto){
        AGR agr = mapper.toEntity(dto);
        service.registerAGR(agr);
        return ResponseEntity.status(204).build();
    }

    @PutMapping("/update/{Id}")
    public void updateAGR(@PathVariable("id") UUID id, @RequestBody AGR agr){
        service.updateAGR(id, agr);
    }

    @DeleteMapping("/delete/{Id}")
    public void deleteAGR(@PathVariable("id") UUID id){
        service.deleteAGR(id);
    }

}
