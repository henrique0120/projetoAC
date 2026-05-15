package io.github.henrique0120.projetonsei.controller;

import io.github.henrique0120.projetonsei.model.AGR;
import io.github.henrique0120.projetonsei.service.AGRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/AGR")
public class AGRController {

    private final AGRService service;

    public AGRController(AGRService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public AGR registerAGR(@RequestBody AGR agr){
        service.registerAGR(agr);
        return agr;
    }

    @PutMapping("/update/{Id}")
    public void updateAGR(@PathVariable("Id") UUID Id, @RequestBody AGR agr){
        service.updateAGR(Id, agr);
    }

    @DeleteMapping("/delete/{Id}")
    public void deleteAGR(@PathVariable("Id") UUID Id){
        service.deleteAGR(Id);
    }

}
