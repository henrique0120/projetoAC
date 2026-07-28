package io.github.henrique0120.projetonsei.mapper;

import io.github.henrique0120.projetonsei.dto.request.RequestCertificateDTO;
import io.github.henrique0120.projetonsei.model.Certificate;
import io.github.henrique0120.projetonsei.repository.CustomerRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class CertificateMapper{

    @Autowired
    CustomerRepository customerRepository;

    //@Mapping(target = "date", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "customer", expression = "java(customerRepository.findById(dto.idClient()).orElse(null))")
    public abstract Certificate toEntity(RequestCertificateDTO dto);

}
