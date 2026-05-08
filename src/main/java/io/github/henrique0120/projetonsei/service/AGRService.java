package io.github.henrique0120.projetonsei.service;

import io.github.henrique0120.projetonsei.components.AGRValidator;
import io.github.henrique0120.projetonsei.model.AGR;
import io.github.henrique0120.projetonsei.repository.AGRRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AGRService {

    private final AGRRepository repository;
    private final AGRValidator validator;

    public AGRService(AGRRepository repository, AGRValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    public AGR registerAGR(AGR agr){
        validator.validateAGR(agr);
        validator.validateEmail(agr);
        return repository.save(agr);
    }

    public void updateAGR(@PathVariable("Id") int Id, @RequestBody AGR agr){
        agr.setId(Id);
        repository.save(agr);
    }

    public void deleteAGR(@PathVariable("Id") int Id){
        repository.deleteById(Id);
    }

}
