package io.github.henrique0120.projetonsei.controller;

import io.github.henrique0120.projetonsei.dto.request.RequestUserDTO;
import io.github.henrique0120.projetonsei.mapper.UserMapper;
import io.github.henrique0120.projetonsei.model.User;
import io.github.henrique0120.projetonsei.service.UserService;
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
public class UserController {

    private final UserService service;
    private final UserMapper mapper;

    @PostMapping
    private ResponseEntity<Object> save (@RequestBody @Valid RequestUserDTO dto){
        User user = mapper.toEntity(dto);
        service.save(user);
        return ResponseEntity.ok().body(user);
    }

}
