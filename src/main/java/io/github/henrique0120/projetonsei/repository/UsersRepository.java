package io.github.henrique0120.projetonsei.repository;

import io.github.henrique0120.projetonsei.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<Users, UUID> {

    Optional<Users> findByName(String name);

    Optional<Users> findByEmail(String email);
}
