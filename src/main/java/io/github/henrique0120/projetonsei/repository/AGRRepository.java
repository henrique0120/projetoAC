package io.github.henrique0120.projetonsei.repository;

import io.github.henrique0120.projetonsei.model.AGR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AGRRepository extends JpaRepository<AGR, Integer> {



}
