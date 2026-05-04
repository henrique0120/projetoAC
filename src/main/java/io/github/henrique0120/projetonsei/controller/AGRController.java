package io.github.henrique0120.projetonsei.controller;

import io.github.henrique0120.projetonsei.model.AGR;
import io.github.henrique0120.projetonsei.service.AGRService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class AGRController {
    private final AGRService service;

    public AGRController(AGRService service) {
        this.service = service;
    }

    @PostMapping
    public AGR registerAGR(@RequestBody AGR agr){
        service.registerAGR(agr);
        return agr;
    }

}
