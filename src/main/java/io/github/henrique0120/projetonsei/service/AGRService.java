package io.github.henrique0120.projetonsei.service;

import io.github.henrique0120.projetonsei.model.AGR;
import io.github.henrique0120.projetonsei.repository.AGRRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AGRService {
    private final AGRRepository repository;

    public AGRService(AGRRepository repository) {
        this.repository = repository;
    }

    public AGR registerAGR(@RequestBody AGR agr){
        repository.save(agr);
        return agr;
    }

}
