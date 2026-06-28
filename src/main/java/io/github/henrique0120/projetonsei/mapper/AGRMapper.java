package io.github.henrique0120.projetonsei.mapper;

import io.github.henrique0120.projetonsei.dto.request.RequestAgrDTO;
import io.github.henrique0120.projetonsei.model.AGR;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class AGRMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "clients", ignore = true)
    public abstract AGR toEntity(RequestAgrDTO dto);
    public abstract RequestAgrDTO toDTO(AGR agr);

}
