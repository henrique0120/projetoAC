package io.github.henrique0120.projetonsei.service;

import io.github.henrique0120.projetonsei.config.TokenProvider;
import io.github.henrique0120.projetonsei.dto.request.RequestAuthLoginDTO;
import io.github.henrique0120.projetonsei.dto.request.RequestAuthRegisterDTO;
import io.github.henrique0120.projetonsei.dto.response.TokenResponseDTO;
import io.github.henrique0120.projetonsei.model.Roles;
import io.github.henrique0120.projetonsei.model.Users;
import io.github.henrique0120.projetonsei.repository.RolesRepository;
import io.github.henrique0120.projetonsei.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor

public class AuthenticationService{

    private final UsersRepository usersRepository;
    private final RolesRepository rolesRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;
    @Value("${jwt.expiration}")
    private long expirationTime;

    public void createUser(RequestAuthRegisterDTO dto) throws BadRequestException {

        Optional<Users> var =  usersRepository.findByEmail(dto.getEmail());

        if (var.isPresent()){
            throw new BadRequestException("Já existe um usuario cadastrado com esse e-mail.");
        }

        Roles role = rolesRepository.findByName(dto.getRole().name())
                .orElseGet(() -> rolesRepository.save(
                        Roles.builder()
                                .name(dto.getRole().name())
                                .build()
                ));

        System.out.println("ROLE ENCONTRADA: " + role.getName());

        usersRepository.save(Users.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .roles(Set.of(role))
                .build());
    }

    public TokenResponseDTO login(RequestAuthLoginDTO dto) throws Exception{
        try{
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
            String token = tokenProvider.generateToken(authentication);

            return new TokenResponseDTO(token, expirationTime);
        }
        catch (BadCredentialsException e){
            throw new BadRequestException("Credenciais inválidas");
        }catch (Exception e){
            throw new Exception("Erro interno inesperado: " + e.getMessage());
        }
    }

}
