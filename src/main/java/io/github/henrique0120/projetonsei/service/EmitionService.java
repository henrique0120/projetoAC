package io.github.henrique0120.projetonsei.service;

import io.github.henrique0120.projetonsei.dto.request.RequestEmitionDTO;
import io.github.henrique0120.projetonsei.model.Certificate;
import io.github.henrique0120.projetonsei.repository.CertificateRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class EmitionService {

        private final Certificate certificate;
        private final CertificateRepository repository;
        private final AuthenticationManager manager;
        //private final RequestEmitionDTO dto;

        public RequestEmitionDTO emit(RequestEmitionDTO dto) throws BadRequestException {
              Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(dto.ticket(), dto.password()));

              if (authentication.isAuthenticated()) {
                      log.info("Autenticado");
              }
              else {
                      throw new BadRequestException("Authentication failed");
              }

              return dto;

        }

}
