package io.github.henrique0120.projetonsei.service;

import io.github.henrique0120.projetonsei.model.AGR;
import io.github.henrique0120.projetonsei.repository.AGRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class AGRService {

    @Autowired
    private AGRRepository repository;

    public AGR registerAGR(@RequestBody AGR agr){
        repository.save(agr);
        return agr;
    }

    public void updateAGR(@PathVariable("Id") int Id, @RequestBody AGR agr){
        agr.setId(Id);
        repository.save(agr);
    }

    public void deleteAGR(@PathVariable("Id") int Id){
        repository.deleteById(Id);
    }

}
