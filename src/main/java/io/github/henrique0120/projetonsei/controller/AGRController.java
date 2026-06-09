package io.github.henrique0120.projetonsei.controller;

import io.github.henrique0120.projetonsei.model.AGR;
import io.github.henrique0120.projetonsei.service.AGRService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/AGR")
@RequiredArgsConstructor
public class AGRController {

    private final AGRService service;

    @PostMapping("/register")
    public ResponseEntity<Object> registerAGR(@RequestBody AGR agr){
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
