package io.github.henrique0120.projetonsei.service;

import io.github.henrique0120.projetonsei.dto.request.RequestEmitionDTO;
import io.github.henrique0120.projetonsei.model.Certificate;
import io.github.henrique0120.projetonsei.repository.CertificateRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@Slf4j
public class EmitionService {

        private final CertificateRepository repository;
        private final AuthenticationManager manager;

        public ResponseEntity<Certificate> emit(RequestEmitionDTO dto){
            var a = repository.findByTicketAndPassword(dto.ticket(), dto.password());
              return ResponseEntity.ok().body(a);

        }

}
