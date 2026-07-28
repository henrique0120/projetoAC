package io.github.henrique0120.projetonsei.mapper;

import io.github.henrique0120.projetonsei.dto.request.RequestClientDTO;
import io.github.henrique0120.projetonsei.model.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ClientMapper {


    public abstract Client toEntity(RequestClientDTO dto);
    public abstract RequestClientDTO toDTO(Client client);


}
