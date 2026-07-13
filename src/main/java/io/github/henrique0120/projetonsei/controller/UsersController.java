package io.github.henrique0120.projetonsei.controller;

import io.github.henrique0120.projetonsei.dto.request.RequestUsersDTO;
import io.github.henrique0120.projetonsei.mapper.UsersMapper;
import io.github.henrique0120.projetonsei.model.Users;
import io.github.henrique0120.projetonsei.service.UsersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService service;
    private final UsersMapper mapper;

    @PostMapping
    private ResponseEntity<Object> save (@RequestBody @Valid RequestUsersDTO dto){
        Users users = mapper.toEntity(dto);
        service.save(users);
        return ResponseEntity.ok().body(users);
    }

}
