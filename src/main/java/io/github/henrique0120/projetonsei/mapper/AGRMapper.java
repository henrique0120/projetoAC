package io.github.henrique0120.projetonsei.mapper;

import io.github.henrique0120.projetonsei.dto.AGRDTO;
import io.github.henrique0120.projetonsei.model.AGR;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AGRMapper {

    AGR toEntity(AGRDTO dto);
    AGRDTO toDTO(AGR agr);

}
