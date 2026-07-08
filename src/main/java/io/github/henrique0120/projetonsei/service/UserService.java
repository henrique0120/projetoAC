package io.github.henrique0120.projetonsei.service;

import io.github.henrique0120.projetonsei.model.User;
import io.github.henrique0120.projetonsei.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User save (User user){
        return repository.save(user);
    }

}
