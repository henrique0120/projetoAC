package io.github.henrique0120.projetonsei.service;

import io.github.henrique0120.projetonsei.components.AGRValidator;
import io.github.henrique0120.projetonsei.model.AGR;
import io.github.henrique0120.projetonsei.repository.AGRRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AGRService {

    private final AGRRepository repository;
    private final AGRValidator validator;

    public AGR registerAGR(AGR agr){
        validator.validateAGR(agr);
        validator.validateEmail(agr);
        return repository.save(agr);
    }

    public void updateAGR(@PathVariable("id") UUID id, @RequestBody AGR agr){
        agr.setId(id);
        repository.save(agr);
    }

    public void deleteAGR(@PathVariable("id") UUID id){
        repository.deleteById(id);
    }

}
