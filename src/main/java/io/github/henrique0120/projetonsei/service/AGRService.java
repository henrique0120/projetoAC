package io.github.henrique0120.projetonsei.service;

import io.github.henrique0120.projetonsei.components.AGRValidator;
import io.github.henrique0120.projetonsei.model.AGR;
import io.github.henrique0120.projetonsei.repository.AGRRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
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

    public Optional<AGR> findAGR(UUID id){
        return repository.findById(id);
    }

    public void updateAGR(UUID id, AGR agr){
        agr.setId(id);
        repository.save(agr);
    }

    public void deleteAGR(UUID id){
        repository.deleteById(id);
    }

}
