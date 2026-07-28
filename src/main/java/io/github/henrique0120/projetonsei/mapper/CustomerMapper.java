package io.github.henrique0120.projetonsei.mapper;

import io.github.henrique0120.projetonsei.dto.request.RequestCustomerDTO;
import io.github.henrique0120.projetonsei.dto.response.ResponseCustomerDTO;
import io.github.henrique0120.projetonsei.model.Customer;
import io.github.henrique0120.projetonsei.repository.AGRRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class CustomerMapper {

    @Autowired
    AGRRepository agrRepository;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "certificates", ignore = true)
    @Mapping(target = "agr", expression = "java(agrRepository.findById(dto.idAgr()).orElse(null))")
    public abstract Customer toEntity(RequestCustomerDTO dto);

    public abstract ResponseCustomerDTO toDTO(Customer customer);
}
