package io.github.henrique0120.projetonsei.mapper;

import io.github.henrique0120.projetonsei.dto.request.RequestClientDTO;
import io.github.henrique0120.projetonsei.dto.request.RequestUsersDTO;
import io.github.henrique0120.projetonsei.model.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class UsersMapper {

    @Mapping(target = "id", ignore = true)
    public abstract Users toEntity(RequestUsersDTO dto);
    public abstract RequestClientDTO toDTO(Users users);

}
