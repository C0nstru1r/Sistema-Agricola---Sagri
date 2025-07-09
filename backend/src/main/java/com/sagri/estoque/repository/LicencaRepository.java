package com.sagri.estoque.repository;

import com.sagri.estoque.model.Licenca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicencaRepository extends JpaRepository<Licenca, Long> {
}