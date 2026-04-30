package io.github.henrique0120.projetonsei.repository;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ACRespository extends JpaRepository<Long, Id> {
}
