package io.github.henrique0120.projetonsei.controller;

import io.github.henrique0120.projetonsei.dto.request.RequestAuthLoginDTO;
import io.github.henrique0120.projetonsei.dto.request.RequestAuthRegisterDTO;
import io.github.henrique0120.projetonsei.dto.response.TokenResponseDTO;
import io.github.henrique0120.projetonsei.model.Users;
import io.github.henrique0120.projetonsei.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService service;

    @PostMapping("save")
    public ResponseEntity<Users> save(@RequestBody @Valid RequestAuthRegisterDTO dto) throws BadRequestException {

        service.createUser(dto);
        return ResponseEntity.ok().build();

    }

    @PostMapping("login")
    public TokenResponseDTO login(@RequestBody @Valid RequestAuthLoginDTO dto) throws Exception {
        return service.login(dto);
    }


}
