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

import java.time.LocalDateTime;
import java.util.Optional;

import static io.github.henrique0120.projetonsei.enums.CertificateStatus.INSTALADO_COM_SUCESSO;


@Service
@AllArgsConstructor
@Slf4j
public class EmitionService {

        private final CertificateRepository repository;
        //private final Certificate certificate;
        private final AuthenticationManager manager;

        public ResponseEntity<Object> emit(RequestEmitionDTO dto) throws BadRequestException{
            var pass = repository.findByPassword(dto.password());
            var ticket = repository.findByTicket(dto.ticket());

            if(pass.isEmpty()){
                throw new BadRequestException("Password invalide");
            }
            if(ticket.isEmpty()){
                throw new BadRequestException("Ticket invalide");
            }

            var a = repository.findByTicketAndPassword(dto.ticket(), dto.password());
            Certificate certificate = a.get();
            certificate.setDataEmissao(LocalDateTime.now());

            switch(certificate.getType()) {
                case ECNPJ_A3, ECNPJ_A3_NUVEM,
                     ECPF_A3_NUVEM, ECPF_A3 -> certificate.setDataValidade(LocalDateTime.now().plusYears(3));
                case ECNPJ_A1, ECPF_A1, E_PJ, E_PF -> certificate.setDataValidade(LocalDateTime.now().plusYears(1));
            }

            certificate.setStatus(INSTALADO_COM_SUCESSO);

            repository.save(certificate);
            return ResponseEntity.ok().body(a);

        }

}
