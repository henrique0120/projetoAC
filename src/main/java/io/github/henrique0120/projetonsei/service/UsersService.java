package io.github.henrique0120.projetonsei.service;

import io.github.henrique0120.projetonsei.model.Users;
import io.github.henrique0120.projetonsei.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository repository;
    private final PasswordEncoder encoder;

    public void save(Users users){
        var senha = users.getPassword();
        users.setPassword(encoder.encode(senha));
        repository.save(users);
    }

    public Users findByName(String name){
        return repository.findByName(name);
    }

    public Users obterPorEmail(String email){
        return repository.findByEmail(email);
    }

}
