package io.github.henrique0120.projetonsei.mapper;

import io.github.henrique0120.projetonsei.dto.request.RequestClientDTO;
import io.github.henrique0120.projetonsei.dto.request.RequestUserDTO;
import io.github.henrique0120.projetonsei.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    @Mapping(target = "id", ignore = true)
    public abstract User toEntity(RequestUserDTO dto);
    public abstract RequestClientDTO toDTO(User user);

}
