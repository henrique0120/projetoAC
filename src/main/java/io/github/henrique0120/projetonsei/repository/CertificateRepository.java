package io.github.henrique0120.projetonsei.repository;

import io.github.henrique0120.projetonsei.model.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate,Integer> {
}
