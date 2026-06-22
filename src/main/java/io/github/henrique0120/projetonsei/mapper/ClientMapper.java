package io.github.henrique0120.projetonsei.mapper;

import io.github.henrique0120.projetonsei.dto.request.RequestClientDTO;
import io.github.henrique0120.projetonsei.dto.response.ResponseClientDTO;
import io.github.henrique0120.projetonsei.model.AGR;
import io.github.henrique0120.projetonsei.model.Client;
import io.github.henrique0120.projetonsei.repository.AGRRepository;
import io.github.henrique0120.projetonsei.repository.ClientRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ClientMapper {

    @Autowired
    AGRRepository agrRepository;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "certificates", ignore = true)
    @Mapping(target = "agr", expression = "java(agrRepository.findById(dto.idAgr()).orElse(null))")
    public abstract Client toEntity(RequestClientDTO dto);

    public abstract ResponseClientDTO toDTO(Client client);
}
