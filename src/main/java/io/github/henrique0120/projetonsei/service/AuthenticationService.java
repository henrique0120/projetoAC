package io.github.henrique0120.projetonsei.service;

import io.github.henrique0120.projetonsei.dto.request.RequestAuthRegisterDTO;
import io.github.henrique0120.projetonsei.enums.RoleType;
import io.github.henrique0120.projetonsei.model.Roles;
import io.github.henrique0120.projetonsei.model.Users;
import io.github.henrique0120.projetonsei.repository.RolesRepository;
import io.github.henrique0120.projetonsei.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor

public class AuthenticationService{

    private final UsersRepository usersRepository;
    private final RolesRepository rolesRepository;
    private final PasswordEncoder passwordEncoder;

    public void createUser(RequestAuthRegisterDTO dto) throws BadRequestException {

        Roles role = rolesRepository.findByName(RoleType.ROLE_AGR.name())
                .orElseGet(() -> rolesRepository.save(Roles.builder()
                        .name(RoleType.ROLE_AGR.name())
                        .build()));

        usersRepository.save(Users.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .roles(Set.of(role))
                .build());


    }

}
